package com.example.a8_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtContent;
    Button btnClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContent = (TextView) findViewById(R.id.textViewContent);
        btnClickMe = (Button) findViewById(R.id.buttonClickMe);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtContent.setText("Welcome you to Shanghai, China");
            }
        });
    }
}