package com.example.cgpacalculatorpucit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Spinner semesters;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //make a dropdown using Spinner
        semesters = findViewById(R.id.semesterSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        semesters.setAdapter(adapter);
        // getting the entered semester

        String sem = semesters.getSelectedItem().toString();
        int sem_num = Integer.parseInt(sem);






    }
}