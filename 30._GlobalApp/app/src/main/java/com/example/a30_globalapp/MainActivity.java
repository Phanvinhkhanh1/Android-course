package com.example.a30_globalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewOutput;
    EditText editTextFullName, editTextPassword, editTextEmail;
    Button btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = editTextFullName.getText().toString();
                String passWord = editTextPassword.getText().toString();
                String email = editTextEmail.getText().toString();

                String textFullName = getResources().getString(R.string.text_fullName);
                String textPassword = getResources().getString(R.string.text_password);
                String textHello = getResources().getString(R.string.text_hello);

                textViewOutput.setText(textHello + " : " + fullName + "\n" + textPassword + " : " + passWord + "\n" + "Email : " + email);
            }
        });
    }

    public void Mapping() {
        editTextFullName = (EditText) findViewById(R.id.edtTextFullname);
        editTextPassword = (EditText) findViewById(R.id.edtTextPassword);
        editTextEmail = (EditText) findViewById(R.id.edtTextEmail);
        textViewOutput = (TextView) findViewById(R.id.textViewOutput);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
    }
}