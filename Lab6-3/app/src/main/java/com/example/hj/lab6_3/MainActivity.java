package com.example.hj.lab6_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MySQLiteOpenHelper helper;
    SQLiteDatabase db;
    ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    Button add,delete;
    EditText name,snum;
    String s_name,s_num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        name  = findViewById(R.id.sn);
        snum = findViewById(R.id.sn2);

        helper = new MySQLiteOpenHelper(MainActivity.this,"stdinfo.db",null,1);


        add.setOnClickListener(new View.OnClickListener() { //insert value
            @Override
            public void onClick(View v) {
                s_name = name.getText().toString();
                s_num = snum.getText().toString();
                if(s_name.equals("")|| s_num.equals("")){
                    Toast.makeText(getApplicationContext(),"모든 항목을 입력해주세요",Toast.LENGTH_LONG).show();
                }else {
                    insert(s_name,s_num);
                    update(); //invalidate
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() { //delete value
            @Override
            public void onClick(View v) {
                s_name = name.getText().toString();
                s_num = snum.getText().toString();

                if(s_name.equals("")){
                    Toast.makeText(getApplicationContext(),"이름을 입력해주세요",Toast.LENGTH_LONG).show();
                }
                else {
                    delete(s_name);
                    update(); //invalidate
                }
                }
        });


        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list);

        listView  = findViewById(R.id.list);
        listView.setAdapter(adapter); //listview
    }
    public void insert(String name, String snum){
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("snum", snum);

        db.insert("stdinfo",null,values);

        Log.i("SQLite","insert OK~:" + "(name:"+name+"),(snum:"+snum+")");

    }

    public void update(){
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,list);

        listView.setAdapter(adapter);


    }
    public void select(){
        db = helper.getReadableDatabase();
        Cursor c = db.query("stdinfo",null,null,null,null,null,null);

        list.clear();
        while(c.moveToNext()){

            int id = c.getInt(c.getColumnIndex("id"));
        String name = c.getString(c.getColumnIndex("name"));
        String snum = c.getString(c.getColumnIndex("snum"));
        list.add(name+" "+snum); //add to list
        }

    }
    public void delete(String name){
        db = helper.getWritableDatabase();
        db.delete("stdinfo","name=?",new String[]{name});
    }
}
