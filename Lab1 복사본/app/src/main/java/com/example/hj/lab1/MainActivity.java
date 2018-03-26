package com.example.hj.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;

    int imageIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //showing image

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setImageResource(R.drawable.android_red);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.android_blue);
        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.INVISIBLE);


        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                changeImage();
            }

            //changing image operation

            public void changeImage(){
                if(imageIndex%2==0){
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                }
                else if(imageIndex%2==1){
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);

                }
                imageIndex++;

            }
        });


    }
}
