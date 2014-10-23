package com.example.kongoji.reanimationtest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielreinhardt on 20.10.14.
 */
public class ReanimationIncrementCommand extends ReanimationCommand {

    private static final int N = 7;
    private TextView counter;
    private int count = 0;
    private long time;

    private Chronometer chronometer;

    public ReanimationIncrementCommand(TextView counter, Chronometer chronometer) {
        this.counter = counter;

        this.count = Integer.parseInt(String.valueOf(counter.getText()));
        this.chronometer = chronometer;

        this.time = chronometer.getBase();

    }

    @Override
    public void execute() {


        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());

        counter.setText(String.valueOf(++count));
        Log.d("Event: " + String.valueOf(counter.getText()), getTimeStamp());
        Log.d("Event: " + String.valueOf(time), getTimeStamp());

        chronometer.start();

    }

    @Override
    public void undo() {


        chronometer.setBase(time);
        this.counter.setText(String.valueOf(--count));

        Log.d("Undo Event: " + String.valueOf(counter.getText()), getTimeStamp());
    }
}
