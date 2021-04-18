package com.example.tourplanner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class splashScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
           @Override
           public void run() {
               startActivity(new Intent(getApplicationContext(),login.class));
               finish();
           }
       }, 3000);
    }
}