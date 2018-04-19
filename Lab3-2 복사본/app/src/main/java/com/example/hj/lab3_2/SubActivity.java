package com.example.hj.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    Button button;
    TextView name;
    TextView sex;
    TextView check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        button = (Button)findViewById(R.id.button2);
        name = (TextView)findViewById(R.id.name);
        sex = (TextView)findViewById(R.id.sex);
        check = (TextView)findViewById(R.id.check);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        sex.setText(intent.getStringExtra("sex"));
        check.setText(intent.getStringExtra("check"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }
}
