package mobapde.machineproject.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ChangeGenderActivity extends AppCompatActivity {

    ImageView ivMale, ivFemale;
    LinearLayout changeMale, changeFemale;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_gender);

        ivMale = (ImageView) findViewById(R.id.checkMale);
        ivFemale = (ImageView) findViewById(R.id.checkFemale);

        changeMale = (LinearLayout) findViewById(R.id.change_to_male);
        changeFemale = (LinearLayout) findViewById(R.id.change_to_female);

        homeNav = (LinearLayout) findViewById(R.id.home_nav);
        routineNav = (LinearLayout) findViewById(R.id.routine_nav);
        exerciseNav = (LinearLayout) findViewById(R.id.exercise_nav);
        statusNav = (LinearLayout) findViewById(R.id.status_nav);

        String currGender = getIntent().getExtras().getString("currStatus");
        if(currGender.equalsIgnoreCase("Male")){
            ivMale.setImageResource(R.drawable.check_mark);
            ivFemale.setImageResource(R.drawable.check_mark_white);
        }

        else if(currGender.equalsIgnoreCase("Female")){
            ivMale.setImageResource(R.drawable.check_mark_white);
            ivFemale.setImageResource(R.drawable.check_mark);
        }

        changeMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivMale.setImageResource(R.drawable.check_mark);
                ivFemale.setImageResource(R.drawable.check_mark_white);

                Intent i = new Intent();
                i.putExtra("currStatus", "Male");
                setResult(RESULT_OK, i);
                finish();
            }
        });

        changeFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivMale.setImageResource(R.drawable.check_mark_white);
                ivFemale.setImageResource(R.drawable.check_mark);

                Intent i = new Intent();
                i.putExtra("currStatus", "Female");
                setResult(RESULT_OK, i);
                finish();
            }
        });

        homeNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        routineNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), WeeklyActivity.class);
                startActivity(i);
                finish();
            }
        });

        exerciseNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), ExerciseList.class);
                startActivity(i);
                finish();
            }
        });

        statusNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), StatusActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
