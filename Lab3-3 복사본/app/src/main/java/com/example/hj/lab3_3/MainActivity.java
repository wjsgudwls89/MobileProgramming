package com.example.hj.lab3_3;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Button tap1;
    Button tap2;
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tap1 = (Button)findViewById(R.id.button1);
        tap2 = (Button)findViewById(R.id.button2);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        tap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
            }
        });
        tap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
            }
        });
    }
}
