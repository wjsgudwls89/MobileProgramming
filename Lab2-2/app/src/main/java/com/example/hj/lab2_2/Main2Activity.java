package com.example.hj.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Button button2 = (Button)findViewById(R.id.button2); //Go button
        Button button3 = (Button)findViewById(R.id.button3); //Back button
        TextView text = (TextView)findViewById(R.id.text);
        if(intent != null){
            url=intent.getStringExtra("URL");
            text.setText(url);
            if(url.isEmpty())
                Toast.makeText(getApplicationContext(),"주소를 다시 입력해주세요",Toast.LENGTH_LONG).show();

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+url)));
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"뒤로가기 버튼을 눌렀습니다",Toast.LENGTH_LONG).show();
                    finish();
                }
            });
        }
    }
}
