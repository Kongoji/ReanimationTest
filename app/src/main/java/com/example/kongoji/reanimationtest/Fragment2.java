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

public class Fragment2 extends Fragment implements AdapterView.OnItemSelectedListener {

    public String[] array_kA_vorh_neu = {"k.A.", "vorh.", "neu"};
    public String[] array_kA_schwierig_unmoeglich = {"k.A.", "schwierig", "unmoeglich"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_2, null);


        EditText textfieldFeedbackSyst = (EditText) rootView.findViewById(R.id.textfield_feedback_syst);

        EditText textfieldLukas = (EditText) rootView.findViewById(R.id.textfield_lukas);

        EditText textfieldAktiveKuehlung = (EditText) rootView.findViewById(R.id.textfield_aktive_kuehlung);

        EditText textfieldEnergie = (EditText) rootView.findViewById(R.id.textfield_energie);

        EditText textfieldAnzahl = (EditText) rootView.findViewById(R.id.textfield_anzahl);

        EditText textfieldCodeHersteller = (EditText) rootView.findViewById(R.id.textfield_code_hersteller);

        EditText textfieldCodeDefi = (EditText) rootView.findViewById(R.id.textfield_code_defi);

        Spinner spinnerMonitoringEKG = (Spinner) rootView.findViewById(R.id.spinner_monitoring_ekg);
        ArrayAdapter<String> adapter14 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringEKG.setAdapter(adapter14);
        spinnerMonitoringEKG.setOnItemSelectedListener(this);

        Spinner spinnerMonitoring12KanalEKG = (Spinner) rootView.findViewById(R.id.spinner_monitoring_12_kanal_ekg);
        ArrayAdapter<String> adapter15 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoring12KanalEKG.setAdapter(adapter15);
        spinnerMonitoring12KanalEKG.setOnItemSelectedListener(this);

        Spinner spinnerMonitoringRRman = (Spinner) rootView.findViewById(R.id.spinner_monitoring_rr_man);
        ArrayAdapter<String> adapter16 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringRRman.setAdapter(adapter16);
        spinnerMonitoringRRman.setOnItemSelectedListener(this);

        Spinner spinnerMonitoringRRoszil = (Spinner) rootView.findViewById(R.id.spinner_monitoring_rr_oszil);
        ArrayAdapter<String> adapter17 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringRRoszil.setAdapter(adapter17);
        spinnerMonitoringRRoszil.setOnItemSelectedListener(this);

        Spinner spinnerMonitoringRRinvasiv = (Spinner) rootView.findViewById(R.id.spinner_monitoring_rr_invasiv);
        ArrayAdapter<String> adapter18 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringRRinvasiv.setAdapter(adapter18);
        spinnerMonitoringRRinvasiv.setOnItemSelectedListener(this);

        Spinner spinnerMonitoringPulsoximetrie = (Spinner) rootView.findViewById(R.id.spinner_monitoring_pulsoximetrie);
        ArrayAdapter<String> adapter19 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringPulsoximetrie.setAdapter(adapter19);
        spinnerMonitoringPulsoximetrie.setOnItemSelectedListener(this);

        Spinner spinnerMonitoringKapnometrie = (Spinner) rootView.findViewById(R.id.spinner_monitoring_kapnometrie);
        ArrayAdapter<String> adapter20 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringKapnometrie.setAdapter(adapter20);
        spinnerMonitoringKapnometrie.setOnItemSelectedListener(this);

        Spinner spinnerMonitoringTemperatur = (Spinner) rootView.findViewById(R.id.spinner_monitoring_temperatur);
        ArrayAdapter<String> adapter21 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringTemperatur.setAdapter(adapter21);
        spinnerMonitoringTemperatur.setOnItemSelectedListener(this);

        Spinner spinnerMonitoringICP = (Spinner) rootView.findViewById(R.id.spinner_monitoring_icp);
        ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringICP.setAdapter(adapter22);
        spinnerMonitoringICP.setOnItemSelectedListener(this);

        Spinner spinnerMonitoringZVD = (Spinner) rootView.findViewById(R.id.spinner_monitoring_zvd);
        ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringZVD.setAdapter(adapter23);
        spinnerMonitoringZVD.setOnItemSelectedListener(this);

        Spinner spinnerMonitoringPICCO = (Spinner) rootView.findViewById(R.id.spinner_monitoring_picco);
        ArrayAdapter<String> adapter24 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonitoringPICCO.setAdapter(adapter24);
        spinnerMonitoringPICCO.setOnItemSelectedListener(this);

        //Hier fehlt noch das "Zeit"-Feld

        EditText textfieldErgebnis = (EditText) rootView.findViewById(R.id.textfield_ergebnis);

        Spinner spinnerSonstigesMonitoring1 = (Spinner) rootView.findViewById(R.id.spinner_sonstiges_monitoring1);
        ArrayAdapter<String> adapter25 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSonstigesMonitoring1.setAdapter(adapter25);
        spinnerSonstigesMonitoring1.setOnItemSelectedListener(this);

        EditText textfieldSonstigesMonitoring1 = (EditText) rootView.findViewById(R.id.textfield_sonstiges_monitoring1);

        Spinner spinnerSonstigesMonitoring2 = (Spinner) rootView.findViewById(R.id.spinner_sonstiges_monitoring2);
        ArrayAdapter<String> adapter26 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSonstigesMonitoring2.setAdapter(adapter26);
        spinnerSonstigesMonitoring2.setOnItemSelectedListener(this);

        EditText textfieldSonstigesMonitoring2 = (EditText) rootView.findViewById(R.id.textfield_sonstiges_monitoring2);

