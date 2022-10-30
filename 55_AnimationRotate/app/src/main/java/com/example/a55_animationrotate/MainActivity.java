package com.example.a55_animationrotate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        Animation animationRotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_rotate);
        imgViewRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationRotate);
            }
        });
    }

    public void Mapping() {
        imgViewRotate = (ImageView) findViewById(R.id.imgViewAnimationRotate);
    }
}