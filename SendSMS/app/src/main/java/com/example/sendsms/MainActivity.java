package com.example.sendsms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private EditText text, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        text = (EditText) findViewById(R.id.editTextText);
        phone = (EditText) findViewById(R.id.editTextPhone);
        Button button = findViewById(R.id.button);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }

    private void sendSMS() {
        String phoneNumber = phone.getText().toString();
        String message = text.getText().toString();

        if (phoneNumber.isEmpty() || message.isEmpty()){
            Toast.makeText(this, "Please enter the phone number and the message", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));
        intent.putExtra("sms_body", message);

        try {
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this, "Error sending SMS", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
