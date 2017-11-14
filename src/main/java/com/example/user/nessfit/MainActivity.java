package mobapde.machineproject.nessfit;
//package com.example.user.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;

    TextView tvDate, tvExercise, tvMins, tvCalories;
    Button btStart;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(getBaseContext());
        //checks if there is a user in the User table
        checkUser();

        tvDate = (TextView) findViewById(R.id.tv_date);
        tvExercise = (TextView) findViewById(R.id.tv_exercise);
        tvMins = (TextView) findViewById(R.id.tv_mins);
        tvCalories = (TextView) findViewById(R.id.tv_calories);

        btStart = (Button) findViewById(R.id.bt_start);

        homeNav = (LinearLayout) findViewById(R.id.home_nav);
        routineNav = (LinearLayout) findViewById(R.id.routine_nav);
        exerciseNav = (LinearLayout) findViewById(R.id.exercise_nav);
        statusNav = (LinearLayout) findViewById(R.id.status_nav);

        routineNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), WeeklyActivity.class);
                startActivity(i);
            }
        });

        exerciseNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), ExerciseList.class);
                startActivity(i);
            }
        });

        statusNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), StatusActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        dbHelper.resetTable(1);
        dbHelper.resetTable(2);
        //dbHelper.resetTable(3);
    }

    public void checkUser(){
        //dbHelper.resetTable(3);
        if(dbHelper.getUser(1) == null){
            User defaultUser = new User(1, "Mike Jaren Yap", "Beginner", (float)118.0, "Male");
            dbHelper.addUser(defaultUser);
        }
    }
}