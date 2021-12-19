package com.example.w06p01_aktywnosci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView a3_textView01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        a3_textView01 = findViewById(R.id.a3_textView01);

        Bundle paczka = getIntent().getExtras();

       String s = paczka.getString("opis");
       String s2 = paczka.getString("dana2");
       int l = paczka.getInt("dana");
        a3_textView01.setText(s + "\n" + l+ "\n"+s2);
    }
}