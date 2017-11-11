package com.example.user.nessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StatusActivity extends AppCompatActivity {

    TextView tvName, tvLevel, tvWeight, tvNotifications, tvGender;
    ImageView ivName, ivLevel, ivWeight, ivNotifications, ivGender;

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
    }
}
