package mobapde.machineproject.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeeklyActivity extends AppCompatActivity {

    TextView countSun, countMon, countTues, countWed, countThurs, countFri, countSat;
    LinearLayout weekSun, weekMon, weekTues, weekWed, weekThurs, weekFri, weekSat;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);

        weekSun = (LinearLayout) findViewById(R.id.week_sun);
        weekMon = (LinearLayout) findViewById(R.id.week_mon);
        weekTues = (LinearLayout) findViewById(R.id.week_tues);
        weekWed = (LinearLayout) findViewById(R.id.week_wed);
        weekThurs = (LinearLayout) findViewById(R.id.week_thurs);
        weekFri = (LinearLayout) findViewById(R.id.week_fri);
        weekSat = (LinearLayout) findViewById(R.id.week_sat);

        countSun = (TextView) findViewById(R.id.count_sun);
        countMon = (TextView) findViewById(R.id.count_mon);
        countTues = (TextView) findViewById(R.id.count_tues);
        countWed = (TextView) findViewById(R.id.count_wed);
        countThurs = (TextView) findViewById(R.id.count_thurs);
        countFri = (TextView) findViewById(R.id.count_fri);
        countSat = (TextView) findViewById(R.id.count_sat);

        homeNav = (LinearLayout) findViewById(R.id.home_nav);
        routineNav = (LinearLayout) findViewById(R.id.routine_nav);
        exerciseNav = (LinearLayout) findViewById(R.id.exercise_nav);
        statusNav = (LinearLayout) findViewById(R.id.status_nav);

        weekSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), AddExercise.class);
                startActivity(i);
            }
        });

        weekMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), AddExercise.class);
                startActivity(i);
            }
        });

        weekTues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), AddExercise.class);
                startActivity(i);
            }
        });

        weekWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), AddExercise.class);
                startActivity(i);
            }
        });

        weekThurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), AddExercise.class);
                startActivity(i);
            }
        });

        weekFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), AddExercise.class);
                startActivity(i);
            }
        });

        weekSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), AddExercise.class);
                startActivity(i);
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
}
