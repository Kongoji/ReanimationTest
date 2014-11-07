package com.example.kongoji.reanimationtest;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;

import java.util.Calendar;

/**
 * Created by danielreinhardt on 20.10.14.
 */
public class ReanimationToggleButtonCommand extends ReanimationCommand {

    private Button button;
    private boolean isItOn = true;

    public ReanimationToggleButtonCommand(Button button) {
        this.button = button;
        isItOn = button.isEnabled();
    }


    @Override
    public void execute() {
        button.setEnabled(false);
        button.setBackgroundColor(Color.GREEN);
        Log.d("Event:" + String.valueOf(button.getText()), getTimeStamp());


        notifyUser(button.getContext(), button.getText() + " durchgeführt");


    }

    @Override
    public void undo() {

        this.button.setEnabled(isItOn);
        this.button.setBackgroundResource(android.R.drawable.btn_default);
        Log.d("Event:" + String.valueOf("Undo:" + button.getText()), getTimeStamp());
        notifyUser(button.getContext(), button.getText() + " rückgängig gemacht");

    }
}
