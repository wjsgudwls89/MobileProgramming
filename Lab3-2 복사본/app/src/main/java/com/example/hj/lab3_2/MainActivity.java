package com.example.hj.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    RadioButton male;
    RadioButton female;
    CheckBox sms;
    CheckBox email;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.edittext);
        male = (RadioButton) findViewById(R.id.man);
        female = (RadioButton) findViewById(R.id.woman);
        sms=(CheckBox) findViewById(R.id.sms);
        email=(CheckBox) findViewById(R.id.email);
        button =(Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getname = editText.getText().toString();
                String getsex=" ";
                String check=" ";
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);

                if(male.isChecked())
                    getsex=male.getText().toString();
                else if(female.isChecked())
                    getsex=female.getText().toString();

                if(sms.isChecked())
                    check = check + sms.getText().toString();
                if(email.isChecked())
                    check = check+ email.getText().toString();

                intent.putExtra("name",getname);
                intent.putExtra("sex",getsex);
                intent.putExtra("check",check);
                startActivity(intent);
                finish();
            }
        });
    }
}
