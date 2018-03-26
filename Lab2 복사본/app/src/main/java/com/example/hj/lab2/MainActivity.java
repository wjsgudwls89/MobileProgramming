package com.example.hj.lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edittext = (EditText) findViewById(R.id.edittext);
        Button button = (Button) findViewById(R.id.PRINT);
        Button button2 = (Button) findViewById(R.id.CLEAR);
        final TextView textview = (TextView) findViewById(R.id.newtext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //Edit Text
            public void onClick(View view) {
                textview.setText(edittext.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            //Clear text
            public void onClick(View view) {
                textview.setText("contents");
                edittext.setText("");

            }
        });
    }

}
