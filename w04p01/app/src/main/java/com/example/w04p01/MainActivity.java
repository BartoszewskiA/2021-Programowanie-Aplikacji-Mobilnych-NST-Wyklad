package com.example.w04p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox01;
    TextView opis,opis2;
    RadioButton rb01,rb02,rb03;
    Spinner spiner01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox01 = findViewById(R.id.checkBox01);
        opis = findViewById(R.id.opis);
        opis2 = findViewById(R.id.opis02);
        rb01 = findViewById(R.id.rb01);
        rb02 = findViewById(R.id.rb02);
        rb03 = findViewById(R.id.rb03);
        spiner01 = findViewById(R.id.spiner01);
        if (checkBox01.isChecked())
            opis.setText("Wybrano");
        else
            opis.setText("nie wybrano");
        if (rb01.isChecked())
            opis2.setText("wybrano opcje 1");
        else if (rb02.isChecked())
            opis2.setText("wybrano opcje 2");
        else
            opis2.setText("wybrano opcje 3");
        dodajSluchaczaCheckbox();
        dodajSluchaczaRadioButtons();
        dodajSluchaczaSpinnera();


    }

    private void dodajSluchaczaSpinnera() {
        spiner01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    switch (i)
                    {
                        case 0: opis.setText("wybrano opcje 1"); break;
                        case 1: opis.setText("wybrano opcje 2"); break;
                        case 2: opis.setText("wybrano opcje 3"); break;
                        case 3: opis.setText("wybrano opcje 4"); break;
                        case 4: opis.setText("wybrano opcje 5"); break;
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void dodajSluchaczaRadioButtons() {
        CompoundButton.OnCheckedChangeListener sluchacz = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rb01.isChecked())
                    opis2.setText("wybrano opcje 1");
                else if (rb02.isChecked())
                    opis2.setText("wybrano opcje 2");
                else
                    opis2.setText("wybrano opcje 3");
            }
        };
        rb01.setOnCheckedChangeListener(sluchacz);
        rb02.setOnCheckedChangeListener(sluchacz);
        rb03.setOnCheckedChangeListener(sluchacz);
    }

    private void dodajSluchaczaCheckbox() {
        checkBox01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    opis.setText("Wybrano");
                else
                    opis.setText("nie wybrano");
            }
        });
    }


}