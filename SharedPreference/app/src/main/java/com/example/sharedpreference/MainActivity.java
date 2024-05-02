package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "My Prefs";
    private static final String KEY_NAME = "name";
    EditText text;
    Button save, delete;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.text);
        save = (Button) findViewById(R.id.save);
        delete = (Button) findViewById(R.id.delete);
        textView = (TextView) findViewById(R.id.textView);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });

        retrieveData();
    }

    private void retrieveData() {
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedName = sp.getString(KEY_NAME, "");
        textView.setText(savedName);
    }

    private void deleteData() {
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(KEY_NAME);
        editor.apply();
        textView.setText("");
        Toast.makeText(this, "Data deleted successfully", Toast.LENGTH_LONG).show();
    }

    private void saveData() {
        String s = text.getText().toString();

        if(!s.isEmpty()){
            SharedPreferences sp = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(KEY_NAME, s);
            editor.apply();
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this, "Error saving data", Toast.LENGTH_LONG).show();

    }
}