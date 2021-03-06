package com.example.cardgame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageButton;

public class Card {

    ImageButton btn;
    boolean flip;

    public Card(){
        flip = false;
    }

    public void flipCard(final int p) {
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
    public void checkCards(boolean card2,Card flipped){
        if(flip && !card2){
            flipCard(R.drawable.back);
            flipped.flipCard(R.drawable.back);
        }
    }
}
