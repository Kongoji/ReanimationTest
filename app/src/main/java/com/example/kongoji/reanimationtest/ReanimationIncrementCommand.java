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
    private String title;

    public ReanimationIncrementCommand(TextView counter, String title) {
        this.counter = counter;
        this.title = title;
        this.count = Integer.parseInt(String.valueOf(counter.getText()));

    }

    @Override
    public void execute() {

        counter.setText(String.valueOf(++count));
        Log.d("Event: " + String.valueOf(counter.getText()), getTimeStamp());

    }

    @Override
    public void undo() {
        this.counter.setText(String.valueOf(count));
    }
}
