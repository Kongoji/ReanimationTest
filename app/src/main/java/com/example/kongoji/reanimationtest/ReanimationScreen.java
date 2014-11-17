package com.example.kongoji.reanimationtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.kongoji.reanimationtest.segmentedButton.SegmentedGroup;

import java.util.Calendar;
import java.util.Stack;


public class ReanimationScreen extends StartScreen implements CommandManager, RotationGestureDetector.OnRotationGestureListener {

    //only one undoable function
    private boolean undoableOnlyOnetime = true;

    private static final int TIME_FOR_DEFI_TIMER_COLOR_CHANGE = 120;
    private static final int TIME_FOR_ADRENALIN_TIMER_COLOR_CHANGE = 180;

    //timer tasks
    private Chronometer chronoDefi;
    private Chronometer chronoAdrenalin;
   // private DurationTimer chronoDuration;

    private ReanimationStorageManager storageManager;


    //Gestenerkennung
    private RotationGestureDetector detector;
    //UNDO-Stack
    private Stack<ReanimationCommand> commandStack = new Stack<ReanimationCommand>();


    //TUDO: Muss noch in den Start Screen
    //used for handling battery status triggered arrival
   /* private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL;
            ReanimationScreen.this.receivedBroadcast(intent, isCharging);
        }
    };

    //start timer when not plugged in
    private void receivedBroadcast(Intent intent, boolean charged) {
        if (charged == false) {
            // Turn progressbar on
            chronoDuration.startTimer();
        }
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reanimation_screen);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Log.e("zack", String.valueOf(Environment.getExternalStorageDirectory()));
        detector = new RotationGestureDetector(this);
        storageManager = ReanimationStorageManager.getInstance(this);

        chronoDefi = (Chronometer) findViewById(R.id.chronoDefi);
        chronoDefi.setBase(SystemClock.elapsedRealtime());
        chronoDefi.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {


                if (getSecondsFromDurationString(String.valueOf(chronometer.getText())) > TIME_FOR_DEFI_TIMER_COLOR_CHANGE) {
                    changeTimeTextColor(chronometer);
                }


            }
        });

        chronoAdrenalin = (Chronometer) findViewById(R.id.chronoAdrenalin);
        chronoAdrenalin.setBase(SystemClock.elapsedRealtime());
        chronoAdrenalin.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (getSecondsFromDurationString(String.valueOf(chronometer.getText())) > TIME_FOR_ADRENALIN_TIMER_COLOR_CHANGE) {
                    changeTimeTextColor(chronometer);
                }
            }
        });


        final SegmentedGroup segmented2 = (SegmentedGroup) findViewById(R.id.segmented2);
        // segmented2.setTintColor(Color.DKGRAY);


        segmented2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                if (!segmented2.isNonUserSelection()) {
                    //get only on the stack if ui-triggered
                    logSegmentedButtonEvent(radioGroup, i);

                }

            }
        });
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reanimation_screen, menu);
        chronoDuration = new DurationTimer(this.getActionBar());

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        this.getApplicationContext().registerReceiver(mBroadcastReceiver, ifilter);
        return super.onCreateOptionsMenu(menu);
    }*/


    public void incrementCounter(View view) {
        ReanimationCommand command;
        if (view.getId() == R.id.defi) {

            command = new ReanimationIncrementCommand((TextView) findViewById(R.id.counterDefi), chronoDefi);


        } else {
            command = new ReanimationIncrementCommand((TextView) findViewById(R.id.counterAdrenalin), chronoAdrenalin);


        }
        executeCommand(command);

    }

    public void logEvent(View view) {
        ReanimationCommand command = new ReanimationToggleButtonCommand((Button) view);
        executeCommand(command);
    }

    public void logSegmentedButtonEvent(View view, int i) {
        ReanimationCommand command = new ReanimationSegmentedButtonCommand((SegmentedGroup) view, i);
        executeCommand(command);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.reaabruch) {
            endReanimation();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    public void endReanimation() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Wie möchten Sie die Reanimation abschließen?");

        Calendar c = Calendar.getInstance();
        final String timeStamp = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);


        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Patient übergeben", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        storageManager.cache(timeStamp + " : " + "Patient übergeben;");
                        startDocumentation();

                    }
                })
                .setNeutralButton("Reanimation fortsetzen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //undo
                        dialog.cancel();
                    }
                })

                .setNegativeButton("Reanimation des Patienten abbrechen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        storageManager.cache(timeStamp + " : " + "Reanimation des Patienten abgebrochen;");
                        startDocumentation();
                    }
                });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public void OnRotation(RotationGestureDetector rotationDetector) {
        float angle = rotationDetector.getAngle();
        if (angle > 45) {
            undoCommand();
        } else {
            return;
        }
    }


    public void startDocumentation() {

        Calendar c = Calendar.getInstance();
        String timeStamp = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        storageManager.cache(timeStamp + " : " + "Einsatz wurde beendet;");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Möchten Sie ihren Einsatz gleich dokumentieren?");

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Einsatz dokumentieren", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id) {
                        //start documentation and kill threads before
                        chronoDuration.stopTimer();
                        chronoAdrenalin.stop();
                        chronoDefi.stop();
                        Dialog dialog = (Dialog) dialogInterface;
                        Context context = dialog.getContext();
                        Intent intenti = new Intent(context, DocumentationActivity.class);
                        startActivity(intenti);
                        finish();
                    }
                })
                .setNegativeButton("Einsatz beenden und später dokumentieren", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });


        storageManager.save();
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


    @Override
    public void executeCommand(ReanimationCommand command) {
        undoableOnlyOnetime = true;
        command.execute();
        commandStack.push(command);
        Log.e("LogInfo", command.getLogInfo());
        storageManager.cache(command.getLogInfo());
    }

    @Override
    public void undoCommand() {
        if (commandStack.size() > 0 && undoableOnlyOnetime) {
            undoableOnlyOnetime = false;
            ReanimationCommand undoableCommand = commandStack.pop();
            undoableCommand.undo();
            storageManager.undoCache();
        }
    }

    public int getSecondsFromDurationString(String value) {

        String[] parts = value.split(":");

        // Wrong format, no value for you.
        if (parts.length < 2 || parts.length > 3)
            return 0;

        int seconds = 0, minutes = 0, hours = 0;

        if (parts.length == 2) {
            seconds = Integer.parseInt(parts[1]);
            minutes = Integer.parseInt(parts[0]);
        } else if (parts.length == 3) {
            seconds = Integer.parseInt(parts[2]);
            minutes = Integer.parseInt(parts[1]);
            hours = Integer.parseInt(parts[1]);
        }

        return seconds + (minutes * 60) + (hours * 3600);
    }

    public void changeTimeTextColor(Chronometer chronometer) {
        chronometer.setTextColor(Color.parseColor("#FF4444"));
    }

    @Override
    public void onBackPressed() {
    }
}