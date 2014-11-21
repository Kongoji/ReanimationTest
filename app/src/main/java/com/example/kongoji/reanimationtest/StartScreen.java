package com.example.kongoji.reanimationtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class StartScreen extends BaseActivity implements SeekBar.OnSeekBarChangeListener,View.OnClickListener {

    SeekBar sb;
    boolean flag = false;
    Button Confirm;
    TextView seekbartest;
    RelativeLayout page_background;




    //start timer when not plugged in
    public void receivedBroadcast(Intent intent, boolean charged) {


       // if (charged = true && DurationTimer.getInstance().isRunning()) {
         //goBack();
       // }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        DurationTimer.getInstance().setDestination(this.getActionBar());

        if (!DurationTimer.getInstance().isRunning()) {
            DurationTimer.getInstance().startTimer();
        }

        Initialization();
        sb.setOnSeekBarChangeListener(this);
        page_background.setOnClickListener(this);
    }




    private void goBack(){
        DurationTimer.getInstance().stopTimer();
        this.finish();
    }

    @Override
    public void onBackPressed() {
        DurationTimer.getInstance().stopTimer();
        super.onBackPressed();
    }

    private void Initialization() {
        sb = (SeekBar) findViewById(R.id.myseek);
        seekbartest = (TextView) findViewById(R.id.slider_text);
        Confirm = (Button) findViewById(R.id.after_slide_button);
        page_background = (RelativeLayout) findViewById(R.id.startView);
        seekbartest.setText(R.string.slidePatient);

    }

    @Override
    public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        if (arg1 > 95) {
            arg0.setThumb(getResources().getDrawable(R.drawable.slider_icon));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
        seekbartest.setVisibility(View.INVISIBLE);
    }

    public void startReanimation (View view){
        Intent reaIntent = new Intent(getApplicationContext(), ReanimationScreen.class);
        startActivity(reaIntent);
        finish();
    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0) {
        Log.d("onStopTrackingTouch", "onStopTrackingTouch");
        if (arg0.getProgress() < 80) {
            arg0.setProgress(0);
            sb.setBackgroundResource(R.drawable.slider_back);
            seekbartest.setVisibility(View.VISIBLE);
            seekbartest.setText(R.string.slidePatient);

        } else {
            arg0.setProgress(100);
            seekbartest.setVisibility(View.VISIBLE);
            seekbartest.setText(R.string.ankunft);
            sb.setVisibility(View.INVISIBLE);
            Confirm.setVisibility(View.VISIBLE);

        }
    }



    @Override
    public void onClick(View v) {

        sb.setVisibility(View.VISIBLE);
        sb.setProgress(0);
        Confirm.setVisibility(View.INVISIBLE);
        sb.setBackgroundResource(R.drawable.slider_back);
        seekbartest.setVisibility(View.VISIBLE);
        seekbartest.setText(R.string.slidePatient);
    }

}
