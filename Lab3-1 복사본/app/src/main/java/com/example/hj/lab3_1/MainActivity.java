package com.example.hj.lab3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        registerForContextMenu(button);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Button Menu");
        MenuItem menu1 = menu.add(0, 0, 0, "Red");
        MenuItem menu2 = menu.add(0, 1, 0, "Green");
        MenuItem menu3 = menu.add(0, 2, 0, "Blue");

    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                button.setTextColor(Color.RED);
                break;
            case 1:
                button.setTextColor(Color.GREEN);
                break;
            case 2:
                button.setTextColor(Color.BLUE);
                break;
            default:break;
        }
        return super.onContextItemSelected(item);
    }
}