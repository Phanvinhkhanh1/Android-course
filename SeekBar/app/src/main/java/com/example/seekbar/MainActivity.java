package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar sbSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbSound = (SeekBar) findViewById(R.id.seekBarSound);

        sbSound.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("Khanh", progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("Khanh", "start");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("Khanh", "Stop");
            }
        });
    }
}