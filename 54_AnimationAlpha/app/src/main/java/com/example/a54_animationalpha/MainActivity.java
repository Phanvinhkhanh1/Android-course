package com.example.a54_animationalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        Animation animationAlpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_alpha);
        imgViewAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationAlpha);
            }
        });
    }

    public void Mapping() {
        imgViewAnimation = (ImageView) findViewById(R.id.imgViewAnimation);
    }
}