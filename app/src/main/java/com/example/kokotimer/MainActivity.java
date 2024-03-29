package com.example.kokotimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView TimerTextView;
    SeekBar TimerSeekBar;
    Boolean counterIsActive = false;
    Button goButton, miekkieButton, twardeButton, srednieButton;
    CountDownTimer countDownTimer;
    TextView textViewB;



    public void resetTimer() {

        TimerTextView.setText("4:00");
        TimerSeekBar.setProgress(240);
        TimerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        goButton.setText("GOTUJ");
        counterIsActive = false;
        textViewB.setText("Jajko gotowe!");

    }

    public void buttonClicked(View view){

        if  (counterIsActive) {
            resetTimer();


        } else {
            counterIsActive = true;
            TimerSeekBar.setEnabled(false);
            textViewB.setText("Z okazji 27 urodzin!");
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
        miekkieButton = findViewById(R.id.Button2);
        srednieButton = findViewById(R.id.Button4);
        twardeButton = findViewById(R.id.Button3);
        textViewB = findViewById(R.id.textViewB);

        TimerSeekBar.setMax(600);
        TimerSeekBar.setProgress(240);

        miekkieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerSeekBar.setMax(600);
                TimerSeekBar.setProgress(240);
            }
        });
        twardeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerSeekBar.setMax(600);
                TimerSeekBar.setProgress(540);

            }
        });

        srednieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerSeekBar.setMax(600);
                TimerSeekBar.setProgress(330);
            }
        });

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
