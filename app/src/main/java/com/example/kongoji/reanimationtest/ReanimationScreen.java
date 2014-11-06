package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kongoji.reanimationtest.segmentedButton.SegmentedGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;


public class ReanimationScreen extends FragmentActivity implements CommandManager {


    //is App still running?
    private boolean stopped = false;
    //is REA still ongoing?
    private boolean isDone = false;
    //timer tasks
    private Chronometer chronoDefi;
    private Chronometer chronoAdrenalin;
    private DurationTimer chronoDuration;
    //actionbar description
    private Menu mMenu;

    private Stack<ReanimationCommand> commandStack = new Stack<ReanimationCommand>();


    //used for handling battery status triggered arrival
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
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
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reanimation_screen);

        chronoDefi = (Chronometer) findViewById(R.id.chronoDefi);
        chronoDefi.setBase(SystemClock.elapsedRealtime());

        chronoAdrenalin = (Chronometer) findViewById(R.id.chronoAdrenalin);
        chronoAdrenalin.setBase(SystemClock.elapsedRealtime());

        final SegmentedGroup segmented2 = (SegmentedGroup) findViewById(R.id.segmented2);
        segmented2.setTintColor(Color.DKGRAY);
        segmented2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                if (segmented2.isFirstROSC() == false) {
                    segmented2.setFirstROSC(true);

                }
                logSegmentedButtonEvent(radioGroup, i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reanimation_screen, menu);
        this.mMenu = menu;
        chronoDuration = new DurationTimer(mMenu.findItem(R.id.statusTextview));

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        this.getApplicationContext().registerReceiver(mBroadcastReceiver, ifilter);
        return super.onCreateOptionsMenu(menu);
    }


    public void incrementCounter(View view) {

        if (view.getId() == R.id.defi) {

            executeCommand(new ReanimationIncrementCommand((TextView) findViewById(R.id.counterDefi), chronoDefi));


        } else {

            executeCommand(new ReanimationIncrementCommand((TextView) findViewById(R.id.counterAdrenalin), chronoAdrenalin));

        }
    }

    public void logEvent(View view) {

        executeCommand(new ReanimationToggleButtonCommand((Button) view));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.undo) {
            undoCommand();
            return true;
        } else if (id == R.id.reaabruch) {
            endReanimation();
            return true;
        }

       /* else if (id == R.id.beenden) {
            chronoAdrenalin.stop();
            chronoDefi.stop();
            if (!isDone){
                endReanimation();
            }
            else{
                startDocumentation();
            }

            return true;
        }*/


        return super.onOptionsItemSelected(item);
    }


    public void endReanimation() {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Wie möchten Sie die Reanimation abschließen?");

        Calendar c = Calendar.getInstance();


        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Patient übergeben", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Event loggen
                        //  isDone = true;
                        startDocumentation();
                        //MainActivity.this.finish();
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
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        //  isDone = true;
                        startDocumentation();
                    }
                });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }


    public void startDocumentation() {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Möchten Sie ihren Einsatz gleich dokumentieren?");


        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Einsatz dokumentieren", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id) {
                        //start documentation
                        Dialog dialog = (Dialog) dialogInterface;
                        Context context = dialog.getContext();
                        Intent intenti = new Intent(context, DocumentationActivity.class);
                        startActivity(intenti);

                    }
                })
                .setNegativeButton("Einsatz beenden und später dokumentieren", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


    public void logSegmentedButtonEvent(View view, int i) {
        executeCommand(new ReanimationSegmentedButtonCommand((SegmentedGroup) view, i));
    }

    @Override
    public void executeCommand(ReanimationCommand command) {
        command.execute();
        commandStack.push(command);
    }

    @Override
    public void undoCommand() {
        if (commandStack.size() > 0) {
            ReanimationCommand undoableCommand = commandStack.pop();
            undoableCommand.undo();
        }
    }
}

