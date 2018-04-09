package com.example.hj.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button1); //Next button
        url = (EditText)findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = url.getText().toString(); //input string
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("URL",URL); //input string to intent
                startActivity(intent);
            }
        });
    }
}
