package com.example.hj.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edittext;
    Button calculate;
    TextView loading;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = findViewById(R.id.edittext);
        calculate = findViewById(R.id.button);
        loading  = findViewById(R.id.loading);
        total = findViewById(R.id.total);



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Factorial().execute(Integer.parseInt(edittext.getText().toString())); // send input num

            }
        });
    }
    class Factorial extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            total.setText("=?");
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);

            total.setText("="+result); //show result
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int num = integers[0];
            int result =1;
            loading.setText("");
            //calculate factorial
            for(int i=num; i>0 ; i--){
                result = result * i;
                loading.append(" "+i);
                try{Thread.sleep(500);} //sleep 500ms
                catch(InterruptedException e){}
            }
            return result;
        }
    }
}
