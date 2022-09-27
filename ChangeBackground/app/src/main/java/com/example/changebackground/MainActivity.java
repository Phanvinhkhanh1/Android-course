package com.example.changebackground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg_1);
        arrayList.add(R.drawable.bg_2);
        arrayList.add(R.drawable.bg_3);

        Random random = new Random();
        int position = random.nextInt(arrayList.size());
        linearLayout.setBackgroundResource(arrayList.get(position));
    }
}