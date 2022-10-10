package com.example.intentexplicitdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = (Button) findViewById(R.id.buttonMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String[] courses = {"Android", "Flutter", "BigData", "AI", "Chinese"};
                Student student = new Student("Phan Vinh Khanh", 25);

                Bundle bundle = new Bundle();

                bundle.putString("role", "Data Engineer");
                bundle.putInt("age", 25);
                bundle.putStringArray("course", courses);
                bundle.putSerializable("object", student);

                intent.putExtra("DataContent", bundle);
                startActivity(intent);
            }
        });
    }
}