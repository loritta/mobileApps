package com.example.ipd12.testsclass2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView myTextView;
static int counter=0;
    String[] studentID = new String[20];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "My toast", Toast.LENGTH_LONG).show();
        //typecast is not absolutely necessary
        myTextView=(TextView)findViewById(R.id.TestsClass2TextView);
        myTextView.append("\n My appended Text");

        myTextView.setText(Integer.toString(counter));
        for (int i=0;i<20;i++){
            studentID[i]="stud"+i;
        }
        int rnd;

        rnd = new Random().nextInt(studentID.length);
        myTextView.append("\nThe random student:\n" + studentID[rnd]);
        myTextView.append("\nStudent List:");
        for (int i=0;i<studentID.length;i++){
            String student = studentID[i];
            myTextView.append("\n"+ student);
        }

        myTextView.append("\n"+getText(+R.string.some_text)+"\n");
        Resources res=getResources();
        String[]array_trial = res.getStringArray(R.array.string_array_example);

        for (int i=0; i<array_trial.length;i++){
            myTextView.append(array_trial[i].toString()+"\n");
        }


    }

    public void incrementCounter(View view) {
        counter++;
        myTextView.setText(Integer.toString(counter));
        List<Student> students= new ArrayList<Student>();
        for (int i=0; i<20; i++){
            Student s = new Student("id"+i, "name"+i);
            students.add(s);
        }
        int rnd;

        rnd = new Random().nextInt(students.size());
        myTextView.append("\nThe random student's id:\n" + students.get(rnd).getId());
        myTextView.append("\nThe random student's name:\n" + students.get(rnd).getName());



        Log.i("ressource_value", Integer.toString(R.string.app_name));
    }
}
