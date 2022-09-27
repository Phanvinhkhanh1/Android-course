package com.example.advancedgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

GridView gridViewImage;
ArrayList<Image> arrayList;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Mapping();

    ImageAdapter adapter = new ImageAdapter(this, R.layout.image_row, arrayList);
    gridViewImage.setAdapter(adapter);

    gridViewImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, arrayList.get(position).getNameImg(), Toast.LENGTH_SHORT).show();
        }
    });
}

private void Mapping() {
    gridViewImage = (GridView) findViewById(R.id.gridViewImage);
    arrayList = new ArrayList<>();

    arrayList.add(new Image(R.drawable.android_1, "android_1"));
    arrayList.add(new Image(R.drawable.android_2, "android_2"));
    arrayList.add(new Image(R.drawable.android_3, "android_3"));
    arrayList.add(new Image(R.drawable.android_4, "android_4"));
    arrayList.add(new Image(R.drawable.android_5, "android_5"));
    arrayList.add(new Image(R.drawable.android_6, "android_6"));
    arrayList.add(new Image(R.drawable.android_7, "android_7"));
    arrayList.add(new Image(R.drawable.android_9, "android_9"));
    arrayList.add(new Image(R.drawable.android_10, "android_10"));
    arrayList.add(new Image(R.drawable.android_11, "android_11"));
}

}