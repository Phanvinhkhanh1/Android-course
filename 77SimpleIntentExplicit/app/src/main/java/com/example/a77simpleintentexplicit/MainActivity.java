package com.example.a77simpleintentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendData = (Button) findViewById(R.id.btnSendData);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

//              Send String data
//              intent.putExtra("data", "This content is sent by MainActivity");

//              Send integer data
//              intent.putExtra("data", 100.1);

//              Send array of String
//                String[] arrays = {"IOS", "Android", "Flutter", "React Native", "Spring boot"};
//                intent.putExtra("data", arrays);

//              Send Object
                Student student = new Student("Phan Vinh Khanh", 1997);
                intent.putExtra("data", student);

                startActivity(intent);
            }
        });

    }
}