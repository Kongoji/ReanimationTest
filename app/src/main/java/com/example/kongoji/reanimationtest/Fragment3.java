package com.example.kongoji.reanimationtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;

public class Fragment3 extends Fragment implements AdapterView.OnItemSelectedListener {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_3, null);


        EditText textfieldVerlaufSonstige = (EditText) rootView.findViewById(R.id.textfield_verlauf_sonstige);

        EditText textfieldVerlauf = (EditText) rootView.findViewById(R.id.textfield_verlauf);


        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
