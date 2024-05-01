package com.example.fooditemscheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox pizza, burger, momos, tacos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pizza = (CheckBox) findViewById(R.id.checkBox1);
        tacos = (CheckBox) findViewById(R.id.checkBox2);
        momos = (CheckBox) findViewById(R.id.checkBox3);
        burger = (CheckBox) findViewById(R.id.checkBox4);
    }

    public void onClick(View view){
        StringBuilder result = new StringBuilder();
        result.append("Selected items : ");
        if (pizza.isChecked())
            result.append("Pizza ");
        if (burger.isChecked())
            result.append("Burger ");
        if (momos.isChecked())
            result.append("Momos ");
        if (tacos.isChecked())
            result.append("Tacos ");
        if (pizza.isChecked() || burger.isChecked() || momos.isChecked() || tacos.isChecked())
            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();
        if (!pizza.isChecked() && !burger.isChecked() && !momos.isChecked() && !tacos.isChecked())
            Toast.makeText(this, "No items selected", Toast.LENGTH_SHORT).show();
    }
}
