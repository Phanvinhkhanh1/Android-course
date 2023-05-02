package com.example.intentexplicitwithbundle;

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
        Bundle bundle = intent.getBundleExtra("data");

        if (bundle != null) {
            String country = bundle.getString("string");
            int yearsOld = bundle.getInt("int");
            String[] arrays = bundle.getStringArray("stringArray");
            Student info = (Student) bundle.getSerializable("object");

            txtViewContent.setText(country + "\n" + yearsOld + "" + "\n" + arrays[0] + "\n" + info.getFullName() + " - " + info.getBirthYear());
        }

    }
}