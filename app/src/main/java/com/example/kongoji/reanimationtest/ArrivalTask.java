package com.example.kongoji.reanimationtest;

import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Kongoji on 17.10.14.
 */
public class ArrivalTask {

    private Handler mHandler = new Handler();
    private long startTime;
    private long elapsedTime;
    private final int REFRESH_RATE = 100;
    private String minutes, seconds;
    private long secs, mins;


    private MenuItem timerItem;

    public ArrivalTask(MenuItem item) {

        this.timerItem = item;
    }


    public void startTimer() {

        startTime = System.currentTimeMillis();
        mHandler.removeCallbacks(startTimer);
        mHandler.postDelayed(startTimer, 0);
    }


    public void resetTimer() {
        mHandler.removeCallbacks(startTimer);
        timerItem.setTitle("Einsatzdauer: 00 Minuten");
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
        timerItem.setTitle("Einsatzdauer: " + minutes + " Minuten");

    }


}
