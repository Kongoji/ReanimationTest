package com.example.kongoji.reanimationtest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ProtocolManagement extends FragmentActivity {

    private SharedPreferences sharedPreferences;
    private List<String> li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocol_management);


        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.management);
        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 10;
        params.topMargin = 150;


        ExpandableHeightListView list = new ExpandableHeightListView(getBaseContext());
        li = new ArrayList<String>();

        String path = "/data/data/" + getPackageName() + "/shared_prefs/";

        File folder = new File(path);

        File[] files = folder.listFiles();

        for (File temp : files) {
            li.add(temp.getName());
            Log.e("files", temp.getName());
        }

        ArrayAdapter<String> adp = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_dropdown_item_1line, li);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        list.setAdapter(adp);
        list.setExpanded(true);

        list.setLayoutParams(params);

        rl.addView(list);

    }


}
