package com.example.kongoji.reanimationtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fragment3 extends Fragment implements AdapterView.OnItemSelectedListener {

    private View rootView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.rootView = inflater.inflate(R.layout.fragment_3, null);
        new ListLoader().execute();

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private class ListLoader extends AsyncTask<Void,Void,ArrayAdapter<String>>{



        @Override
        protected ArrayAdapter<String> doInBackground(Void... voids) {


            SharedPreferences sharedPreferences = rootView.getContext().getSharedPreferences("Reanimationen", Context.MODE_PRIVATE);

            List<String> li = new ArrayList<String>();


            if (sharedPreferences.contains("reanimation")) {
                Log.e("Rea", sharedPreferences.getString("reanimation", ""));

                Collections.addAll(li, sharedPreferences.getString("reanimation", "").split(";"));

            }

            ArrayAdapter<String> adp = new ArrayAdapter<String>(rootView.getContext(),
                    android.R.layout.simple_dropdown_item_1line, li);
            adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
           return adp;
        }

        protected void onPostExecute(ArrayAdapter<String> value) {

            final RelativeLayout rl = (RelativeLayout) rootView.findViewById(R.id.rl);
            final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 10;
            params.topMargin = 150;

            ExpandableHeightListView list = new ExpandableHeightListView(rootView.getContext());

            list.setAdapter(value);
            list.setExpanded(true);

            list.setLayoutParams(params);

            rl.addView(list);

        }
    }



}
