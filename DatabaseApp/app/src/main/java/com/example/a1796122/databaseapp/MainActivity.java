package com.example.a1796122.databaseapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    public void saveValuesToDB(String name, String address, String phone){
        MyDBHelper dbHelper = new MyDBHelper(this, "userdb", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);
        values.put("phone", phone);
//        values.put("name", "john");
//        values.put("address", "some");
//        values.put("phone", "5144561234");

        long rowId = db.insert("user", null, values);
        Log.i("MYTAG", "The database had new row at line "+rowId + " added.");

    }

    public ArrayList<User> fetchDataFromDB(){
        MyDBHelper dbHelper = new MyDBHelper(this, "userdb", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[]columns ={"name", "address", "phone"};
        Cursor cursor = db. query("user", columns, null, null, null, null, null);
        ArrayList<User> users = new ArrayList<User>();
        if (cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex(columns[0]));
                String address = cursor.getString(cursor.getColumnIndex(columns[1]));
                String phone = cursor.getString(cursor.getColumnIndex(columns[2]));
                User user = new User(name, address, phone);
                users.add(user);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return users;
    }
    public void saveInfo(View view){
        EditText name = (EditText)findViewById(R.id.name);
        EditText phone = (EditText)findViewById(R.id.phone);
        EditText address = (EditText) findViewById(R.id.address);
        saveValuesToDB(name.getText().toString(), address.getText().toString(), phone.getText().toString());
    }

    public void showUserData(View view) {

        ArrayList<User> users = fetchDataFromDB();
        if (users.equals("")) {
            Log.e("Error", "No data found");
        }
        else{
            Intent intent = new Intent(this, ShowAllActivity.class);
            // pass the email as it might be needed
            intent.putExtra("usersInfo", users);
            startActivity(intent);
        }

    }

}
