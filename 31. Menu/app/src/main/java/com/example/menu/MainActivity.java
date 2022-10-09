package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuShare:
                Toast.makeText(MainActivity.this, "You choose Menu Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSetting:
                Toast.makeText(MainActivity.this, "You choose Menu Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Toast.makeText(MainActivity.this, "You choose Menu Exit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSearch:
                Toast.makeText(MainActivity.this, "You choose Menu Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuContactEmail:
                Toast.makeText(MainActivity.this, "You choose Contact Email Menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuContactPhone:
                Toast.makeText(MainActivity.this, "You choose Contact Phone Menu", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}