package com.mriksani.yourtags.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mriksani.yourtags.MainActivity;
import com.mriksani.yourtags.R;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASHTIMEOUT = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent go = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(go);
                finish();
            }
        },SPLASHTIMEOUT);
    }
}
