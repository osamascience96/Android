package com.example.hp.stopwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvSplash;
    private TextView tvSubSplash;
    private Button btnget;
    private Animation splashImgAnimation, btgone, btgtwo, btnanim;
    private ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = (TextView) findViewById(R.id.tvSplash);
        tvSubSplash = (TextView) findViewById(R.id.tvSubSplash);
        btnget = (Button) findViewById(R.id.btnSplash);
        ivSplash = (ImageView) findViewById(R.id.ivSplash);

        // load the animation to the member variable
        splashImgAnimation = AnimationUtils.loadAnimation(this, R.anim.splashimganim);
        btgone = AnimationUtils.loadAnimation(this, R.anim.bgsplashtext);
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.bgsplashsubtxt);
        btnanim = AnimationUtils.loadAnimation(this, R.anim.btnsplashanim);
        SetAnimationtoViews();
        SetEventListeners();
    }

    private void SetAnimationtoViews(){
        // passing the animation to the imageSplash
        ivSplash.startAnimation(splashImgAnimation);
        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgtwo);
        btnget.startAnimation(btnanim);
    }

    private void SetEventListeners(){
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopWatchIntent = new Intent(MainActivity.this, StopActivity.class);
                stopWatchIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(stopWatchIntent);
            }
        });
    }
}
