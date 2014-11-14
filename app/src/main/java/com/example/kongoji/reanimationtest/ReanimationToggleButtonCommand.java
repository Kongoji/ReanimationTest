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
    private String logInfo;

    public ReanimationToggleButtonCommand(Button button) {
        this.button = button;
        isItOn = button.isEnabled();
    }


    @Override
    public void execute() {
        this.button.setEnabled(false);
        this.button.setBackgroundResource(R.drawable.buttonshape_clicked);
        this.button.setTextColor(Color.WHITE);
        Log.d("Event:" + String.valueOf(button.getText()), getTimeStamp());
        logInfo = String.valueOf(getTimeStamp() + " : " + button.getText() +";");
        notifyUser(button.getContext(), button.getText() + " durchgeführt");
    }

    @Override
    public void undo() {

        this.button.setEnabled(isItOn);
        this.button.setBackgroundResource(R.drawable.buttonshape);
        this.button.setTextColor(Color.BLACK);
        Log.d("Event:" + String.valueOf("Undo:" + button.getText()), getTimeStamp());
        notifyUser(button.getContext(), button.getText() + " rückgängig gemacht");
    }

    @Override
    public String getLogInfo() {
        return logInfo;
    }
}
