package com.example.simplelistiview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView rlvCourses;
    ArrayList<String> courses;
    EditText edtCourseName;
    Button btnAdd, btnUpdate;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlvCourses = (ListView) findViewById(R.id.listViewCourses);
        edtCourseName = (EditText) findViewById(R.id.editTextTextCourseName);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);

        courses = new ArrayList<>();

        courses.add("IOS");
        courses.add("Android");
        courses.add("NodeJS");
        courses.add("Flutter");
        courses.add("SpringBoot");
        courses.add("PHP");
        courses.add("AI");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, courses);

        rlvCourses.setAdapter(adapter);

        rlvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtCourseName.setText(courses.get(position));
                index = position;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = edtCourseName.getText().toString();
                if (courses.contains(subject)) {
                    Toast.makeText(MainActivity.this, subject + " already exists in the course list", Toast.LENGTH_SHORT).show();
                } else {
                    courses.add(subject);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = edtCourseName.getText().toString();
                courses.set(index, subject);
                adapter.notifyDataSetChanged();
            }
        });

        rlvCourses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                courses.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}