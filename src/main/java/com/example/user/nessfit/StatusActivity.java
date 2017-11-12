package mobapde.machineproject.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StatusActivity extends AppCompatActivity {

    TextView tvName, tvLevel, tvWeight, tvNotifications, tvGender;
    ImageView ivName, ivLevel, ivWeight, ivNotifications, ivGender;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        tvName = (TextView) findViewById(R.id.tv_name);
        tvLevel = (TextView) findViewById(R.id.tv_level);
        tvWeight = (TextView) findViewById(R.id.tv_weight);
        tvNotifications = (TextView) findViewById(R.id.tv_notif);
        tvGender = (TextView) findViewById(R.id.tv_gender);

        ivName = (ImageView) findViewById(R.id.iv_name);
        ivLevel = (ImageView) findViewById(R.id.iv_level);
        ivWeight = (ImageView) findViewById(R.id.iv_weight);
        ivNotifications = (ImageView) findViewById(R.id.iv_notif);
        ivGender = (ImageView) findViewById(R.id.iv_gender);

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
