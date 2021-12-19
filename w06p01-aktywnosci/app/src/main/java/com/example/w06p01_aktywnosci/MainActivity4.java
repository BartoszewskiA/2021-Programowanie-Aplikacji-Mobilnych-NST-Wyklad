package com.example.w06p01_aktywnosci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    Button odpowiedz;
    EditText dana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        odpowiedz = findViewById(R.id.button02_a4);
        dana = findViewById(R.id.editText01_a4);
        Bundle paczka = getIntent().getExtras();
        String s = paczka.getString("pytanie");
        //dana.setText(s);
        dana.setHint(s);


        odpowiedz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent odp = new Intent();
                odp.putExtra("odp",dana.getText().toString());
                setResult(RESULT_OK, odp);
                finish();
            }
        });
    }
}