package com.example.kongoji.reanimationtest;

import android.util.Log;
import android.widget.RadioButton;

import com.example.kongoji.reanimationtest.segmentedButton.SegmentedGroup;

/**
 * Created by Kongoji on 23.10.14.
 */
public class ReanimationSegmentedButtonCommand extends ReanimationCommand {

    private SegmentedGroup radio;
    private RadioButton hdm;
    private RadioButton rosc;
    private RadioButton selectedButton;
    private String logInfo;


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


        if (selectedButton != null) {
            radio.setCounter(radio.getCounter() + 1);

            notifyUser(selectedButton.getContext(), selectedButton.getText() + " durchgeführt");
            Log.d("Event:" + String.valueOf(selectedButton.getText()), TimeStampGenerator.getTimeStamp());
            logInfo = String.valueOf(TimeStampGenerator.getTimeStamp() + " : " + selectedButton.getText() + ";");


        } else {
            Log.d("Event:" + "Nether HDM or ROSC selected", TimeStampGenerator.getTimeStamp());
        }
    }

    //@Tudo
    @Override
    public void undo() {


        radio.setNonUserSelection(true);

        radio.setCounter(radio.getCounter() - 1);

        notifyUser(selectedButton.getContext(), selectedButton.getText() + " rückgängig gemacht");

        if (radio.getCounter() == 0) {


            radio.clearCheck();


        } else {

            if (R.id.hdm == selectedButton.getId()) {
                hdm.toggle();
                rosc.toggle();
                rosc.performClick();

            } else {
                hdm.toggle();
                rosc.toggle();
                hdm.performClick();
            }

        }

        radio.setNonUserSelection(false);
    }

    @Override
    public String getLogInfo() {
        return logInfo;
    }
}