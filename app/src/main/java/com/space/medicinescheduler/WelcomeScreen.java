package com.space.medicinescheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    public void registerUser(View view) {
        //starting new activity
        Intent homeScreen = new Intent(getApplicationContext(), HomeScreen.class);
        startActivity(homeScreen);
    }
}
