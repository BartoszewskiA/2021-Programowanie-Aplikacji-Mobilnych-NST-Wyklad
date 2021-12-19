package com.example.w07p02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView01 = findViewById(R.id.webView01);
        webView01.getSettings().setJavaScriptEnabled(true);
        webView01.loadUrl("http://www.bartoszewski.uniwersytetradom.pl/");
    }
}