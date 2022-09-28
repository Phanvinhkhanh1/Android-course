package com.example.a7processdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContent = (TextView) findViewById(R.id.textViewContent);
        txtContent.setText("Welcome Phan Vinh Khanh to Android Development");
    }
}