package com.example.hp.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay, btnPause, btnStop;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnplay);
        btnPause = (Button) findViewById(R.id.btnpause);
        btnStop = (Button) findViewById(R.id.btnstop);
        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.punjabi_music);

        SetEventListener();
    }

    private void SetEventListener(){
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer.isPlaying()){
                    mMediaPlayer.pause();
                }else {
                    Toast.makeText(MainActivity.this, "Press the Play Button to Play", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.stop();
                try {
                    mMediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
