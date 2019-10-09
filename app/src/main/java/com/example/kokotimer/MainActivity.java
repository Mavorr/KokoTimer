package com.example.kokotimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void buttonClicked(View view){

        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

    public void updateTimer(int secondsLeft) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar TimerSeekBar = findViewById(R.id.TimerSeekBar);
        final TextView TimerTextView = findViewById(R.id.CountDownTextView);

        TimerSeekBar.setMax(600);
        TimerSeekBar.setProgress(30);

        TimerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes = progress / 60;
                int seconds = progress - (minutes * 60);

                String secondString = Integer.toString(seconds);

                if (secondString.equals("0")){
                    secondString = "00";
                }
                TimerTextView.setText(Integer.toString(minutes) + ":" + secondString);

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
