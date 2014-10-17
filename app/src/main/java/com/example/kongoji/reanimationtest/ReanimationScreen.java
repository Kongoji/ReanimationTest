package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ReanimationScreen extends Activity {

    private Handler mHandler = new Handler();
    private long startTime;
    private long elapsedTime;
    private final int REFRESH_RATE = 100;
    private String minutes, seconds;
    private long secs, mins;
    private boolean stopped = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reanimation_screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reanimation_screen, menu);

        return super.onCreateOptionsMenu(menu);
    }


    public void incrementCounter(View view) {

        Calendar c = Calendar.getInstance();
        int mhour = c.get(Calendar.HOUR);
        int mminute = c.get(Calendar.MINUTE);
        int msecond = c.get(Calendar.SECOND);


        int tpCounter;
        final TextView counterView;

        if (view.getId() == R.id.defi) {

            counterView = (TextView) findViewById(R.id.counterDefi);
            tpCounter = Integer.parseInt(counterView.getText().toString());

            stopped = false;
            startTimer();


        } else {

            counterView = (TextView) findViewById(R.id.counterAdrenalin);
            tpCounter = Integer.parseInt(counterView.getText().toString());

            stopped = true;


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
                resetTimer();
                if (!stopped){
                    startTimer();
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

    private void startTimer() {

        startTime = System.currentTimeMillis();

        stopped = false;
        mHandler.removeCallbacks(startTimer);
        mHandler.postDelayed(startTimer, 0);
    }


    public void resetTimer() {
        mHandler.removeCallbacks(startTimer);
        ((TextView) findViewById(R.id.timerDefi)).setText("00:00");
    }


    private Runnable startTimer = new Runnable() {
        public void run() {
            elapsedTime = System.currentTimeMillis() - startTime;
            updateTimer(elapsedTime);
            mHandler.postDelayed(this, REFRESH_RATE);
        }
    };

    private void updateTimer(float time) {
        secs = (long) (time / 1000);
        mins = (long) ((time / 1000) / 60);


		/* Convert the seconds to String
         * and format to ensure it has
		 * a leading zero when required
		 */
        secs = secs % 60;
        seconds = String.valueOf(secs);
        if (secs == 0) {
            seconds = "00";
        }
        if (secs < 10 && secs > 0) {
            seconds = "0" + seconds;
        }

		/* Convert the minutes to String and format the String */

        mins = mins % 60;
        minutes = String.valueOf(mins);
        if (mins == 0) {
            minutes = "00";
        }
        if (mins < 10 && mins > 0) {
            minutes = "0" + minutes;
        }


		/* Setting the timer text to the elapsed time */
        ((TextView) findViewById(R.id.timerDefi)).setText(minutes + ":" + seconds);

    }


}
