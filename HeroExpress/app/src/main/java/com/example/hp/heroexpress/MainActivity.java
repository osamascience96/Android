package com.example.hp.heroexpress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView resultRate;
    private ImageView charPlace;
    private RatingBar rateStars;
    private Button buttonfeed;
    private Animation charAnimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init the variables
        resultRate = findViewById(R.id.resultrate);
        charPlace = findViewById(R.id.charPlace);
        rateStars = findViewById(R.id.rateStars);
        buttonfeed = findViewById(R.id.btnfeedback);
        charAnimate = AnimationUtils.loadAnimation(this, R.anim.charanim);

        //give animate
        charPlace.startAnimation(charAnimate);

        SetRatingRsults();

        buttonfeed.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Review Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void SetRatingRsults(){
        rateStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int answer = (int) Math.floor(rateStars.getRating());

                if (answer == 1){
                    charPlace.setImageResource(R.drawable.ic_onestar);
                    //give animate
                    charPlace.startAnimation(charAnimate);
                    resultRate.setText("Just So So");
                }else if (answer == 2){
                    charPlace.setImageResource(R.drawable.ic_twostar);
                    //give animate
                    charPlace.startAnimation(charAnimate);
                    resultRate.setText("Good");
                }else if (answer == 3){
                    charPlace.setImageResource(R.drawable.ic_threestar);
                    //give animate
                    charPlace.startAnimation(charAnimate);
                    resultRate.setText("Good Job");
                }else if (answer == 4){
                    charPlace.setImageResource(R.drawable.ic_fourstar);
                    //give animate
                    charPlace.startAnimation(charAnimate);
                    resultRate.setText("Well Done");
                }else if (answer == 5){
                    charPlace.setImageResource(R.drawable.ic_fivestar);
                    //give animate
                    charPlace.startAnimation(charAnimate);
                    resultRate.setText("Awesome");
                }else {
                    Toast.makeText(getApplicationContext(), "No Point", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
