package com.example.a56_animationscale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewAnimationScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        Animation animationScale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_scale);
        imgViewAnimationScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationScale);
            }
        });
    }

    public void Mapping() {
        imgViewAnimationScale = (ImageView) findViewById(R.id.imgViewAnimationScale);
    }
}