package com.example.hj.lab2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Age;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.text1);
        Age = (EditText) findViewById(R.id.text2);
        button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginName = Name.getText().toString();
                String loginAge = Age.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                Bundle newBundle1 = new Bundle();

                newBundle1.putString("name",loginName); //input Name to bundle
                newBundle1.putString("age",loginAge); //input Age to bundle

                intent.putExtras(newBundle1); //input bundle to intent
                startActivity(intent); //startActivity
            }

        });

    }
}
