package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class StandByScreen extends BaseActivity {

    //static final int ARRIVAL_AT_PATIENT = 1;


    //start timer when not plugged in
    public void receivedBroadcast(Intent intent, boolean charged) {



        if (charged == false) {
           startReanimation();
        }

        //else
    }

    private void startReanimation(){

            Intent reaIntent = new Intent(getApplicationContext(), StartScreen.class);
            startActivity(reaIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand_by_screen);

        //muss noch raus! NUr zum Testen..is böse
        //@TUDO
        ReanimationStorageManager storeManager = ReanimationStorageManager.getInstance(this);
        storeManager.delete();


         Button reaButton = (Button) findViewById(R.id.startReaScreen);
        reaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startReanimation();
                //finish();
            }
        });

        Button docuButton = (Button) findViewById(R.id.startDocuScreen);
        docuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Protkollmanagement noch nicht vollständig implementiert
               // Intent docuIntent = new Intent(getApplicationContext(), ProtocolManagement.class);
               // startActivity(docuIntent);
               // finish();
            }
        });
    }
}
