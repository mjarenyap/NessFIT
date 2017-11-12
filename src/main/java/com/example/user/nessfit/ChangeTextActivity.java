package mobapde.machineproject.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ChangeTextActivity extends AppCompatActivity {

    EditText etChangeName;
    Button btChangeName;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_text);

        etChangeName = (EditText) findViewById(R.id.et_changeName);
        btChangeName = (Button) findViewById(R.id.bt_save_changeName);

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
