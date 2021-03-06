package com.example.cdsm.tp09;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pays> paysEurope;
    //private ArrayList<String> continents;
    private ArrayList<Pays> paysAsie;
    private ArrayList<Pays> paysSelectedContinent;

    private HashMap<String, List<Pays>> dataMap;

    private Spinner spinnerContinents;
    private ListView listviewPays;

    private ArrayAdapter<Pays> adapterPays;
    private ArrayAdapter<String> adapterContinents;

    private int selectedContinent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bindings
        spinnerContinents = ((Spinner) findViewById(R.id.spinner));
        listviewPays = ((ListView) findViewById(R.id.myListview));

        paysSelectedContinent= new ArrayList<>();

        paysEurope = new ArrayList<>();
        paysEurope.add(new Pays("FRANCE", "PARIS", ""));
        paysEurope.add(new Pays("GRECE", "ATHENES", ""));

        paysAsie = new ArrayList<>();
        paysAsie.add(new Pays("CHINE", "PEKIN", ""));
        paysAsie.add(new Pays("THAÏLANDE", "BANCKOK",""));

        dataMap = new HashMap<>();
        dataMap.put("SELECTIONNEZ..", null);
        dataMap.put("EUROPE", paysEurope);
        dataMap.put("ASIE", paysAsie);


        adapterContinents = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<String>(dataMap.keySet()));
        spinnerContinents.setAdapter(adapterContinents);


        adapterPays = new ArrayAdapter<Pays>(this, android.R.layout.simple_list_item_1, paysSelectedContinent);
        listviewPays.setAdapter(adapterPays);



        spinnerContinents.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("---------------------- OnItemSelectedListener "+adapterView.getSelectedItem());

                if (dataMap.get(adapterView.getSelectedItem()) != null) {
                    System.out.println("-------------- list not null");
                    paysSelectedContinent.clear();
                    paysSelectedContinent.addAll(dataMap.get(adapterView.getSelectedItem()));
                    selectedContinent = i;
                    listviewPays.setAdapter(adapterPays);
                } else {
                    System.out.println("NULL");
                    listviewPays.setAdapter(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                listviewPays.setAdapter(null);
            }
        });

        listviewPays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(dataMap.get(selectedContinent).get(i).toString());
                /*
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("paysName", paysSelectedContinent.get(i).getNomPays());
                intent.putExtra("paysCapital", paysSelectedContinent.get(i).getCapitalPays());
                intent.putExtra("paysDrapeau", paysSelectedContinent.get(i).getDrapeauPays());
                */
            }
        });


    }
}
