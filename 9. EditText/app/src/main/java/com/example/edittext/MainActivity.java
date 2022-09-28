package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edtContent = (EditText) findViewById(R.id.editTextPersonalName);
        Button btnClick = (Button) findViewById(R.id.buttonClick);

        edtContent.setText("Phan Vinh Khanh");

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = edtContent.getText().toString();
                Toast.makeText(MainActivity.this,content,Toast.LENGTH_LONG).show();
            }
        });
    }
}