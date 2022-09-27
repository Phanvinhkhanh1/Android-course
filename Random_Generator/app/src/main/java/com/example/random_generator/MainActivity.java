package com.example.random_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edtMinNumber;
    EditText edtMaxNumber;
    Button btnGenerate;
    TextView txtViewResultNumber;

    private void Mapping() {
        edtMinNumber = (EditText) findViewById(R.id.editTextTextMinNumber);
        edtMaxNumber = (EditText) findViewById(R.id.editTextTextMaxNumber);
        btnGenerate = (Button) findViewById(R.id.buttonGenerate);
        txtViewResultNumber = (TextView) findViewById(R.id.textViewResultNumber);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = edtMinNumber.getText().toString();
                String s2 = edtMaxNumber.getText().toString();
                if (s1.isEmpty() || s2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please, input all number", Toast.LENGTH_SHORT);
                } else {
                    int minNumber = Integer.parseInt(s1);
                    int maxNumber = Integer.parseInt(s2);
                    Random random = new Random();
                    int randomNumber = minNumber + random.nextInt(maxNumber - minNumber + 1);
                    txtViewResultNumber.setText(randomNumber + "");
                }
            }
        });
    }
}