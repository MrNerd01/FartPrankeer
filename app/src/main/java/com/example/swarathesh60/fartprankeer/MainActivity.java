package com.example.swarathesh60.fartprankeer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timeremaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        timeremaining = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new CountDownTimer(10000+100, 1000) {
                    @Override
                    public void onTick(long l) {
                        UpdateTime(l);
                    }

                    @Override
                    public void onFinish() {
                        timeremaining.setText("0");
                        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.fart);
                        mediaPlayer.start();
                    }
                }.start();
            }
        });
    }

    private void UpdateTime(long l) {
        int seconds = (int) l/1000;
        timeremaining.setText(String.valueOf(seconds));

    }
}
