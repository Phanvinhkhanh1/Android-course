package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgTime;
    RadioButton rbMorning, rbNoon, rbEvening;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMorning.isChecked()) {
                    Toast.makeText(MainActivity.this, rbMorning.getText(), Toast.LENGTH_SHORT).show();
                }
                if (rbNoon.isChecked()) {
                    Toast.makeText(MainActivity.this, rbNoon.getText(), Toast.LENGTH_SHORT).show();
                }
                if (rbEvening.isChecked()) {
                    Toast.makeText(MainActivity.this, rbEvening.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        rgTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonMorning:
                        Toast.makeText(MainActivity.this, "You choose Morning", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonNoon:
                        Toast.makeText(MainActivity.this, "You choose Noon", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonEvening:
                        Toast.makeText(MainActivity.this, "You choose Evening", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void Mapping() {
        rgTime = (RadioGroup) findViewById(R.id.radioGroupTime);
        rbMorning = (RadioButton) findViewById(R.id.radioButtonMorning);
        rbNoon = (RadioButton) findViewById(R.id.radioButtonNoon);
        rbEvening = (RadioButton) findViewById(R.id.radioButtonEvening);
        btnConfirm = (Button) findViewById(R.id.buttonConfirm);
    }
}