package com.example.user.nessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoActivity extends AppCompatActivity {

    ImageView ivPhoto;
    TextView tvAddPhoto;
    EditText etTitle, etDesc;
    Button btSaveExe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        ivPhoto = (ImageView) findViewById(R.id.iv_photo);
        tvAddPhoto = (TextView) findViewById(R.id.tv_addPhoto);
        etTitle = (EditText) findViewById(R.id.et_title);
        etDesc = (EditText) findViewById(R.id.et_desc);
        btSaveExe = (Button) findViewById(R.id.bt_save_exercise);
    }
}
