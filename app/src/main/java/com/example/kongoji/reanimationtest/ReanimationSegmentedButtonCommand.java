package com.example.kongoji.reanimationtest;

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

        int oldCounter = radio.getCounter();
        radio.setCounter(++oldCounter);

        if (selectedButton != null) {
            Log.d("Event:" + String.valueOf(selectedButton.getText()), getTimeStamp());


        } else {
            Log.d("Event:" + "Nether HDM or ROSC selected", getTimeStamp());
        }


        Log.e("Event:" + String.valueOf(radio.getCounter()), getTimeStamp());
    }

    @Override
    public void undo() {

        int oldCounter = radio.getCounter()-1;
        radio.setCounter(oldCounter);

        if (radio.getCounter() == 1) {

            //both deselect
            hdm.setChecked(false);
            hdm.setActivated(false);
            rosc.setChecked(false);
            rosc.setActivated(false);

        } else {
            hdm.setChecked(true);
            hdm.setActivated(true);
            rosc.setChecked(true);
            rosc.setActivated(true);
            selectedButton.setChecked(false);
            selectedButton.setActivated(false);
            selectedButton.setActivated(false);
            selectedButton.setActivated(false);

            Log.e("Timmy:" + String.valueOf(selectedButton.getText()), getTimeStamp());
        }


        Log.e("Event:" + String.valueOf(selectedButton.getText()), getTimeStamp());
        Log.e("Event:" + String.valueOf(radio.getCounter()), getTimeStamp());
    }
}
