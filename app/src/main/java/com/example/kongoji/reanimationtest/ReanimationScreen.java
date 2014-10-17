package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ReanimationScreen extends Activity {


    private boolean stopped = false;
    private TimerTask defiTask, adreniTask;
    private ArrivalTask arrivalTimer;
    private Menu mMenu;


    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            Log.d("Stopwatch1", "Status: " + status);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL;

            Log.d("Stopwatch1", "Laden: " + isCharging);
            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            Log.d("Stopwatch1", "INT: " + chargePlug);
            boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            Log.d("Stopwatch1", "USB: " + usbCharge);
            boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
            Log.d("Stopwatch1", "AC: " + acCharge);


            ReanimationScreen.this.receivedBroadcast(intent, isCharging);
        }
    };

    private void receivedBroadcast(Intent intent, boolean charged) {
        if (charged == false) {
            // Turn progressbar on
            arrivalTimer.startTimer();
            setProgressBarIndeterminateVisibility(true);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_reanimation_screen);
        defiTask = new TimerTask((TextView) findViewById(R.id.timerDefi));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reanimation_screen, menu);
        this.mMenu = menu;
        adreniTask = new TimerTask((TextView) findViewById(R.id.timerAdrenalin));
        arrivalTimer = new ArrivalTask(mMenu.findItem(R.id.statusTextview));
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        this.getApplicationContext().registerReceiver(mBroadcastReceiver, ifilter);
        return super.onCreateOptionsMenu(menu);
    }


    public void incrementCounter(View view) {

        Calendar c = Calendar.getInstance();
        int mhour = c.get(Calendar.HOUR);
        int mminute = c.get(Calendar.MINUTE);
        int msecond = c.get(Calendar.SECOND);

        final TimerTask tempTask;

        int tpCounter;
        final TextView counterView;

        if (view.getId() == R.id.defi) {

            counterView = (TextView) findViewById(R.id.counterDefi);
            tpCounter = Integer.parseInt(counterView.getText().toString());

            stopped = false;
            defiTask.startTimer();
            tempTask = defiTask;


        } else {

            counterView = (TextView) findViewById(R.id.counterAdrenalin);
            tpCounter = Integer.parseInt(counterView.getText().toString());

            stopped = false;
            adreniTask.startTimer();
            tempTask = adreniTask;


        }

        Log.d("Event: " + findViewById(view.getId()), mhour + ":" + mminute + ":" + msecond);

        List<String> listItems = new ArrayList<String>();


        for (int d = tpCounter + 1; d < 7; d++) {
            listItems.add(String.valueOf(d));
        }

        final CharSequence[] items = listItems.toArray(new CharSequence[listItems.size()]);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welche Reanimation hast du durchgeführt?");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                counterView.setText(items[item]);
                tempTask.resetTimer();
                if (!stopped) {
                    tempTask.startTimer();
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();


    }

    public void logEvent(View view) {


        Calendar c = Calendar.getInstance();
        int mhour = c.get(Calendar.HOUR);
        int mminute = c.get(Calendar.MINUTE);
        int msecond = c.get(Calendar.SECOND);

        String event = "";
        Button button;
        switch (view.getId()) {

            case R.id.hdm:
                button = (Button) findViewById(R.id.hdm);
                button.setEnabled(false);
                button.setBackgroundColor(Color.GREEN);
                event = String.valueOf(button.getText());
                break;
            case R.id.iv:
                button = (Button) findViewById(R.id.iv);
                button.setEnabled(false);
                button.setBackgroundColor(Color.GREEN);
                event = String.valueOf(button.getText());
                break;
            case R.id.io:
                button = (Button) findViewById(R.id.io);
                button.setEnabled(false);
                button.setBackgroundColor(Color.GREEN);
                event = String.valueOf(button.getText());
                break;
            case R.id.intubation:
                button = (Button) findViewById(R.id.intubation);
                button.setEnabled(false);
                button.setBackgroundColor(Color.GREEN);
                event = String.valueOf(button.getText());
                break;
            case R.id.rosc:
                button = (Button) findViewById(R.id.rosc);
                button.setEnabled(false);
                button.setBackgroundColor(Color.GREEN);
                event = String.valueOf(button.getText());
                break;

            default:
                Log.d("Error:", String.valueOf(view.getId()));
                break;
        }


        Log.d("Event: " + event, mhour + ":" + mminute + ":" + msecond);


    }

    public void startDocumentation() {

        Intent intenti = new Intent(this, DocumentationScreenListActivity.class);
        startActivity(intenti);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.erstbefund) {
            startDocumentation();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
