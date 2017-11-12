package mobapde.machineproject.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ChangeLevelActivity extends AppCompatActivity {

    ImageView ivBeginner, ivIntermediate, ivExpert;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_level);

        ivBeginner = (ImageView) findViewById(R.id.checkBeginner);
        ivIntermediate = (ImageView) findViewById(R.id.checkIntermediate);
        ivExpert = (ImageView) findViewById(R.id.checkExpert);

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