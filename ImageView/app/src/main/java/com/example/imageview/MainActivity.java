package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
//    RelativeLayout relativeLayoutScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView) findViewById(R.id.imageViewAndroid);
//        relativeLayoutScreen = findViewById(R.id.screenBackGround);

        imgView.setImageResource(R.drawable.android_circle);
    }
}