package com.example.a1796122.jacapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Info extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView childTv;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        childTv = findViewById(R.id.info_tv);
        Intent intentReceived = getIntent();
        if (intentReceived.hasExtra(Intent.EXTRA_TEXT)) {
            String stringReceived = intentReceived.getStringExtra(Intent.EXTRA_TEXT);
            childTv.setText(stringReceived);
        }


    }
}

