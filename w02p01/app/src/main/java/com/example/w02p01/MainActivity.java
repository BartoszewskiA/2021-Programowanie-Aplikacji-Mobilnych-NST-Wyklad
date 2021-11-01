package com.example.w02p01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void przelicz(View view) {
        EditText poleX, poleY, poleWynik;
        poleX = findViewById(R.id.editText_X);
        poleY = findViewById(R.id.editText_Y);
        poleWynik = findViewById(R.id.editText_Wynik);

        int x,y,wynik;

        String s = poleX.getText().toString();
        if (!s.equals(""))
            x = Integer.parseInt(s);
        else
        {
            x = 0;
            poleX.setText(String.valueOf(x));
        }
        s = poleY.getText().toString();
        if (!s.equals(""))
            y = Integer.parseInt(s);
        else
        {
            y=0;
            poleY.setText(String.valueOf(y));
        }

        wynik =  x + y;
        s = String.valueOf(wynik);
        poleWynik.setText(s);

        //poleWynik.setText(String.valueOf(wynik));

//        int c = getResources().getColor(R.color.tlo);
//        poleWynik.setBackgroundColor(c);
//        poleWynik.setText(String.valueOf(c));

    }
}