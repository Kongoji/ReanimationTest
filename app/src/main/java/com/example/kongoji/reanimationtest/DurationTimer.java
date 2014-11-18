package com.example.kongoji.reanimationtest;

import android.app.ActionBar;
import android.os.Handler;

/**
 * Created by Kongoji on 17.10.14.
 */
public class DurationTimer {

    private ActionBar bar;
    private Handler mHandler = new Handler();
    private long startTime;

    public long getElapsedTime() {
        return elapsedTime;
    }

    private long elapsedTime;
    private final int REFRESH_RATE = 100;
    private String minutes, seconds;
    private long secs;

    public boolean isRunning() {
        return running;
    }

    private boolean running = false;

    private DurationTimer() {
    }

    private static DurationTimer instance;

    public static DurationTimer getInstance() {
        if (instance == null) {
            instance = new DurationTimer();
        }
        return instance;
    }

    public void setDestination(ActionBar bar) {
        this.bar = bar;
    }


    // public DurationTimer(ActionBar bar) {
    //    this.bar = bar;
    //  }


    public void startTimer() {
        running = true;
        startTime = System.currentTimeMillis();
        mHandler.removeCallbacks(startTimer);
        mHandler.postDelayed(startTimer, 0);
    }


    public void resetTimer() {
        mHandler.removeCallbacks(startTimer);
        //bar.setTitle("Reanimation (Einsatz läuft seit: " + "00" + " Minuten)");
    }

    public void stopTimer() {
        running = false;
        mHandler.removeCallbacks(startTimer);
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
        long mins = (long) ((time / 1000) / 60);


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
        bar.setTitle("DoRea (Einsatz läuft seit: " + seconds + " Minuten)");
        //return "Reanimation (Einsatz läuft seit: " + minutes + " Minuten";

    }
}
