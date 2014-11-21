package com.example.kongoji.reanimationtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Kongoji on 18.11.14.
 */
public abstract class BaseActivity extends FragmentActivity {


    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING;
            //||status == BatteryManager.BATTERY_STATUS_FULL
            receivedBroadcast(intent, isCharging);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        this.getApplicationContext().registerReceiver(mBroadcastReceiver, ifilter);
    }

    public abstract void receivedBroadcast(Intent intent, boolean charged);


}
