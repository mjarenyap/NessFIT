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
    LinearLayout changeBeginner, changeIntermediate, changeExpert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_level);

        ivBeginner = (ImageView) findViewById(R.id.checkBeginner);
        ivIntermediate = (ImageView) findViewById(R.id.checkIntermediate);
        ivExpert = (ImageView) findViewById(R.id.checkExpert);

        changeBeginner = (LinearLayout) findViewById(R.id.change_to_beginner);
        changeIntermediate = (LinearLayout) findViewById(R.id.change_to_intermediate);
        changeExpert = (LinearLayout) findViewById(R.id.change_to_expert);

        homeNav = (LinearLayout) findViewById(R.id.home_nav);
        routineNav = (LinearLayout) findViewById(R.id.routine_nav);
        exerciseNav = (LinearLayout) findViewById(R.id.exercise_nav);
        statusNav = (LinearLayout) findViewById(R.id.status_nav);

        String currLevel = getIntent().getExtras().getString("currStatus");
        if(currLevel.equalsIgnoreCase("Beginner")){
            ivBeginner.setImageResource(R.drawable.check_mark);
            ivIntermediate.setImageResource(R.drawable.check_mark_white);
            ivExpert.setImageResource(R.drawable.check_mark_white);
        }

        else if(currLevel.equalsIgnoreCase("Intermediate")){
            ivBeginner.setImageResource(R.drawable.check_mark_white);
            ivIntermediate.setImageResource(R.drawable.check_mark);
            ivExpert.setImageResource(R.drawable.check_mark_white);
        }

        else if(currLevel.equalsIgnoreCase("Expert")){
            ivBeginner.setImageResource(R.drawable.check_mark_white);
            ivIntermediate.setImageResource(R.drawable.check_mark_white);
            ivExpert.setImageResource(R.drawable.check_mark);
        }


        changeBeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivBeginner.setImageResource(R.drawable.check_mark);
                ivIntermediate.setImageResource(R.drawable.check_mark_white);
                ivExpert.setImageResource(R.drawable.check_mark_white);

                Intent i = new Intent();
                i.putExtra("currStatus", "Beginner");
                setResult(RESULT_OK, i);
                finish();
            }
        });

        changeIntermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivBeginner.setImageResource(R.drawable.check_mark_white);
                ivIntermediate.setImageResource(R.drawable.check_mark);
                ivExpert.setImageResource(R.drawable.check_mark_white);

                Intent i = new Intent();
                i.putExtra("currStatus", "Intermediate");
                setResult(RESULT_OK, i);
                finish();
            }
        });

        changeExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivBeginner.setImageResource(R.drawable.check_mark_white);
                ivIntermediate.setImageResource(R.drawable.check_mark_white);
                ivExpert.setImageResource(R.drawable.check_mark);

                Intent i = new Intent();
                i.putExtra("currStatus", "Expert");
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