package com.example.deepak.ad_farm;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Screen  extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, LogIn_Activity.class);
                startActivity(intent);

                finish();
            }

        }, SPLASH_TIME_OUT);


    }
}