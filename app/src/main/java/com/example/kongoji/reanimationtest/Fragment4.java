package com.example.kongoji.reanimationtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Fragment4 extends Fragment implements AdapterView.OnItemSelectedListener {

    public String[] array_kA_ja_nein = {"k.A.", "ja", "nein"};
    public String[] array_kA_axil_rekt = {"k.A.", "axil.", "rekt.", "lyp.", "oral"};
    public String[] array_schmerzen = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_4, null);


        EditText textfieldUebergabeRR1 = (EditText) rootView.findViewById(R.id.textfield_uebergabe_rr1);

        EditText textfieldUebergabeRR2 = (EditText) rootView.findViewById(R.id.textfield_uebergabe_rr2);

        EditText textfieldUebergabePuls = (EditText) rootView.findViewById(R.id.textfield_uebergabe_puls);

        Spinner spinnerUebergabePulsReg = (Spinner) rootView.findViewById(R.id.spinner_uebergabe_puls_reg);
        ArrayAdapter<String> adapter44 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_ja_nein);
        adapter44.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUebergabePulsReg.setAdapter(adapter44);
        spinnerUebergabePulsReg.setOnItemSelectedListener(this);

        EditText textfieldUebergabeBZ = (EditText) rootView.findViewById(R.id.textfield_uebergabe_bz);

        EditText textfieldUebergabeTemperatur = (EditText) rootView.findViewById(R.id.textfield_uebergabe_temperatur);

        Spinner spinnerUebergabeTemperatur = (Spinner) rootView.findViewById(R.id.spinner_uebergabe_temperatur);
        ArrayAdapter<String> adapter45 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_axil_rekt);
        adapter45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUebergabeTemperatur.setAdapter(adapter45);
        spinnerUebergabeTemperatur.setOnItemSelectedListener(this);

        EditText textfieldUebergabeAF = (EditText) rootView.findViewById(R.id.textfield_uebergabe_af);

        EditText textfieldUebergabeSP02 = (EditText) rootView.findViewById(R.id.textfield_uebergabe_sp02);

        EditText textfieldUebergabeETCO2 = (EditText) rootView.findViewById(R.id.textfield_uebergabe_etco2);

        EditText textfieldUebergabeSonstigesEKG = (EditText) rootView.findViewById(R.id.textfield_uebergabe_sonstiges_ekg);

        Spinner spinnerUebergabeSchmerzen = (Spinner) rootView.findViewById(R.id.spinner_uebergabe_schmerzen);
        ArrayAdapter<String> adapter46 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_schmerzen);
        adapter46.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUebergabeSchmerzen.setAdapter(adapter46);
        spinnerUebergabeSchmerzen.setOnItemSelectedListener(this);

        EditText textfieldKHEntlassung = (EditText) rootView.findViewById(R.id.textfield_kh_entlassung);

        EditText textfieldTod = (EditText) rootView.findViewById(R.id.textfield_tod);

        EditText textfieldBemerkungen = (EditText) rootView.findViewById(R.id.textfield_bemerkungen);

        EditText textfieldUnterschrift1 = (EditText) rootView.findViewById(R.id.textfield_unterschrift1);

        EditText textfieldUnterschrift2 = (EditText) rootView.findViewById(R.id.textfield_unterschrift2);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
