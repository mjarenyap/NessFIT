package mobapde.machineproject.nessfit;
//package com.example.user.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StatusActivity extends AppCompatActivity {

    TextView tvName, tvLevel, tvWeight, tvNotifications, tvGender;
    LinearLayout changeName, changeLevel, changeWeight, changeNotif, changeGender;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;
    DatabaseHelper dbHelper;
    User currUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        tvName = (TextView) findViewById(R.id.tv_name);
        tvLevel = (TextView) findViewById(R.id.tv_level);
        tvWeight = (TextView) findViewById(R.id.tv_weight);
        tvNotifications = (TextView) findViewById(R.id.tv_notif);
        tvGender = (TextView) findViewById(R.id.tv_gender);

        changeName = (LinearLayout) findViewById(R.id.bt_change_name);
        changeLevel = (LinearLayout) findViewById(R.id.bt_change_training_level);
        changeWeight = (LinearLayout) findViewById(R.id.bt_change_weight);
        changeNotif = (LinearLayout) findViewById(R.id.bt_change_notifications);
        changeGender = (LinearLayout) findViewById(R.id.bt_change_gender);

        homeNav = (LinearLayout) findViewById(R.id.home_nav);
        routineNav = (LinearLayout) findViewById(R.id.routine_nav);
        exerciseNav = (LinearLayout) findViewById(R.id.exercise_nav);
        statusNav = (LinearLayout) findViewById(R.id.status_nav);

        dbHelper = new DatabaseHelper(getBaseContext());
        currUser = dbHelper.getUser(1);

        tvName.setText(currUser.getName());
        tvLevel.setText(currUser.getTrainingLevel());
        tvWeight.setText(String.valueOf(currUser.getWeight()) + "lbs");
        tvGender.setText(currUser.getGender());

        changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), ChangeTextActivity.class);
                i.putExtra("changeGuide", "CHANGE YOUR NAME");
                i.putExtra("currStatus", currUser.getName());

                startActivityForResult(i, 0);
            }
        });

        changeWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), ChangeTextActivity.class);
                i.putExtra("changeGuide", "UPDATE YOUR WEIGHT");
                i.putExtra("currStatus", String.valueOf(currUser.getWeight()));

                startActivityForResult(i, 1);
            }
        });

        changeLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), ChangeLevelActivity.class);
                i.putExtra("currStatus", currUser.getTrainingLevel());

                startActivityForResult(i, 2);
            }
        });

        changeGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), ChangeGenderActivity.class);
                i.putExtra("currStatus", currUser.getGender());

                startActivityForResult(i, 3);
            }
        });

        homeNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // request to change name
        if(resultCode == RESULT_OK && requestCode == 0){
            String newName = data.getExtras().getString("currStatus");
            currUser.setName(newName);
            dbHelper.updateUser(currUser);
            tvName.setText(newName);
        }

        else if(resultCode == RESULT_OK && requestCode == 1){
            float newWeight = Float.parseFloat(data.getExtras().getString("currStatus"));
            currUser.setWeight(newWeight);
            dbHelper.updateUser(currUser);
            tvWeight.setText(String.valueOf(newWeight) + "lbs");
        }

        else if(resultCode == RESULT_OK && requestCode == 2){
            String newLevel = data.getExtras().getString("currStatus");
            currUser.setTrainingLevel(newLevel);
            dbHelper.updateUser(currUser);
            tvLevel.setText(newLevel);
        }

        else if(resultCode == RESULT_OK && requestCode == 3){
            String newGender = data.getExtras().getString("currStatus");
            currUser.setGender(newGender);
            dbHelper.updateUser(currUser);
            tvGender.setText(newGender);
        }
    }
}
