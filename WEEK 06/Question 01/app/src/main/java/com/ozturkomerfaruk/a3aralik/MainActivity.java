package com.ozturkomerfaruk.a3aralik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewGorsel;
    ListView listViewGorsel;

    String[] androidGorsel = {"Görsel 1", "Görsel 2", "Görsel 3", "G örsel 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgViewGorsel = findViewById(R.id.imgViewGorsel);
        listViewGorsel = findViewById(R.id.listViewGorsel);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, androidGorsel);
        listViewGorsel.setAdapter(adapter);

        listViewGorsel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0: {
                        imgViewGorsel.setImageResource(R.drawable.gorsel1);
                        Toast.makeText(MainActivity.this, androidGorsel[0].toString(), Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 1: {
                        imgViewGorsel.setImageResource(R.drawable.gorsel2);
                        Toast.makeText(MainActivity.this, androidGorsel[1].toString(), Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 2: {
                        imgViewGorsel.setImageResource(R.drawable.gorsel3);
                        Toast.makeText(MainActivity.this, androidGorsel[2].toString(), Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 3: {
                        imgViewGorsel.setImageResource(R.drawable.gorsel4);
                        Toast.makeText(MainActivity.this, androidGorsel[3].toString(), Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default:
                        break;
                }
            }
        });

    }
}
