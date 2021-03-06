package mobapde.machineproject.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChangeTextActivity extends AppCompatActivity {

    LinearLayout homeNav, routineNav, exerciseNav, statusNav;
    EditText changeText;
    TextView changeGuide;
    Button saveChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_text);

        changeText = (EditText) findViewById(R.id.et_change_text);
        changeGuide = (TextView) findViewById(R.id.change_guide);
        saveChange = (Button) findViewById(R.id.bt_save_change_text);

        homeNav = (LinearLayout) findViewById(R.id.home_nav);
        routineNav = (LinearLayout) findViewById(R.id.routine_nav);
        exerciseNav = (LinearLayout) findViewById(R.id.exercise_nav);
        statusNav = (LinearLayout) findViewById(R.id.status_nav);

        changeGuide.setText(getIntent().getExtras().getString("changeGuide"));
        changeText.setText(String.valueOf(getIntent().getExtras().getString("currStatus")));

        saveChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newInfo = changeText.getText().toString();
                Intent i = new Intent();
                i.putExtra("currStatus", newInfo);
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
