package com.example.generaterandomcolour;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView view;
    Button generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        generate = (Button) findViewById(R.id.button);
        view = (TextView) findViewById(R.id.textView);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomColor();
            }
        });
    }

    private void randomColor() {
        Random r = new Random();
        int color = Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        view.setBackgroundColor(color);
    }
}