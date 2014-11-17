package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class StartScreen extends Activity {

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
                startActivity(reaIntent);
            }
        });

        Button docuButton = (Button) findViewById(R.id.startDocuScreen);
        docuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent docuIntent = new Intent(getApplicationContext(), ProtocolManagement.class);
                startActivity(docuIntent);
            }
        });
    }
}
