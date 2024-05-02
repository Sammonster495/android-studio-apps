package com.example.resumebuilder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText name, phone, email, qualifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        qualifications = (EditText) findViewById(R.id.phone);
        Button next = findViewById(R.id.button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity();
            }
        });
    }

    private void switchActivity() {
        String n = name.getText().toString();
        String p = phone.getText().toString();
        String e = email.getText().toString();
        String q = qualifications.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Name", n);
        intent.putExtra("Email", e);
        intent.putExtra("Phone Number", p);
        intent.putExtra("Qualifications", q);
        startActivity(intent);
    }
}