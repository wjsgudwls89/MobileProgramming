package com.example.hj.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button button;
    LinearLayout layout;
    Animation left;
    Animation right;

    boolean state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAnimationListener listener = new setAnimationListener();
        button = (Button) findViewById(R.id.button);
        layout  = (LinearLayout) findViewById(R.id.layout2);
        left = AnimationUtils.loadAnimation(this, R.anim.anim_slide_left);
        right  = AnimationUtils.loadAnimation(this, R.anim.anim_slide_right);

        left.setAnimationListener(listener);
        right.setAnimationListener(listener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state) {
                    layout.startAnimation(right); //start animation
                } else {
                    layout.setVisibility(View.VISIBLE);  //visible to sliding layout
                    layout.startAnimation(left); //start animation
                }
            }
        });
    }
    class setAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation){

        }
        @Override
        public void onAnimationEnd(Animation animation){
            if(state){
                layout.setVisibility(View.INVISIBLE);
                button.setText("Open Page"); //change button name
                state = false;
            }
            else{
                button.setText("Close Page"); //change button name
                state = true;
            }

        }
        @Override
        public void onAnimationRepeat(Animation animation){}


    }



}

