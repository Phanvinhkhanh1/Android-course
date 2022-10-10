package com.example.intentexplicitdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtSecond = (TextView) findViewById(R.id.textViewSecond);
        Intent intent = getIntent();

        Bundle dataContent = intent.getBundleExtra("DataContent");
        if (dataContent != null) {
            String role = dataContent.getString("role");
            int age = dataContent.getInt("age", 100);
            String[] courses = dataContent.getStringArray("course");
            Student student = (Student) dataContent.getSerializable("object");

            txtSecond.setText(role + "\n" + age + "\n" + courses[0] + "\n" + student.getFullName() + " - " + student.getAge() + "");
        }

    }
}