package com.example.advancedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewFruit;
    ArrayList<Fruit> arrayFruit;
    FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_row, arrayFruit);
        listViewFruit.setAdapter(fruitAdapter);
    }

    private void Mapping() {
        listViewFruit = (ListView) findViewById(R.id.listViewFruit);
        arrayFruit = new ArrayList<>();

        arrayFruit.add(new Fruit("Fruit 1", "First fruit", R.drawable.fruit_1));
        arrayFruit.add(new Fruit("Fruit 2", "Second fruit", R.drawable.fruit_2));
        arrayFruit.add(new Fruit("Fruit 3", "Third fruit", R.drawable.fruit_3));
        arrayFruit.add(new Fruit("Fruit 4", "Fourth fruit", R.drawable.fruit_4));
        arrayFruit.add(new Fruit("Fruit 5", "Fifth fruit", R.drawable.fruit_5));
        arrayFruit.add(new Fruit("Fruit 6", "Sixth fruit", R.drawable.fruit_6));
        arrayFruit.add(new Fruit("Fruit 1", "First fruit", R.drawable.fruit_1));
        arrayFruit.add(new Fruit("Fruit 2", "Second fruit", R.drawable.fruit_2));
        arrayFruit.add(new Fruit("Fruit 3", "Third fruit", R.drawable.fruit_3));
        arrayFruit.add(new Fruit("Fruit 4", "Fourth fruit", R.drawable.fruit_4));
        arrayFruit.add(new Fruit("Fruit 5", "Fifth fruit", R.drawable.fruit_5));
        arrayFruit.add(new Fruit("Fruit 6", "Sixth fruit", R.drawable.fruit_6));
        arrayFruit.add(new Fruit("Fruit 1", "First fruit", R.drawable.fruit_1));
        arrayFruit.add(new Fruit("Fruit 2", "Second fruit", R.drawable.fruit_2));
        arrayFruit.add(new Fruit("Fruit 3", "Third fruit", R.drawable.fruit_3));
        arrayFruit.add(new Fruit("Fruit 4", "Fourth fruit", R.drawable.fruit_4));
        arrayFruit.add(new Fruit("Fruit 5", "Fifth fruit", R.drawable.fruit_5));
        arrayFruit.add(new Fruit("Fruit 6", "Sixth fruit", R.drawable.fruit_6));
        arrayFruit.add(new Fruit("Fruit 1", "First fruit", R.drawable.fruit_1));
        arrayFruit.add(new Fruit("Fruit 2", "Second fruit", R.drawable.fruit_2));
        arrayFruit.add(new Fruit("Fruit 3", "Third fruit", R.drawable.fruit_3));
        arrayFruit.add(new Fruit("Fruit 4", "Fourth fruit", R.drawable.fruit_4));
        arrayFruit.add(new Fruit("Fruit 5", "Fifth fruit", R.drawable.fruit_5));
        arrayFruit.add(new Fruit("Fruit 6", "Sixth fruit", R.drawable.fruit_6));
    }
}