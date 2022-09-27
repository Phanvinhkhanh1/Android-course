package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = (Button) findViewById(R.id.buttonMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Log.d("Khanh", "onCreate Main");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Khanh", "onStart Main");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Khanh", "onRestart Main");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Khanh", "onResume Main");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Khanh", "onPause Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Khanh", "onStop Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Khanh", "onDestroy Main");
    }
}