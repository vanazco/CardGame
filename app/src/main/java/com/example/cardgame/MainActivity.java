package com.example.cardgame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton bee1,bee2,bewear1,bewear2,panda1,panda2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bee1 = findViewById(R.id.bee_1);
        bee2 = findViewById(R.id.bee_2);
        bewear1 = findViewById(R.id.bewear_1);
        bewear2 = findViewById(R.id.bewear_2);
        panda1 = findViewById(R.id.panda_1);
        panda2 = findViewById(R.id.panda_2);

        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                flipCard(R.drawable.back,bee1);



                bee1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flipCard(R.drawable.bee,bee1);
                    }
                });
            }
        }.start();
    }

    private void flipCard(final int p, final ImageButton btn) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(btn, "rotationY", 0f, 180f);
        flip.setDuration(2000);
        flip.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                btn.setBackgroundResource(p);
            }
        });
        flip.start();
    }
}
