package com.example.intentexplicitwithbundle;

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

                Bundle bundle = new Bundle();
                bundle.putString("string", "China");
                bundle.putInt("int", 26);
                bundle.putStringArray("stringArray", new String[]{"Phuong", "Tung", "Khanh"});
                bundle.putSerializable("object", new Student("Phan Vinh Khanh", 26));

                intent.putExtra("data", bundle);

                startActivity(intent);
            }
        });
    }
}