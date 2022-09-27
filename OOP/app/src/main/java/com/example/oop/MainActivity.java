package com.example.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Student student = new Student("Phan Vinh Khanh","HCM City");

        Toast.makeText(MainActivity.this, student.getFullName() + " at " + student.getAddress(), Toast.LENGTH_SHORT).show();
    }
}