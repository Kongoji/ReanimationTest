package com.example.kongoji.reanimationtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class StartScreen extends BaseActivity {

    //start timer when not plugged in
    public void receivedBroadcast(Intent intent, boolean charged) {
        if (charged == false) {
            DurationTimer.getInstance().setDestination(this.getActionBar());

            if (!DurationTimer.getInstance().isRunning()) {
                DurationTimer.getInstance().startTimer();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //muss noch raus!
        //@TUDO
        ReanimationStorageManager storeManager = ReanimationStorageManager.getInstance(this);
        storeManager.delete();

        setContentView(R.layout.activity_start_screen);

        Button reaButton = (Button) findViewById(R.id.startReaScreen);
        reaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reaIntent = new Intent(getApplicationContext(), ReanimationScreen.class);
                startActivity(reaIntent);
                finish();
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
    public void onBackPressed() {
    }

}
