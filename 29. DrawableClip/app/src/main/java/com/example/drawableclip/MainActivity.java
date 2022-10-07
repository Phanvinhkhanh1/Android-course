package com.example.drawableclip;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewImg;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgViewImg = (ImageView) findViewById(R.id.imageViewImage);
        btnClick = (Button) findViewById(R.id.buttonClick);

        ClipDrawable clipDrawable = (ClipDrawable) imgViewImg.getDrawable();
        imgViewImg.setImageLevel(1000);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentLevel = clipDrawable.getLevel();
                if (currentLevel >= 10000) {
                    currentLevel = 0;
                }
                imgViewImg.setImageLevel(currentLevel + 1000);
                handler.postDelayed(this, 1000);
            }
        }, 2000);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentLevel = clipDrawable.getLevel();
                if (currentLevel >= 10000) {
                    currentLevel = 0;
                }
                imgViewImg.setImageLevel(currentLevel + 1000);
            }
        });
    }
}