package com.ozturkomerfaruk.lab03_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    int redValue;
    int greenValue;
    int blueValue;

    SeekBar seekBarRED;
    SeekBar seekBarGREEN;
    SeekBar seekBarBLUE;

    ConstraintLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarRED = findViewById(R.id.seekBarRED);
        seekBarGREEN = findViewById(R.id.seekBarGREEN);
        seekBarBLUE = findViewById(R.id.seekBarBLUE);

        background = findViewById(R.id.background);


        redValue = seekBarRED.getProgress();
        greenValue = seekBarGREEN.getProgress();
        blueValue = seekBarBLUE.getProgress();


        background.setBackgroundColor(Color.rgb(220, 220, 220));

        seekBarRED.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                redValue = i;
                background.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarGREEN.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                greenValue = i;
                background.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarBLUE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blueValue = i;
                background.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}