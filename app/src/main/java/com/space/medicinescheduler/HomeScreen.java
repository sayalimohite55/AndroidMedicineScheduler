package com.space.medicinescheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void createSchedule(View view) {
        //new activity create schedule
        Intent createSchedule = new Intent(getApplicationContext(), CreateScheduleActivity.class);
        startActivity(createSchedule);
    }

    public void listSchedules(View view) {
        //new activity list out all schedules
        Intent listSchedule = new Intent(getApplicationContext(), ListSchedule.class);
        startActivity(listSchedule);
    }
}
