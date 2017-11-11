package com.example.user.nessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseActivity extends AppCompatActivity {

    TextView tvexeTitle, tvexeDesc;
    Button btAddRoutine, btPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        tvexeTitle = (TextView) findViewById(R.id.tv_exeTitle);
        tvexeDesc = (TextView) findViewById(R.id.tv_exeDesc);

        btAddRoutine = (Button) findViewById(R.id.bt_routine);
        btPlay = (Button) findViewById(R.id.bt_play);
    }
}
