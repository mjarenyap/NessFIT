package mobapde.machineproject.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeeklyActivity extends AppCompatActivity {

    TextView tvSun, tvMon, tvTues, tvWed, tvThurs, tvFri, tvSat;
    ImageView ivSun, ivMon, ivTues, ivWed, ivThurs, ivFri, ivSat;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);

        tvSun = (TextView) findViewById(R.id.tv_sun);
        tvMon = (TextView) findViewById(R.id.tv_mon);
        tvTues = (TextView) findViewById(R.id.tv_tues);
        tvWed = (TextView) findViewById(R.id.tv_wed);
        tvThurs = (TextView) findViewById(R.id.tv_thurs);
        tvFri = (TextView) findViewById(R.id.tv_fri);
        tvSat = (TextView) findViewById(R.id.tv_sat);

        ivSun = (ImageView) findViewById(R.id.iv_sun);
        ivMon = (ImageView) findViewById(R.id.iv_mon);
        ivTues = (ImageView) findViewById(R.id.iv_tues);
        ivWed = (ImageView) findViewById(R.id.iv_wed);
        ivThurs = (ImageView) findViewById(R.id.iv_thurs);
        ivFri = (ImageView) findViewById(R.id.iv_fri);
        ivSat = (ImageView) findViewById(R.id.iv_sat);

        homeNav = (LinearLayout) findViewById(R.id.home_nav);
        routineNav = (LinearLayout) findViewById(R.id.routine_nav);
        exerciseNav = (LinearLayout) findViewById(R.id.exercise_nav);
        statusNav = (LinearLayout) findViewById(R.id.status_nav);

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
