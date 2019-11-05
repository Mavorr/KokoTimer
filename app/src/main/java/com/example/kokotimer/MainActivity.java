package com.example.kokotimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView TimerTextView;
    SeekBar TimerSeekBar;
    Boolean counterIsActive = false;
    Button goButton;
    CountDownTimer countDownTimer;

    public void resetTimer() {

        TimerTextView.setText("0:30");
        TimerSeekBar.setProgress(30);
        TimerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        goButton.setText("KNEFEL");
        counterIsActive = false;
    }

    public void buttonClicked(View view){

        if  (counterIsActive) {
            resetTimer();


        } else {
            counterIsActive = true;
            TimerSeekBar.setEnabled(false);
            goButton.setText("STOP");

            countDownTimer = new CountDownTimer(TimerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);

                }

                @Override
                public void onFinish() {
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.note1_c);
                    mplayer.start();
                    resetTimer();
                }
            }.start();
        }

    }

    public void updateTimer(int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - (minutes * 60);

        String secondString = Integer.toString(seconds);

        if (seconds <= 9) {
            secondString = "0" + secondString;
        }
        TimerTextView.setText(Integer.toString(minutes) + ":" + secondString);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TimerSeekBar = findViewById(R.id.TimerSeekBar);
        TimerTextView = findViewById(R.id.CountDownTextView);
        goButton = findViewById(R.id.Button);

        TimerSeekBar.setMax(600);
        TimerSeekBar.setProgress(30);

        TimerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);


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
