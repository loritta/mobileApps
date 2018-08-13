package com.example.a1796122.jacapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public void getMapLocation(MenuItem item) {
        Uri gmmIntentUri = Uri.parse("geo:45.4060,-73.9419?z=11");

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
       // mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void getJACWebPage(MenuItem item) {
        Uri uri = Uri.parse("http://johnabbott.qc.ca");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void getJACInfoPage(MenuItem item) {
        Intent intentForSecond = new Intent(MainActivity.this, Info.class);
        //intentForSecond.putExtra(Intent.EXTRA_TEXT, "Sent from Main Activity");
        startActivity(intentForSecond);
    }
}
