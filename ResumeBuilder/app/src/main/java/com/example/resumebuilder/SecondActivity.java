package com.example.resumebuilder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private RadioButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        Button save = findViewById(R.id.button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = male.isChecked() ? "Male" : female.isChecked() ? "Female" : "";
                if(male.isChecked() || female.isChecked())
                    Toast.makeText(SecondActivity.this, "Data saved successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}