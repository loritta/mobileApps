package com.example.a1796122.databaseapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class ShowAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TableLayout table = (TableLayout)findViewById(R.id.content_for_showAll);

        LayoutInflater inflater = getLayoutInflater();
        Serializable usersToPrint = getIntent().getSerializableExtra("usersInfo");
        for(int i = 0; i < usersToPrint.; i++) {
            TableRow row = (TableRow)inflater.inflate(R.layout.table_row,
                    table, false);

            TextView text = (TextView)row.findViewById(R.id.text);
            text.setText("row: " + i);
            // other customizations to the row

            table.addView(row);
        }
    }

}
