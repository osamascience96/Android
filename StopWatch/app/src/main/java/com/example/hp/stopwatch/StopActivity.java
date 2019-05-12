package com.example.hp.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopActivity extends AppCompatActivity {

    private Button btnStart;
    private ImageView icanchorImgView;
    private Animation roundanimation;
    private Chronometer chronometerView;
    private boolean btnFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        btnStart = (Button)findViewById(R.id.btnstart);
        icanchorImgView = (ImageView) findViewById(R.id.icanchor);
        chronometerView = (Chronometer) findViewById(R.id.timeHere);
        btnFlag = true;

        LoadAnimation();
        SetEventListeners();
    }

    private void LoadAnimation(){
        roundanimation = AnimationUtils.loadAnimation(this, R.anim.rotation);
    }

    private void SetEventListeners(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnFlag){
                    // passing animation
                    icanchorImgView.startAnimation(roundanimation);
                    btnStart.setText(R.string.btnstop_string);
                    btnStart.setBackgroundResource(R.drawable.bg_splash_btn2);
                    // starting the chronometer
                    chronometerView.setBase(SystemClock.elapsedRealtime());
                    chronometerView.start();
                    btnFlag = false;
                }else{
                    btnFlag = true;
                    btnStart.setText(R.string.btnstart_string);
                    btnStart.setBackgroundResource(R.drawable.bg_splash_btn);
                    icanchorImgView.clearAnimation();
                    chronometerView.stop();
                }
            }
        });
    }
}
