package com.example.jackle91.myposservice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hanks.passcodeview.PasscodeView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    PasscodeView passcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passcodeView = findViewById(R.id.passcodeView);
        passcodeView.setPasscodeLength(4)
                .setLocalPasscode("1234")
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {
                        Toast.makeText(getApplicationContext(), "Password is Wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String number) {
                        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                    }
                });
    }
}
