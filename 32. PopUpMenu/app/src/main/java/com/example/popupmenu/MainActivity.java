package com.example.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPopup = (Button) findViewById(R.id.buttonPopupMenu);
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnPopup);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuAdd:
                        btnPopup.setText("Button Add");
                        break;
                    case R.id.menuEdit:
                        btnPopup.setText("Button Edit");
                        break;
                    case R.id.menuRemove:
                        btnPopup.setText("Button Remove");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}