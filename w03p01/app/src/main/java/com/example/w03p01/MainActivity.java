package com.example.w03p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button01, button02, button03;
    TextView opis;
    SeekBar suwak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01= findViewById(R.id.button01);
        button02= findViewById(R.id.button02);
        button03= findViewById(R.id.button03);
        opis = findViewById(R.id.opis);
        suwak = findViewById(R.id.suwak);


        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch(id)
                {
                    case R.id.button01:  opis.setText("Kliknieto przycisk 01"); break;
                    case R.id.button02:  opis.setText("Kliknieto przycisk 02"); break;
                }
            }
        };

        button01.setOnClickListener(sluchacz);
        button02.setOnClickListener(sluchacz);

//        button03.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                opis.setText("Kliknieto przycisk 03");
//            }
//        });

        button03.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                opis.setText("Przytrzymano przycisk");
                return false;
            }
        });

        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                opis.setText(String.valueOf(progress));
                //Toast.makeText(MainActivity.this, String.valueOf(progress), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Rozpoczęto suwanie", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Zakończono suwanie na "+String.valueOf(suwak.getProgress()), Toast.LENGTH_LONG).show();
            }
        });

    }
}