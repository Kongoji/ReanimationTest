package com.example.kongoji.reanimationtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.widget.RelativeLayout.*;

public class Fragment3 extends Fragment implements AdapterView.OnItemSelectedListener {

    private SharedPreferences sharedPreferences;
    private List<String> li;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_3, null);

        sharedPreferences = rootView.getContext().getSharedPreferences("Reanimationen", Context.MODE_PRIVATE);

        EditText textfieldVerlaufSonstige = (EditText) rootView.findViewById(R.id.textfield_verlauf_sonstige);


        final RelativeLayout rl=(RelativeLayout) rootView.findViewById(R.id.rl);
        final RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin=10;
        params.topMargin=150;

       // ListView list = new ListView(rootView.getContext());
        ExpandableHeightListView list = new ExpandableHeightListView(rootView.getContext());
        li = new ArrayList<String>();


        if (sharedPreferences.contains("reanimation")) {
            Log.e("Rea", sharedPreferences.getString("reanimation", ""));

            Collections.addAll(li, sharedPreferences.getString("reanimation", "").split(";"));

        }


        ArrayAdapter<String> adp=new ArrayAdapter<String> (rootView.getContext(),
                android.R.layout.simple_dropdown_item_1line,li);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        list.setAdapter(adp);
        list.setExpanded(true);

        list.setLayoutParams(params);

        rl.addView(list);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
