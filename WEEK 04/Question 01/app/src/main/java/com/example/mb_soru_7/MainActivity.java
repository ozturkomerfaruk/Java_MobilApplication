package com.example.mb_soru_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar tmpSeekBar;
    Handler handler = new Handler();
    Button tmpBaslat;
    Button tmpDuraklatDevam;
    ImageView tmpImageView;
    int progressValue = 1;
    boolean stop = false;
    int counter = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tmpBaslat = findViewById(R.id.buttonBaslat);
        tmpDuraklatDevam = findViewById(R.id.buttonDuraklatDevam);
        tmpSeekBar = findViewById(R.id.seekBar);
        tmpSeekBar.setProgress(progressValue);
        tmpImageView = findViewById(R.id.imageView);
        tmpBaslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMyCounter().start();
            }
        });
        tmpDuraklatDevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!stop){
                    stop = true;
                    tmpDuraklatDevam.setText("Devam et");
                } else {
                    stop = false;
                    tmpDuraklatDevam.setText("Duraklat");
                }
            }
        });
        tmpSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private Thread setMyCounter() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!stop) {
                        try {
                            Thread.sleep((progressValue * 1000));
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    } else {
                        continue;
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(counter == 0) {
                                tmpImageView.setImageResource(R.drawable.first);
                                counter += 1;
                            }
                            else if(counter == 1){
                                tmpImageView.setImageResource(R.drawable.second);
                                counter += 1;

                            }
                            else if(counter == 2){
                                tmpImageView.setImageResource(R.drawable.third);
                                counter += 1;

                            }
                            else if(counter == 3){
                                tmpImageView.setImageResource(R.drawable.fourth);
                                counter += 1;

                            } else {
                                counter = 0;
                                tmpImageView.setImageResource(R.drawable.fifth);
                            }
                        }
                    });
                }
            }
        });
    }
}