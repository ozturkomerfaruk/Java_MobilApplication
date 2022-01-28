package com.ozturkomerfaruk.lab03_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int redValue;
    int greenValue;
    int blueValue;

    SeekBar seekBarRED;
    SeekBar seekBarGREEN;
    SeekBar seekBarBLUE;

    ConstraintLayout background;

    TextView txtRGBRED;
    TextView txtRGBGREEN;
    TextView txtRGBBLUE;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("settings", MODE_PRIVATE);

        seekBarRED = findViewById(R.id.seekBarRED);
        seekBarGREEN = findViewById(R.id.seekBarGREEN);
        seekBarBLUE = findViewById(R.id.seekBarBLUE);

        background = findViewById(R.id.background);

        txtRGBRED = findViewById(R.id.txtRGBRED);
        txtRGBGREEN = findViewById(R.id.txtRGBGREEN);
        txtRGBBLUE = findViewById(R.id.txtRGBBLUE);


        /*redValue = seekBarRED.getProgress();
        greenValue = seekBarGREEN.getProgress();
        blueValue = seekBarBLUE.getProgress();*/

        redValue = preferences.getInt("RGBRed", 0);
        greenValue = preferences.getInt("RGBGreen", 0);
        blueValue = preferences.getInt("RGBBlue", 0);

        txtRGBRED.setText(String.valueOf(redValue));
        txtRGBGREEN.setText(String.valueOf(greenValue));
        txtRGBBLUE.setText(String.valueOf(blueValue));

        seekBarRED.setProgress(redValue);
        seekBarGREEN.setProgress(greenValue);
        seekBarBLUE.setProgress(blueValue);

        background.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

        seekBarRED.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                redValue = i;
                background.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
                txtRGBRED.setText(String.valueOf(i));
                RGBColorSaved();
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
                txtRGBGREEN.setText(String.valueOf(i));
                RGBColorSaved();
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
                txtRGBBLUE.setText(String.valueOf(i));
                RGBColorSaved();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void RGBColorSaved() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("RGBRed", redValue);
        editor.putInt("RGBGreen", greenValue);
        editor.putInt("RGBBlue", blueValue);
        editor.apply();
    }
}