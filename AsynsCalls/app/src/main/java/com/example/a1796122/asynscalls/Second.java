package com.example.a1796122.asynscalls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Second extends AppCompatActivity{
    TextView childTv;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        childTv = findViewById(R.id.child_tv);
        Intent intentReceived = getIntent();
        if(intentReceived.hasExtra(Intent.EXTRA_TEXT)){
            String stringReceived = intentReceived.getStringExtra(Intent.EXTRA_TEXT);
            childTv.setText(stringReceived);
        }


    }
}
