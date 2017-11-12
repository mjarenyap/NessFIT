package mobapde.machineproject.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDate, tvExercise, tvMins, tvCalories;
    Button btStart;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}