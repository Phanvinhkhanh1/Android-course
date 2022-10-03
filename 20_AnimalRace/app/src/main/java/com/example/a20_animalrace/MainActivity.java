package com.example.a20_animalrace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox cbOne, cbTwo, cbThree;
    SeekBar sbOne, sbTwo, sbThree;
    ImageButton btnPlay;
    TextView txtScore;
    int score = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Mapping();

        sbOne.setEnabled(false);
        sbTwo.setEnabled(false);
        sbThree.setEnabled(false);

        CountDownTimer countDownTimer = new CountDownTimer(60000, 200) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int numberOne = random.nextInt(number);
                int numberTwo = random.nextInt(number);
                int numberThree = random.nextInt(number);
                if (sbOne.getProgress() >= sbOne.getMax()) {
                    this.cancel();
                    EnableCheckbox();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Animal 1 won!", Toast.LENGTH_SHORT).show();

                    if (cbOne.isChecked()) {
                        Toast.makeText(MainActivity.this, "You bet correctly", Toast.LENGTH_SHORT).show();
                        score += 10;
                    } else {
                        Toast.makeText(MainActivity.this, "You bet wrong", Toast.LENGTH_SHORT).show();
                        score -= 10;
                    }
                    txtScore.setText(score + "");
                }
                if (sbTwo.getProgress() >= sbTwo.getMax()) {
                    this.cancel();
                    EnableCheckbox();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Animal 2 won!", Toast.LENGTH_SHORT).show();

                    if (cbTwo.isChecked()) {
                        Toast.makeText(MainActivity.this, "You bet correctly", Toast.LENGTH_SHORT).show();
                        score += 10;
                    } else {
                        Toast.makeText(MainActivity.this, "You bet wrong", Toast.LENGTH_SHORT).show();
                        score -= 10;
                    }
                    txtScore.setText(score + "");
                }
                if (sbThree.getProgress() >= sbThree.getMax()) {
                    this.cancel();
                    EnableCheckbox();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Animal 3 won!", Toast.LENGTH_SHORT).show();

                    if (cbThree.isChecked()) {
                        Toast.makeText(MainActivity.this, "You bet correctly", Toast.LENGTH_SHORT).show();
                        score += 10;
                    } else {
                        Toast.makeText(MainActivity.this, "You bet wrong", Toast.LENGTH_SHORT).show();
                        score -= 10;
                    }
                    txtScore.setText(score + "");
                }
                sbOne.setProgress(sbOne.getProgress() + numberOne);
                sbTwo.setProgress(sbTwo.getProgress() + numberTwo);
                sbThree.setProgress(sbThree.getProgress() + numberThree);
            }

            @Override
            public void onFinish() {

            }
        };

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbOne.setChecked(false);
                cbThree.setChecked(false);
            }
        });

        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbOne.setChecked(false);
                cbTwo.setChecked(false);
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {
                    sbOne.setProgress(0);
                    sbTwo.setProgress(0);
                    sbThree.setProgress(0);
                    btnPlay.setVisibility(View.INVISIBLE);
                    DisableCheckbox();
                    countDownTimer.start();
                } else {
                    Toast.makeText(MainActivity.this, "Please bet into any animal!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Mapping() {
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);
        sbOne = (SeekBar) findViewById(R.id.seekbarOne);
        sbTwo = (SeekBar) findViewById(R.id.seekBarTwo);
        sbThree = (SeekBar) findViewById(R.id.seekbarThree);
        btnPlay = (ImageButton) findViewById(R.id.buttonPlay);
        txtScore = (TextView) findViewById(R.id.txtScore);
    }

    public void EnableCheckbox() {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }

    public void DisableCheckbox() {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }
}