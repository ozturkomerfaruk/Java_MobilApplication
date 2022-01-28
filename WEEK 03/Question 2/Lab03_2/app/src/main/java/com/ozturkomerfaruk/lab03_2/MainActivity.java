package com.ozturkomerfaruk.lab03_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerYemek;
    TextView txtSecim;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerYemek = findViewById(R.id.spinnerYemek);
        txtSecim = findViewById(R.id.txtSecim);
        imageView = findViewById(R.id.imageView);

        String[] yemekArray = {"pilav", "nohut", "baklava", "kadayıf"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yemekArray);
        spinnerYemek.setAdapter(arrayAdapter);


        spinnerYemek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView result = findViewById(R.id.txtSecim);
                result.setText("Yemek seçimin: " + yemekArray[i]);

                switch (i) {
                    case 0: {
                        imageView.setImageResource(R.drawable.pilav);
                        break;
                    }
                    case 1: {
                        imageView.setImageResource(R.drawable.nohut);
                        break;
                    }
                    case 2: {
                        imageView.setImageResource(R.drawable.baklava);
                        break;
                    }
                    case 3: {
                        imageView.setImageResource(R.drawable.kadayif);
                        break;
                    }
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}