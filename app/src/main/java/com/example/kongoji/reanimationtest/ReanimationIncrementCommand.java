package com.example.kongoji.reanimationtest;

import android.graphics.Color;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.TextView;

/**
 * Created by danielreinhardt on 20.10.14.
 */
public class ReanimationIncrementCommand extends ReanimationCommand {

    private static final int N = 7;
    private TextView counter;
    private int count = 0;
    private long time;
    private String logInfo;

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
        chronometer.setTextColor(Color.BLACK);

        counter.setText(String.valueOf(++count));
        logInfo = String.valueOf(getTimeStamp() + " : " + counter.getText()+";");
        Log.d("Event: " + String.valueOf(counter.getText()), getTimeStamp());
        Log.d("Event: " + String.valueOf(time), getTimeStamp());

        chronometer.start();

        if (R.id.counterDefi == counter.getId()) {
            notifyUser(counter.getContext(), "Defibrillation " + counter.getText() + " durchgeführt");

        } else {
            notifyUser(counter.getContext(), "Adrenalin " + counter.getText() + " gegeben");
        }


    }

    @Override
    public void undo() {


        chronometer.setBase(time);
        this.counter.setText(String.valueOf(--count));

        Log.d("Undo Event: " + String.valueOf(counter.getText()), getTimeStamp());

        if (R.id.counterDefi == counter.getId()) {
            notifyUser(counter.getContext(), "Defibrillation " + counter.getText() + " rückgängig gemacht");

        } else {
            notifyUser(counter.getContext(), "Adrenalin " + counter.getText() + " rückgängig gemacht");
        }


    }

    @Override
    public String getLogInfo() {
        return logInfo;
    }
}
