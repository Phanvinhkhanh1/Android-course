package com.example.dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvCourses;
    ArrayList<String> courses = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = (ListView) findViewById(R.id.listViewCourse);
        addCourses();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, courses);
        lvCourses.setAdapter(adapter);

        lvCourses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                deleteConfirm(position);
                return false;
            }
        });
    }

    private void deleteConfirm(int position) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Notification");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("Do you want to delete " + courses.get(position) + " course?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                courses.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    private void addCourses() {
        courses.add("Android");
        courses.add("PHP");
        courses.add("IOS");
        courses.add("Flutter");
        courses.add("Java");
        courses.add("Spring boot");
        courses.add("NodeJS");
        courses.add("JavaScript");
    }
}