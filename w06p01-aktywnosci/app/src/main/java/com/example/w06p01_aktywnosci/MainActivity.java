package com.example.w06p01_aktywnosci;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button01, button02, button03, button04 ,button05;
    EditText editText01, editText02;
    static int KOD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button03 = findViewById(R.id.button03);
        button04 = findViewById(R.id.button04);
        button05 = findViewById(R.id.button05);
        editText01 = findViewById(R.id.editText01);
        editText02 = findViewById(R.id.editText02);
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Id = view.getId();
                switch (Id)
                {
                    case R.id.button01: otworzAktywnosc(); break;
                    case R.id.button02: otworziPrzeslijDane(); break;
                    case R.id.button03: otworziOdbierzDane(); break;
                    case R.id.button04: otworzGoogle(); break;
                    case R.id.button05: otworzGoogleMaps(); break;
                }
            }
        };
        button01.setOnClickListener(sluchacz);
        button02.setOnClickListener(sluchacz);
        button03.setOnClickListener(sluchacz);
        button04.setOnClickListener(sluchacz);
        button05.setOnClickListener(sluchacz);
    }

    private void otworzGoogleMaps() {
        Uri adresGoogla = Uri.parse("geo:51.405,21.17");
        Intent intencja = new Intent(Intent.ACTION_VIEW, adresGoogla);
        startActivity(intencja);
    }

    private void otworzGoogle() {
        Uri adresGoogla = Uri.parse("https://www.google.pl/");
        Intent intencja = new Intent(Intent.ACTION_VIEW, adresGoogla);
        startActivity(intencja);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==KOD && resultCode==RESULT_OK)
        {
            String s = data.getStringExtra("odp");
            editText02.setText(s);
        }

    }

    private void otworziOdbierzDane() {
        Intent intencja = new Intent(getApplicationContext(),MainActivity4.class);
        intencja.putExtra("pytanie","Jak się masz?");
        startActivityForResult(intencja, KOD );

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