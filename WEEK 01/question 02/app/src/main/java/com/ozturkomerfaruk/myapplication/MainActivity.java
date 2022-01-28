package com.ozturkomerfaruk.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    TextView txtScore;

    Random generate = new Random();
    int greaterOne, score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        txtScore = findViewById(R.id.txtScore);

        GenerateRandom();
    }

    public void GenerateRandom() {

        int rand1 = generate.nextInt(10);
        int rand2 = generate.nextInt(10);
        if (rand1 == rand2) {
            rand1 = generate.nextInt(10);
            rand2 = generate.nextInt(10);
        }
        btn1.setText(String.valueOf(rand1));
        btn2.setText(String.valueOf(rand2));
        greaterOne = (rand1 > rand2) ? rand1 : rand2;
    }

    public void BiggerOrLower(View view) {
        Button btn = (Button) view;
        if (btn.getText().toString() == String.valueOf(greaterOne)) {
            score += 10;
            txtScore.setText(String.valueOf(score));
            Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            score -= 10;
            txtScore.setText(String.valueOf(score));
        }
        GenerateRandom();
    }
}