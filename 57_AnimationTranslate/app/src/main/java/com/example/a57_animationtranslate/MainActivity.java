package com.example.a57_animationtranslate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewAnimationTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();
        Animation animationTranslate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_translate);
        imgViewAnimationTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationTranslate);
            }
        });
    }

    public void Mapping() {
        imgViewAnimationTranslate = (ImageView) findViewById(R.id.imgViewAnimationTranslate);
    }
}