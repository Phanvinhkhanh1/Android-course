package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnContextMenu;
    ConstraintLayout constraintLayoutScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContextMenu = (Button) findViewById(R.id.buttonContextMenu);
        constraintLayoutScreen = (ConstraintLayout) findViewById(R.id.constraintScreen);

        registerForContextMenu(btnContextMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Choose Action");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contextMenuAdd:
//                Toast.makeText(MainActivity.this, "You choose Context Menu Add", Toast.LENGTH_SHORT).show();
                constraintLayoutScreen.setBackgroundColor(Color.RED);
                break;
            case R.id.contextMenuEdit:
//                Toast.makeText(MainActivity.this, "You choose Context Menu Edit", Toast.LENGTH_SHORT).show();
                constraintLayoutScreen.setBackgroundColor(Color.GREEN);
                break;
            case R.id.contextMenuRemove:
//                Toast.makeText(MainActivity.this, "You choose Context Menu Remove", Toast.LENGTH_SHORT).show();
                constraintLayoutScreen.setBackgroundColor(Color.YELLOW);
                break;

        }
        return super.onContextItemSelected(item);
    }
}