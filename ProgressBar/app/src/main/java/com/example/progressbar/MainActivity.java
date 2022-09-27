package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar prbProcess;
    Button btnDownload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(5000, 500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = prbProcess.getProgress();
                        if (current >= prbProcess.getMax()) {
                            current = 0;
                        }
                        prbProcess.setProgress(current + 10);
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                        Toast.makeText(MainActivity.this, "Time over", Toast.LENGTH_SHORT).show();
                    }
                };

                countDownTimer.start();
            }
        });
    }

    private void Mapping() {
        prbProcess = (ProgressBar) findViewById(R.id.progressBarProcess);
        btnDownload = (Button) findViewById(R.id.buttonDownload);
    }
}