        Spinner spinnerSchrittmacher = (Spinner) rootView.findViewById(R.id.spinner_schrittmacher);
        ArrayAdapter<String> adapter27 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSchrittmacher.setAdapter(adapter27);
        spinnerSchrittmacher.setOnItemSelectedListener(this);

        Spinner spinnerIvZugang = (Spinner) rootView.findViewById(R.id.spinner_iv_zugang);
        ArrayAdapter<String> adapter28 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIvZugang.setAdapter(adapter28);
        spinnerIvZugang.setOnItemSelectedListener(this);

        Spinner spinnerIoNadel = (Spinner) rootView.findViewById(R.id.spinner_io_nadel);
        ArrayAdapter<String> adapter29 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter29.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIoNadel.setAdapter(adapter29);
        spinnerIoNadel.setOnItemSelectedListener(this);

        Spinner spinnerAbMedikation = (Spinner) rootView.findViewById(R.id.spinner_ab_medikation);
        ArrayAdapter<String> adapter30 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAbMedikation.setAdapter(adapter30);
        spinnerAbMedikation.setOnItemSelectedListener(this);

        Spinner spinnerZVK = (Spinner) rootView.findViewById(R.id.spinner_zvk);
        ArrayAdapter<String> adapter31 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerZVK.setAdapter(adapter31);
        spinnerZVK.setOnItemSelectedListener(this);

        EditText textfieldLumen = (EditText) rootView.findViewById(R.id.textfield_lumen);

        Spinner spinner02Insuff = (Spinner) rootView.findViewById(R.id.spinner_o2_insuff);
        ArrayAdapter<String> adapter32 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter32.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner02Insuff.setAdapter(adapter32);
        spinner02Insuff.setOnItemSelectedListener(this);

        Spinner spinnerNIVCPAPMaske = (Spinner) rootView.findViewById(R.id.spinner_niv_cpap_maske);
        ArrayAdapter<String> adapter33 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNIVCPAPMaske.setAdapter(adapter33);
        spinnerNIVCPAPMaske.setOnItemSelectedListener(this);

        Spinner spinnerOraleIntubation = (Spinner) rootView.findViewById(R.id.spinner_orale_intubation);
        ArrayAdapter<String> adapter34 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter34.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOraleIntubation.setAdapter(adapter34);
        spinnerOraleIntubation.setOnItemSelectedListener(this);

        Spinner spinnerNasaleIntubation = (Spinner) rootView.findViewById(R.id.spinner_nasale_intubation);
        ArrayAdapter<String> adapter35 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter35.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNasaleIntubation.setAdapter(adapter35);
        spinnerNasaleIntubation.setOnItemSelectedListener(this);

        Spinner spinnerLarxnymaske = (Spinner) rootView.findViewById(R.id.spinner_larynxmaske);
        ArrayAdapter<String> adapter36 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter36.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLarxnymaske.setAdapter(adapter36);
        spinnerLarxnymaske.setOnItemSelectedListener(this);

        Spinner spinnerLarynxtubus = (Spinner) rootView.findViewById(R.id.spinner_larynxtubus);
        ArrayAdapter<String> adapter37 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter37.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLarynxtubus.setAdapter(adapter37);
        spinnerLarynxtubus.setOnItemSelectedListener(this);

        Spinner spinnerTracheotomie = (Spinner) rootView.findViewById(R.id.spinner_tracheotomie);
        ArrayAdapter<String> adapter38 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter38.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTracheotomie.setAdapter(adapter38);
        spinnerTracheotomie.setOnItemSelectedListener(this);

        EditText textfieldTracheotomie = (EditText) rootView.findViewById(R.id.textfield_tracheotomie);

        Spinner spinnerMagensonde = (Spinner) rootView.findViewById(R.id.spinner_magensonde);
        ArrayAdapter<String> adapter39 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter39.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMagensonde.setAdapter(adapter39);
        spinnerMagensonde.setOnItemSelectedListener(this);

        EditText textfieldMagensonde = (EditText) rootView.findViewById(R.id.textfield_magensonde);

        Spinner spinnerHarnableitung = (Spinner) rootView.findViewById(R.id.spinner_harnableitung);
        ArrayAdapter<String> adapter40 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter40.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHarnableitung.setAdapter(adapter40);
        spinnerHarnableitung.setOnItemSelectedListener(this);

        EditText textfieldHarnableitung = (EditText) rootView.findViewById(R.id.textfield_harnableitung);

        Spinner spinnerThoraxdrainage = (Spinner) rootView.findViewById(R.id.spinner_thoraxdrainage);
        ArrayAdapter<String> adapter41 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_vorh_neu);
        adapter41.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerThoraxdrainage.setAdapter(adapter41);
        spinnerThoraxdrainage.setOnItemSelectedListener(this);

        EditText textfieldThoraxdrainage = (EditText) rootView.findViewById(R.id.textfield_thoraxdrainage);

        Spinner spinnerKomplikationIntubation = (Spinner) rootView.findViewById(R.id.spinner_komplikation_intubation);
        ArrayAdapter<String> adapter42 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_schwierig_unmoeglich);
        adapter42.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKomplikationIntubation.setAdapter(adapter42);
        spinnerKomplikationIntubation.setOnItemSelectedListener(this);

        Spinner spinnerKomplikationIVZugang = (Spinner) rootView.findViewById(R.id.spinner_komplikation_ivzugang);
        ArrayAdapter<String> adapter43 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, array_kA_schwierig_unmoeglich);
        adapter43.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKomplikationIVZugang.setAdapter(adapter43);
        spinnerKomplikationIVZugang.setOnItemSelectedListener(this);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
