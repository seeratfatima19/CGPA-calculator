package com.example.cgpacalculatorpucit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Spinner semesters;
    ArrayAdapter<CharSequence> adapter;
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();
        //make a dropdown using Spinner
        semesters = findViewById(R.id.semesterSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        semesters.setAdapter(adapter);
        // getting the entered semester

        String sem = semesters.getSelectedItem().toString();
        int sem_num = Integer.parseInt(sem);

        View.OnClickListener onClickListener  = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(HomeActivity.this,CalculationScreen.class);
                startActivity(nextIntent);
            }
        };

        nextButton= (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(onClickListener);






    }
}