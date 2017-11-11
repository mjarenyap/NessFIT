package com.example.user.nessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDate, tvExercise, tvMins, tvCalories;
    Button btStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = (TextView) findViewById(R.id.tv_date);
        tvExercise = (TextView) findViewById(R.id.tv_exercise);
        tvMins = (TextView) findViewById(R.id.tv_mins);
        tvCalories = (TextView) findViewById(R.id.tv_calories);

        btStart = (Button) findViewById(R.id.bt_start);
    }
}
