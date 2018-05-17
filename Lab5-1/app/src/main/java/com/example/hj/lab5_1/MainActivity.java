package com.example.hj.lab5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imgview1);
        imageView2 = findViewById(R.id.imgview2);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DogThread thrd1 = new DogThread(0);
                thrd1.start();
                DogThread thrd2 = new DogThread(1);
                thrd2.start();

            }
        });
    }
    class DogThread extends Thread {
        int dogindex;
        int stateindex;

        ArrayList<Integer> images = new ArrayList<Integer>();

        public DogThread(int index) {
            dogindex = index;
            //setting image
            images.add(R.drawable.dog1);
            images.add(R.drawable.dog2);
            images.add(R.drawable.dog3);

        }
        public void run(){
            stateindex = 0;
            for (int i=0;i<9;i++){
                final String msg = "dog #" + dogindex + "state: "+stateindex;
                handler.post(new Runnable() {
                    public void run() {
                        editText.append(msg + "\n");
                        if (dogindex == 0) {
                            imageView1.setImageResource(images.get(stateindex)); //get state index
                        } else if (dogindex == 1) {
                            imageView2.setImageResource(images.get(stateindex)); //get state index
                        }
                    }});
                try{int sleepTime = getRandomTime(500,3000);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                stateindex ++;
                if(stateindex >= images.size()){
                    stateindex = 0;
                }
            }
        }
    }
    //return random time
    public int getRandomTime(int min, int max){
        return min+(int)(Math.random() * (max-min));
    }
}
