package com.example.a1796122.databaseapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void fetchDataFromDB(){
        MyDBHelper dbHelper = new MyDBHelper(this, "userdb", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[]columns ={"name", "address", "phone"};
        Cursor cursor = db. query("user", columns, null, null, null, null, null);
        cursor.moveToFirst();
        Log.i("ValueFromBD", cursor.getString(0));
    }
    public void saveInfo(){
        EditText name = (EditText)findViewById(R.id.name);
        EditText phone = (EditText)findViewById(R.id.phone);
        EditText address = (EditText) findViewById(R.id.address);
        saveValuesToDB(name.getText().toString(), address.getText().toString(), phone.getText().toString());
    }

}
