package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText operand1, operand2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        operand1 = (EditText) findViewById(R.id.operand1);
        operand2 = (EditText) findViewById(R.id.operand2);
        result = (EditText) findViewById(R.id.result);
    }
    public void Add(View view){
        int n1 = Integer.parseInt(operand1.getText().toString());
        int n2 = Integer.parseInt(operand2.getText().toString());
        result.setText(getString(R.string.result_string, (n1+n2)));
    }
    public void Subtract(View view){
        int n1 = Integer.parseInt(operand1.getText().toString());
        int n2 = Integer.parseInt(operand2.getText().toString());
        result.setText(getString(R.string.result_string, (n1-n2)));
    }
    public void Multiply(View view){
        int n1 = Integer.parseInt(operand1.getText().toString());
        int n2 = Integer.parseInt(operand2.getText().toString());
        result.setText(getString(R.string.result_string, (n1*n2)));
    }
    public void Divide(View view){
        int n1 = Integer.parseInt(operand1.getText().toString());
        int n2 = Integer.parseInt(operand2.getText().toString());
        result.setText(getString(R.string.result_string, (n1/n2)));
    }
}