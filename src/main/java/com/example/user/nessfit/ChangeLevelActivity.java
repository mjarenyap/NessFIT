package com.example.user.nessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ChangeLevelActivity extends AppCompatActivity {

    ImageView ivBeginner, ivIntermediate, ivExpert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_level);

        ivBeginner = (ImageView) findViewById(R.id.checkBeginner);
        ivIntermediate = (ImageView) findViewById(R.id.checkIntermediate);
        ivExpert = (ImageView) findViewById(R.id.checkExpert);

    }
}
