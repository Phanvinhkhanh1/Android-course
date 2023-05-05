package com.example.angrybirdapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Collections;

public class ImageActivity extends Activity {

    TableLayout tableLayoutImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        tableLayoutImage = (TableLayout) findViewById(R.id.tableLayoutImage);

        int numOfCol = 3;
        int numOfRow = 6;

        Collections.shuffle(MainActivity.arrayName);

        for (int i = 1; i <= numOfRow; i++) {
            TableRow tableRow = new TableRow(this);
            for (int j = 1; j <= numOfCol; j++) {
                ImageView imageView = new ImageView(this);

                // Converts 100 dip into its equivalent px
                int px = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        150f,
                        getResources().getDisplayMetrics()
                );
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                imageView.setLayoutParams(layoutParams);

                int position = numOfCol * (i - 1) + j - 1;
                int imageId = getResources().getIdentifier(MainActivity.arrayName.get(position), "drawable", getPackageName());
                imageView.setImageResource(imageId);

                tableRow.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("imageName", MainActivity.arrayName.get(position));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
            tableLayoutImage.addView(tableRow);
        }
    }
}