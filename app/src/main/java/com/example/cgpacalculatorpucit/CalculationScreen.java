package com.example.cgpacalculatorpucit;

import static java.lang.Math.round;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculationScreen extends AppCompatActivity {

    AppCompatButton calculate;
    Spinner[] spinner;
    EditText crHrView;
    ArrayAdapter<CharSequence> adapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_screen);
        getSupportActionBar().hide();


        // get the intent objects to get data from other file.

        String[] key = {"S1","S2","S3","S4","S5","S6","S7","S8"};
        float[] sem_gpas = new float[8];
        Intent intent = getIntent();
        //get curent semester
        int currentSemester = intent.getIntExtra("semester",0);

        double prevGpaSum=0;
        // get gpas to previous semesters
        for(int i=0;i<key.length;i++)
        {
            sem_gpas[i] = intent.getFloatExtra(key[i],0.0f);
            prevGpaSum=prevGpaSum+sem_gpas[i];
        }
        //make a dropdown using Spinner
        spinner = new Spinner[8];
    int[] arr ={R.id.spinner1,R.id.spinner2,R.id.spinner3,R.id.spinner4,R.id.spinner5,R.id.spinner6,R.id.spinner7,R.id.spinner8};

    for(int i=0;i<arr.length;i++)
    {
        spinner[i] = findViewById(arr[i]);
        adapter = ArrayAdapter.createFromResource(this, R.array.Marks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner[i].setAdapter(adapter);
    }




        // making click event

        double finalPrevGpaSum = prevGpaSum;
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get current semester courses and their cr. hrs.

                int[] crHrId={R.id.editTextNumberDecimal,R.id.editTextNumberDecimal2,R.id.editTextNumberDecimal3,R.id.editTextNumberDecimal4,R.id.editTextNumberDecimal5,R.id.editTextNumberDecimal6,R.id.editTextNumberDecimal7};
                float[] crHr = new float[8];

                for(int i=0;i<crHrId.length;i++)
                {
                    crHrView = (EditText)findViewById(crHrId[i]);
                    String val = crHrView.getText().toString();

                    if(val.equals("")){continue;}
                    else {
                        crHr[i] = Float.parseFloat(val);
                    }

                }


                // get selected values in spinner

                float crHrSum=0;
                float crHrGpSum=0;
                double semGpa =0.0;
                double cgpa=0.0;

                float[] crHrGp = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};

                for(int i=0;i<spinner.length;i++) {
                    String grade  =spinner[i].getSelectedItem().toString();

                    if(grade.equals(""))
                    {
                        continue;
                    }

                    if (grade.equals("50-54")) {
                        crHrGp[i] = crHr[i] * 1;
                        crHrSum = crHrSum + crHr[i];
                        crHrGpSum = crHrGpSum + crHrGp[i];
                    } else if (grade.equals("55-57")) {
                        crHrGp[i] = crHr[i] * 1.7f;
                        crHrSum = crHrSum + crHr[i];
                        crHrGpSum = crHrGpSum + crHrGp[i];
                    } else if (grade.equals("58-60")) {
                        crHrGp[i] = crHr[i] * 2.0f;
                        crHrSum = crHrSum + crHr[i];
                        crHrGpSum = crHrGpSum + crHrGp[i];
                    } else if (grade.equals("61-64")) {
                        crHrGp[i] = crHr[i] * 2.3f;
                        crHrSum = crHrSum + crHr[i];
                        crHrGpSum = crHrGpSum + crHrGp[i];
                    } else if (grade.equals("65-69")) {
                        crHrGp[i] = crHr[i] * 2.7f;
                        crHrSum = crHrSum + crHr[i];
                        crHrGpSum = crHrGpSum + crHrGp[i];
                    } else if (grade.equals("70-74")) {
                        crHrGp[i] = crHr[i] * 3.0f;
                        crHrSum = crHrSum + crHr[i];
                        crHrGpSum = crHrGpSum + crHrGp[i];
                    } else if (grade.equals("75-79")) {
                        crHrGp[i] = crHr[i] * 3.3f;
                        crHrSum = crHrSum + crHr[i];
                        crHrGpSum = crHrGpSum + crHrGp[i];
                    } else if (grade.equals("80-84")) {
                        crHrGp[i] = crHr[i] * 3.7f;
                        crHrSum = crHrSum + crHr[i];
                        crHrGpSum = crHrGpSum + crHrGp[i];
                    } else if (grade.equals("85-100")) {
                        crHrGp[i] = crHr[i] * 4.0f;
                        crHrSum = crHrSum + crHr[i];
                        crHrGpSum = crHrGpSum + crHrGp[i];
                    }
                }

                semGpa = crHrGpSum/crHrSum;
                System.out.println("Sem gpa: "+semGpa);
                cgpa = (finalPrevGpaSum +semGpa) /currentSemester;
                System.out.println("currentSemster: "+currentSemester);
                System.out.println("previous gpa sum : "+finalPrevGpaSum);
                System.out.println("semester gpa: "+semGpa);

                textView = (TextView)findViewById(R.id.cgpaView);
                textView.setText("CGPA:"+ String.format("%.2f",cgpa));
            }
        };

        calculate = (AppCompatButton) findViewById(R.id.calculate);
        calculate.setOnClickListener(onClickListener);


        /////

    }
}