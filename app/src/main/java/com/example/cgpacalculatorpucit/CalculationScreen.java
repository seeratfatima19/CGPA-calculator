package com.example.cgpacalculatorpucit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CalculationScreen extends AppCompatActivity {

    Spinner[] spinner;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_screen);
        getSupportActionBar().hide();


        //make a dropdown using Spinner


        spinner = new Spinner[8];

        spinner[0] = findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[0].setAdapter(adapter);


        spinner[1] = findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[1].setAdapter(adapter);

        spinner[2] = findViewById(R.id.spinner3);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[2].setAdapter(adapter);

        spinner[3] = findViewById(R.id.spinner4);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[3].setAdapter(adapter);

        spinner[4] = findViewById(R.id.spinner5);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[4].setAdapter(adapter);

        spinner[4] = findViewById(R.id.spinner5);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[4].setAdapter(adapter);

        spinner[5] = findViewById(R.id.spinner6);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[5].setAdapter(adapter);

        spinner[6] = findViewById(R.id.spinner7);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[6].setAdapter(adapter);

        spinner[7] = findViewById(R.id.spinner8);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[7].setAdapter(adapter);



    }
}