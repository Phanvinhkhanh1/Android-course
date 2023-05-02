package com.example.a77simpleintentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {
    TextView txtViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtViewContent = (TextView) findViewById(R.id.txtViewContent);
        Intent intent = getIntent();

//        Get string data
//        String content = intent.getStringExtra("data");

//        Get integer data
//        String content = intent.getIntExtra("data", 500) + "";

//        String[] courses = intent.getStringArrayExtra("data");
//        Get Object data
        Student student = (Student) intent.getSerializableExtra("data");
        txtViewContent.setText(student.getFullName() + " - " + student.getBirthYear());

    }
}