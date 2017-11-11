package com.example.user.nessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AddExercise extends AppCompatActivity {

    TextView exeHere, exeNumber;
    Button btAddExe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        exeHere = (TextView) findViewById(R.id.tv_exeHere);
        exeNumber = (TextView) findViewById(R.id.tv_exeNumber);

        btAddExe = (Button) findViewById(R.id.bt_addExe);
    }
}
