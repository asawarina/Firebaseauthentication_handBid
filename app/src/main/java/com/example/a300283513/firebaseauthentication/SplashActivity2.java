package com.example.a300283513.firebaseauthentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity2.this,LoginActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task,4000);
    }
}
