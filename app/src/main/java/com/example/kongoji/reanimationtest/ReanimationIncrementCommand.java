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

    public ReanimationIncrementCommand (TextView counter, String title){
        this.counter = counter;
        this.title = title;
        this.count = Integer.parseInt(String.valueOf(counter.getText()));

    }

    @Override
    public void execute() {

        List<String> listItems = new ArrayList<String>();


        for (int d = count + 1; d < N; d++) {
            listItems.add(String.valueOf(d));
        }

        final CharSequence[] items = listItems.toArray(new CharSequence[listItems.size()]);


        AlertDialog.Builder builder = new AlertDialog.Builder(counter.getContext());
        builder.setTitle(this.title);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                counter.setText(items[item]);
            }
        });

        Log.d("Event: " + String.valueOf(counter.getText()),getTimeStamp());
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void undo() {
        this.counter.setText(String.valueOf(count));
    }
}
