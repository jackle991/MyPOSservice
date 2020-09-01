package com.example.jackle91.myposservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Button b1 = (Button) findViewById(R.id.createNewTicket);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i1 = new Intent(WelcomeActivity.this, CreateTicket.class);
                startActivity(i1);
            }
        });

        Button b2 = (Button) findViewById(R.id.viewTicket);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i1 = new Intent(WelcomeActivity.this, ViewTicket.class);
                startActivity(i1);
            }
        });
    }
}
