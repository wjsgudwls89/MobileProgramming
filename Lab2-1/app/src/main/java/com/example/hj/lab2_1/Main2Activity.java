package com.example.hj.lab2_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent(); //get intent
        if(intent != null) {
            Bundle getBundle1 = intent.getExtras();
            String name = getBundle1.getString("name");
            String age = getBundle1.getString("age");

            Toast.makeText(this, "Student Info:" + name + "," + age, Toast.LENGTH_LONG).show();
            //show Toast
        }
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    }

