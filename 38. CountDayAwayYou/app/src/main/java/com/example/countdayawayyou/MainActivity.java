package com.example.countdayawayyou;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtText1, edtText2;
    TextView txtResult;
    Button btnCompute;
    Calendar calendarOne, calendarTwo;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        edtText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstDay();
            }
        });

        edtText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondDay();
            }
        });

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numOfDays = (int) ((calendarTwo.getTimeInMillis() - calendarOne.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                txtResult.setText(numOfDays + " days far away from you");
            }
        });
    }

    private void FirstDay() {
        calendarOne = Calendar.getInstance();
        int day = calendarOne.get(Calendar.DATE);
        int month = calendarOne.get(Calendar.MONTH);
        int year = calendarOne.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendarOne.set(i, i1, i2);
                edtText1.setText(simpleDateFormat.format(calendarOne.getTime()));
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void SecondDay() {
        calendarTwo = Calendar.getInstance();
        int day = calendarTwo.get(Calendar.DATE);
        int month = calendarTwo.get(Calendar.MONTH);
        int year = calendarTwo.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendarTwo.set(i, i1, i2);
                edtText2.setText(simpleDateFormat.format(calendarTwo.getTime()));
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void Mapping() {
        edtText1 = (EditText) findViewById(R.id.edtFirstDay);
        edtText2 = (EditText) findViewById(R.id.edtSecondDay);
        btnCompute = (Button) findViewById(R.id.btnCompute);
        txtResult = (TextView) findViewById(R.id.txtResult);
    }
}