package com.example.hj.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor sp_edit;
    EditText name,num;
    Button load,save,clean;
    String userName,userNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.sn);
        num = findViewById(R.id.sn2);

        load = findViewById(R.id.load);
        save = findViewById(R.id.save);
        clean = findViewById(R.id.clean);

        save.setOnClickListener(new View.OnClickListener() { //save data
            @Override
            public void onClick(View v) {
                userName = name.getText().toString();
                userNum = num.getText().toString();
                sharedPreferences();
            }
        });

        load.setOnClickListener(new View.OnClickListener() { //load data
            @Override
            public void onClick(View v) {
                applySharedPreference();
                applySharedPreference2();
            }
        });

        clean.setOnClickListener(new View.OnClickListener() { //clean data
            @Override
            public void onClick(View v) {
                name.setText(null);
                num.setText(null);
            }
        });


    }


    public void sharedPreferences(){
        sp = getSharedPreferences("Name Num",MODE_PRIVATE);
        sp_edit = sp.edit();
        sp_edit.putString("Username",userName);
        sp_edit.putString("Usernum",userNum);
        sp_edit.commit();
    }

    public void applySharedPreference(){
        sp = getSharedPreferences("Name Num",MODE_PRIVATE);
        if(sp!=null && sp.contains("Username") && sp.contains("Usernum")){

            String rename = sp.getString("Username","noname");
            name.setText(rename);

        }
    }
    public void applySharedPreference2(){
        sp = getSharedPreferences("Name Num",MODE_PRIVATE);
        if(sp!=null && sp.contains("Usernum")){
            String renum = sp.getString("Usernum","nonum");
            num.setText(renum);
        }
    }
}
