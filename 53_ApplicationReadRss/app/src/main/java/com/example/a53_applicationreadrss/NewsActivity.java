package com.example.a53_applicationreadrss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {

    WebView webViewIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Mapping();

        Intent intent = getIntent();
        String link = intent.getStringExtra("linkNews");

        webViewIntent.loadUrl(link);

        webViewIntent.setWebViewClient(new WebViewClient());
    }

    public void Mapping() {
        webViewIntent = (WebView) findViewById(R.id.webViewActivity);
    }
}