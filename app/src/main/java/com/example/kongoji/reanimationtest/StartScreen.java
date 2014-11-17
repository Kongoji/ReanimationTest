package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class StartScreen extends FragmentActivity {

    protected DurationTimer chronoDuration;


    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL;
            StartScreen.this.receivedBroadcast(intent, isCharging);
        }
    };

    //start timer when not plugged in
    private void receivedBroadcast(Intent intent, boolean charged) {
        if (charged == false) {
            chronoDuration.startTimer();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        ReanimationStorageManager storeManager = ReanimationStorageManager.getInstance(this);
        storeManager.delete();

        setContentView(R.layout.activity_start_screen);

        Button reaButton = (Button) findViewById(R.id.startReaScreen);
        reaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reaIntent = new Intent(getApplicationContext(), ReanimationScreen.class);
                reaIntent.putExtra("Duration",chronoDuration.getElapsedTime());
                startActivity(reaIntent);
                finish();;
            }
        });

        Button docuButton = (Button) findViewById(R.id.startDocuScreen);
        docuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent docuIntent = new Intent(getApplicationContext(), ProtocolManagement.class);
                startActivity(docuIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reanimation_screen, menu);
        chronoDuration = new DurationTimer(this.getActionBar());

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        this.getApplicationContext().registerReceiver(mBroadcastReceiver, ifilter);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
    }

}
