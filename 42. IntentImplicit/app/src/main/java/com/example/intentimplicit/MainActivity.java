package com.example.intentimplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgBrowser, imgMessenger, imgCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBrowser = (ImageView) findViewById(R.id.imageViewBrowser);
        imgMessenger = (ImageView) findViewById(R.id.imageViewMessenger);
        imgCall = (ImageView) findViewById(R.id.imageViewCall);

        imgBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://google.com"));
                startActivity(intent);
            }
        });

        imgMessenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("DataContent", "Hello ...");
                intent.setData(Uri.parse("sms:0388130526"));
                startActivity(intent);
            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0388130526"));
                startActivity(intent);
            }
        });
    }
}