package com.example.simplegridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridViewAlpha;
    String[] arrayName = {"A", "B", "C", "D", "E", "F", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "S", "Z", "X", "V", "N", "M"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewAlpha = (GridView) findViewById(R.id.gridViewAlphabet);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayName);

        gridViewAlpha.setAdapter(arrayAdapter);

        gridViewAlpha.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayName[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}