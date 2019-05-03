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
    boolean boo1,boo2;
    int cartas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boo1 = false;
        boo2 = false;
        cartas = 0;

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
                flipCard(R.drawable.back,bee2);
                flipCard(R.drawable.back,bewear1);
                flipCard(R.drawable.back,bewear2);
                flipCard(R.drawable.back,panda1);
                flipCard(R.drawable.back,panda2);


                bee1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!boo1){
                            flipCard(R.drawable.bee,bee1);
                            boo1 = true;
                            cartas++;
                            // CHECK CARTAS
                        }else if (boo1 && boo2) {
                                bee1.setClickable(false);
                            }
                        }
                });
                bee2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!boo2){
                            flipCard(R.drawable.bee,bee2);
                            boo2 = true;
                            cartas++;
                        }else if (boo1 && boo2) {
                                bee2.setClickable(false);
                            }
                        }
                });
                bewear1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flipCard(R.drawable.bewear,bewear1);
                        cartas++;
                    }
                });
                bewear2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flipCard(R.drawable.bewear,bewear2);
                        cartas++;
                    }
                });
                panda1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flipCard(R.drawable.panda,panda1);
                        cartas++;
                    }
                });
                panda2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flipCard(R.drawable.panda,panda2);
                        cartas++;
                    }
                });
            }
        }.start();

    }

    private void flipCard(final int p, final ImageButton btn) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(btn, "rotationY", 0f, 90f);
        final ObjectAnimator flip2 = ObjectAnimator.ofFloat(btn, "rotationY", 90f, 180f);
        flip.setDuration(1000);
        flip2.setDuration(1000);
        flip.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                btn.setBackgroundResource(p);
                flip2.start();
            }
        });
        flip.start();
    }

}
