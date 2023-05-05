package com.example.angrybirdapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrayName;
    ImageView imgOrigin, imgChoose;
    TextView textViewTotal;
    String imageNameOrigin;
    int REQUEST_CODE = 123;
    int total = 100;
    SharedPreferences savedScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgOrigin = (ImageView) findViewById(R.id.imageViewOrigin);
        imgChoose = (ImageView) findViewById(R.id.imageViewChoose);
        textViewTotal = (TextView) findViewById(R.id.textViewTotal);

        savedScore = getSharedPreferences("savedTotal", MODE_PRIVATE);

        total = savedScore.getInt("totalScore", 100);
        textViewTotal.setText(total + "");

        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrayName = new ArrayList<>(Arrays.asList(mangTen));

        //shuffle arrayName
        Collections.shuffle(arrayName);

        imageNameOrigin = arrayName.get(0);

        int imageId = getResources().getIdentifier(arrayName.get(0), "drawable", getPackageName());
        imgOrigin.setImageResource(imageId);

        imgChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String imageNameReceived = data.getStringExtra("imageName");
            int imageReceivedId = getResources().getIdentifier(imageNameReceived, "drawable", getPackageName());
            imgChoose.setImageResource(imageReceivedId);

            if (imageNameReceived.equals(imageNameOrigin)) {
                Toast.makeText(MainActivity.this, "Correct!\n Your score will be added 10 points", Toast.LENGTH_SHORT).show();
                total += 10;

                new CountDownTimer(2000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        //shuffle arrayName
                        Collections.shuffle(arrayName);
                        imageNameOrigin = arrayName.get(0);
                        int imageId = getResources().getIdentifier(arrayName.get(0), "drawable", getPackageName());
                        imgOrigin.setImageResource(imageId);
                    }
                }.start();
            } else {
                Toast.makeText(MainActivity.this, "Wrong!\nYour score will be subtracted 5 points", Toast.LENGTH_SHORT).show();
                total -= 5;
            }
            textViewTotal.setText(total + "");

            saveScore();
        }

        if (requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED) {
            Toast.makeText(MainActivity.this, "You didn't choose image\nYour score will be subtracted 15 points", Toast.LENGTH_SHORT).show();
            total -= 15;
            textViewTotal.setText(total + "");

            saveScore();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.reloadMenu) {
            //shuffle arrayName
            Collections.shuffle(arrayName);
            imageNameOrigin = arrayName.get(0);
            int imageId = getResources().getIdentifier(arrayName.get(0), "drawable", getPackageName());
            imgOrigin.setImageResource(imageId);
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveScore() {
        SharedPreferences.Editor editor = savedScore.edit();
        editor.putInt("totalScore", total);
        editor.commit();
    }
}