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
import android.widget.TextView;


public class Fragment1 extends Fragment implements AdapterView.OnItemSelectedListener {

    public String[] array_bewusstsein = {"k.A.", "wach", "Reaktion auf Anruf", "Reaktion auf Schmerz", "keine Reaktion", "Analogsediert"};
    public String[] array_kA_eng_mittel_weit = {"k.A.", "eng", "mittel", "weit", "entrundet", "nicht beurteilbar"};
    public String[] array_kA_links_rechts = {"k.A.", "links", "rechts"};
    public String[] array_ja_nein = {"ja", "nein"};
    public String[] array_normal_leichtVermindert_starkVermindert = {"normal", "leicht vermindert", "stark vermindert"};
    public String[] array_kA_ja_nein = {"k.A.", "ja", "nein"};
    public String[] array_kA_axil_rekt = {"k.A.","axil.","rekt.","lyp.","oral"};
    public String[] array_schmerzen = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public String[] array_kA_vorh_neu = {"k.A.", "vorh.","neu"};
    public String[] array_kA_schwierig_unmoeglich = {"k.A.", "schwierig","unmoeglich"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_1, null);


        TextView bewusst = (TextView) rootView.findViewById(R.id.startID);
        bewusst.requestFocus();


        Spinner spinnerBewusstsein = (Spinner) rootView.findViewById(R.id.spinner_bewusstsein);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_bewusstsein);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBewusstsein.setAdapter(adapter);
        spinnerBewusstsein.setOnItemSelectedListener(this);

        Spinner spinnerPupilleLinks = (Spinner) rootView.findViewById(R.id.spinner_pupille_links);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_eng_mittel_weit);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPupilleLinks.setAdapter(adapter2);
        spinnerPupilleLinks.setOnItemSelectedListener(this);

        Spinner spinnerPupilleRechts = (Spinner) rootView.findViewById(R.id.spinner_pupille_rechts);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_eng_mittel_weit);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPupilleRechts.setAdapter(adapter3);
        spinnerPupilleRechts.setOnItemSelectedListener(this);

        Spinner spinnerKeineLichtreaktion = (Spinner) rootView.findViewById(R.id.spinner_keine_lichtreaktion);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_links_rechts);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKeineLichtreaktion.setAdapter(adapter4);
        spinnerKeineLichtreaktion.setOnItemSelectedListener(this);

        Spinner spinnerCorneareflex = (Spinner) rootView.findViewById(R.id.spinner_corneareflex);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_links_rechts);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCorneareflex.setAdapter(adapter5);
        spinnerCorneareflex.setOnItemSelectedListener(this);

        Spinner spinnerMeningismus = (Spinner) rootView.findViewById(R.id.spinner_meningismus);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_ja_nein);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMeningismus.setAdapter(adapter6);
        spinnerCorneareflex.setOnItemSelectedListener(this);

        EditText textfieldGCS = (EditText) rootView.findViewById(R.id.textfield_gcs);


        EditText textfieldLaehmungen = (EditText) rootView.findViewById(R.id.textfield_laehmungen);

        Spinner spinnerArmLinks = (Spinner) rootView.findViewById(R.id.spinner_arm_links);
        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_normal_leichtVermindert_starkVermindert);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArmLinks.setAdapter(adapter7);
        spinnerArmLinks.setOnItemSelectedListener(this);

        Spinner spinnerArmRechts = (Spinner) rootView.findViewById(R.id.spinner_arm_rechts);
        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_normal_leichtVermindert_starkVermindert);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArmRechts.setAdapter(adapter8);
        spinnerArmRechts.setOnItemSelectedListener(this);

        Spinner spinnerBeinLinks = (Spinner) rootView.findViewById(R.id.spinner_bein_links);
        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,array_normal_leichtVermindert_starkVermindert);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBeinLinks.setAdapter(adapter9);
        spinnerBeinLinks.setOnItemSelectedListener(this);

        Spinner spinnerBeinRechts = (Spinner) rootView.findViewById(R.id.spinner_bein_rechts);
        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_normal_leichtVermindert_starkVermindert);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBeinRechts.setAdapter(adapter10);
        spinnerBeinRechts.setOnItemSelectedListener(this);

        EditText textfieldRR = (EditText) rootView.findViewById(R.id.textfield_rr1);

        EditText textfieldRR2 = (EditText) rootView.findViewById(R.id.textfield_rr2);

        EditText textfieldPuls = (EditText) rootView.findViewById(R.id.textfield_puls);

        Spinner spinnerPulsReg = (Spinner) rootView.findViewById(R.id.spinner_puls_reg);
        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_ja_nein);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPulsReg.setAdapter(adapter11);
        spinnerPulsReg.setOnItemSelectedListener(this);

        EditText textfieldBZ = (EditText) rootView.findViewById(R.id.textfield_bz);

        Spinner spinnerTemperatur = (Spinner) rootView.findViewById(R.id.spinner_temperatur);
        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_axil_rekt);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemperatur.setAdapter(adapter12);
        spinnerTemperatur.setOnItemSelectedListener(this);

        EditText textfieldAF = (EditText) rootView.findViewById(R.id.textfield_af);

        EditText textfieldSP02 = (EditText) rootView.findViewById(R.id.textfield_sp02);

        EditText textfieldETC02 = (EditText) rootView.findViewById(R.id.textfield_etc02);

        EditText textfieldSonstigesEKG = (EditText) rootView.findViewById(R.id.textfield_sonstiges_ekg);

        Spinner spinnerSchmerzen = (Spinner) rootView.findViewById(R.id.spinner_schmerzen);
        ArrayAdapter<String> adapter13 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_schmerzen);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSchmerzen.setAdapter(adapter13);
        spinnerSchmerzen.setOnItemSelectedListener(this);


        return rootView;


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}