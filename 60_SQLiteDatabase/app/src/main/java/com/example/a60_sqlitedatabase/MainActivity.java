package com.example.a60_sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create database reminder
        Database database = new Database(MainActivity.this, "reminder.sqlite", null, 1);

        //create table Work
        database.QueryData("CREATE TABLE IF NOT EXISTS Work(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(200))");

        //insert data to table Work
//        database.QueryData("INSERT INTO Work VALUES (null, 'Website')");
//        database.QueryData("INSERT INTO Work VALUES (null,'Android')");

        //get data
        Cursor data = database.getData("SELECT * FROM Work");
        while (data.moveToNext()) {
            String name = data.getString(1);
            Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
        }
    }
}