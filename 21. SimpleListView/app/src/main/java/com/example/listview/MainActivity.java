package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCourse;
    ArrayList<String> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourse = (ListView) findViewById(R.id.listViewCourse);
        courses = new ArrayList<>();
        courses.add("Android");
        courses.add("IOS");
        courses.add("Flutter");
        courses.add("Java");
        courses.add("JavaScript");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, courses);
        lvCourse.setAdapter(adapter);

        lvCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,courses.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        lvCourse.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Long Click : " + courses.get(position),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}