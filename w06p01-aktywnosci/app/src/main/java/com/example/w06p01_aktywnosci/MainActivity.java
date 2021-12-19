package com.example.w06p01_aktywnosci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button01, button02;
    EditText editText01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        editText01 = findViewById(R.id.editText01);
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Id = view.getId();
                switch (Id)
                {
                    case R.id.button01: otworzAktywnosc(); break;
                    case R.id.button02: otworziPrzeslijDane(); break;
                }
            }
        };
        button01.setOnClickListener(sluchacz);
        button02.setOnClickListener(sluchacz);
    }

    private void otworziPrzeslijDane() {
        Intent intencja = new Intent(getApplicationContext(), MainActivity3.class);
        String s = editText01.getText().toString();
        intencja.putExtra("dana2", s);
        intencja.putExtra("dana", 123);
        intencja.putExtra("opis", "Przesłane z aktywności głównej");
        startActivity(intencja);
    }

    private void otworzAktywnosc() {
        Intent intencja = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intencja);
    }
}