package com.example.hj.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    File sdCard = Environment.getExternalStorageDirectory();
    File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
    File file = new File(directory,"lab 6-1.txt"); //naming file
    String txtData;
    EditText editText;
    Button writeSD,clear,readSD,finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        directory.mkdirs(); //if no folder , make folder
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.txtData);
        writeSD = findViewById(R.id.writeSD);
        clear = findViewById(R.id.clearScreen);
        readSD = findViewById(R.id.readSD);
        finish = findViewById(R.id.finish);

        txtData = editText.getText().toString();

        writeSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    String str = editText.getText().toString();
                    osw.write(str, 0, str.length());
                    osw.flush(); //insert value to file
                    osw.close();
                    fOut.close();
                    Toast.makeText(getApplicationContext(), "Done writing SD 'lab 6-1.txt'", Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            editText.setText(null);
            } //clear
        });
        readSD.setOnClickListener(new View.OnClickListener() { //read data
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn);
                    StringBuffer buf = new StringBuffer();
                    while (isr.ready()) {
                        buf.append((char) isr.read());
                    }
                    editText.setText(buf.toString());
                    isr.close();
                    fIn.close();
                    Toast.makeText(getApplicationContext(), "Done Reading SD 'lab 6-1.txt'", Toast.LENGTH_SHORT).show();

                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
