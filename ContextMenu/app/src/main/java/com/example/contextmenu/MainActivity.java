package com.example.contextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView changeColor;
    RelativeLayout rel_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        changeColor = (TextView) findViewById(R.id.textView);
        rel_layout = (RelativeLayout) findViewById(R.id.rel_layout);

        registerForContextMenu(changeColor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose a color");
        menu.add("Red");
        menu.add("Green");
        menu.add("Blue");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if (item.getTitle() == "Red")
            rel_layout.setBackgroundColor(Color.RED);
        else if (item.getTitle() == "Green") {
            rel_layout.setBackgroundColor(Color.GREEN);
        } else if (item.getTitle() == "Blue") {
            rel_layout.setBackgroundColor(Color.BLUE);
        }
        return true;
    }
}