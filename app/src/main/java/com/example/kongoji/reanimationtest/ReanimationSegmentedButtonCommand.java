package com.example.kongoji.reanimationtest;

import android.graphics.Color;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.kongoji.reanimationtest.segmentedButton.SegmentedGroup;

/**
 * Created by Kongoji on 23.10.14.
 */
public class ReanimationSegmentedButtonCommand extends ReanimationCommand {

    private SegmentedGroup radio;
    private RadioButton hdm;
    private RadioButton rosc;
    private RadioButton selectedButton;
    private boolean firstTime;

    public ReanimationSegmentedButtonCommand(SegmentedGroup radio, int i) {
        this.radio = radio;
        this.hdm = (RadioButton) radio.getChildAt(0);
        this.rosc = (RadioButton) radio.getChildAt(1);
        this.firstTime = radio.isFirstROSC();

        if (i == R.id.hdm) {
            this.selectedButton = hdm;


        } else if (i == R.id.rosc) {
            this.selectedButton = rosc;


        }

        //nothing selected
        else {
            selectedButton = null;

        }
    }

    @Override
    public void execute() {


        if (selectedButton != null) {
            Log.d("Event:" + String.valueOf(selectedButton.getText()), getTimeStamp());


        } else {
            Log.d("Event:" + "Nether HDM or ROSC selected", getTimeStamp());
        }
    }

    //@Tudo
    @Override
    public void undo() {


        if (firstTime) {

            //both deselect
            hdm.setChecked(false);
            hdm.setPressed(false);
            rosc.setChecked(false);
            rosc.setPressed(false);
            radio.setFirstROSC(false);

        } else {

            if (R.id.hdm == selectedButton.getId()) {
                hdm.setChecked(true);
                hdm.setPressed(true);
                rosc.setChecked(false);
                rosc.setPressed(false);
            } else {
                hdm.setChecked(false);
                hdm.setPressed(false);
                rosc.setChecked(true);
                rosc.setPressed(true);
            }

        }

      // radio.updateBackground();
        Log.e("Undo Event:" + String.valueOf(selectedButton.getText()), getTimeStamp());
    }
}