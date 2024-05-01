package com.example.phonecall;

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

    private EditText phone;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        phone = (EditText) findViewById(R.id.editTextPhone);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    private void makePhoneCall() {
        String phoneNumber = phone.getText().toString();

        if (phoneNumber.isEmpty()){
            Toast.makeText(this, "Enter the phone number", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
        try {
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this, "Error making the phone call", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
}
