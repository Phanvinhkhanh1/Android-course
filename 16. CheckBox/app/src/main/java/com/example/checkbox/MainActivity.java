package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbAndroid, cbIOS, cbFlutter;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Checked Android", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Unchecked Android", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Subjects = "Subjects that you are studying are : " + "\n";
                if (cbAndroid.isChecked()) {
                    Subjects += cbAndroid.getText() + "\n";
                }
                if (cbFlutter.isChecked()) {
                    Subjects += cbFlutter.getText() + "\n";
                }
                if (cbIOS.isChecked()) {
                    Subjects += cbIOS.getText() + "\n";
                }
                Toast.makeText(MainActivity.this, Subjects, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Mapping() {
        cbAndroid = (CheckBox) findViewById(R.id.checkBoxAndroid);
        cbFlutter = (CheckBox) findViewById(R.id.checkBoxFlutter);
        cbIOS = (CheckBox) findViewById(R.id.checkBoxIOS);
        btnConfirm = (Button) findViewById(R.id.buttonConfirm);
    }
}