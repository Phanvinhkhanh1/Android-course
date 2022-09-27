package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtViewScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewScreen = (TextView) findViewById(R.id.textViewScreen);

        Calendar calendar = Calendar.getInstance();
        txtViewScreen.append(calendar.getTime() + "\n");
        txtViewScreen.append(calendar.get(Calendar.DATE) + "\n");
        txtViewScreen.append(calendar.get(Calendar.MONTH) + "\n");
        txtViewScreen.append(calendar.get(Calendar.YEAR) + "\n");
        txtViewScreen.append(calendar.get(Calendar.HOUR) + "\n");
        txtViewScreen.append(calendar.get(Calendar.HOUR_OF_DAY) + "\n");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        txtViewScreen.append(simpleDateFormat.format(calendar.getTime()) + "\n");
        SimpleDateFormat timePattern = new SimpleDateFormat("HH:mm:ss a");
        txtViewScreen.append(timePattern.format(calendar.getTime()) + "\n");
    }
}