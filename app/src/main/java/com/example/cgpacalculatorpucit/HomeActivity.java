package com.example.cgpacalculatorpucit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

        int[] ids= {R.id.editTextNumber1,R.id.editTextNumber2,R.id.editTextNumber3,R.id.editTextNumber4,R.id.editTextNumber5,R.id.editTextNumber6,R.id.editTextNumber7,R.id.editTextNumber8};
        String[] keys = {"S1","S2","S3","S4","S5","S6","S7","S8"};
        View.OnClickListener onClickListener  = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(HomeActivity.this,CalculationScreen.class);
                // getting the entered semester
                String sem = semesters.getSelectedItem().toString();
                int sem_num = Integer.parseInt(sem);
                nextIntent.putExtra("semester",sem_num);

                String getVal="";

                for(int i=0;i<ids.length;i++)
                {

                    editText= findViewById(ids[i]);
                    getVal= editText.getText().toString();
                    nextIntent.putExtra(keys[i],Float.parseFloat(getVal));

                }
                if(Float.parseFloat(getVal)>4) {
                    Toast.makeText(getApplicationContext(), "Invalid Inputs", Toast.LENGTH_SHORT).show();

                }
                else
                    startActivity(nextIntent);
            }
        };

        nextButton= (AppCompatButton) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(onClickListener);






    }
}