package com.example.a1796122.asynscalls;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getData(View view){
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show();
        URL apiURL;
        try{
            apiURL = new URL("https://jsonplaceholder.typicode.com/todos/1");
        }
        catch(MalformedURLException e){
            e.printStackTrace();
        }
    }

    public class FetchDataFromAPi extends AsyncTask<URL, Void, String>{

        @Override
        protected String doInBackground(URL... urls) {
            return null;
        }
    }

}
