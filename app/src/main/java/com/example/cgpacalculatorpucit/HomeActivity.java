package com.example.cgpacalculatorpucit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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
    AppCompatButton nextButton;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();
        //make a dropdown using Spinner
        semesters = (Spinner)findViewById(R.id.semesterSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        semesters.setAdapter(adapter);


        View.OnClickListener onClickListener  = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(HomeActivity.this,CalculationScreen.class);
                // getting the entered semester
                String sem = semesters.getSelectedItem().toString();
                int sem_num = Integer.parseInt(sem);
                nextIntent.putExtra("semester",sem_num);

                String getVal;

                editText= findViewById(R.id.editTextNumber1);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S1",Float.parseFloat(getVal));

                editText= findViewById(R.id.editTextNumber2);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S2",Float.parseFloat(getVal));

                editText= findViewById(R.id.editTextNumber3);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S3",Float.parseFloat(getVal));

                editText= findViewById(R.id.editTextNumber4);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S4",Float.parseFloat(getVal));

                editText= findViewById(R.id.editTextNumber4);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S5",Float.parseFloat(getVal));

                editText= findViewById(R.id.editTextNumber4);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S6",Float.parseFloat(getVal));

                editText= findViewById(R.id.editTextNumber5);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S5",Float.parseFloat(getVal));

                editText= findViewById(R.id.editTextNumber6);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S6",Float.parseFloat(getVal));

                editText= findViewById(R.id.editTextNumber7);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S7",Float.parseFloat(getVal));

                editText= findViewById(R.id.editTextNumber8);
                getVal= editText.getText().toString();
                nextIntent.putExtra("S8",Float.parseFloat(getVal));


                startActivity(nextIntent);
            }
        };

        nextButton= (AppCompatButton) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(onClickListener);






    }
}