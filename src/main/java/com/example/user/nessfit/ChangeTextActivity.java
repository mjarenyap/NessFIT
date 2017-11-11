package com.example.user.nessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ChangeTextActivity extends AppCompatActivity {

    EditText etChangeName;
    Button btChangeName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_text);

        etChangeName = (EditText) findViewById(R.id.et_changeName);
        btChangeName = (Button) findViewById(R.id.bt_save_changeName);


    }
}
