package com.example.firstapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrayName = new ArrayList<>();
        arrayName.add("FPT");
        arrayName.add("VNG");
        arrayName.add("Momo");
        Log.d("KhanhPhan","SIZE :" + arrayName.size());
        Log.d("KhanhPhan","At index 0 " + arrayName.get(0));
        arrayName.remove(0);
        Log.d("KhanhPhan",arrayName.get(0));
//        for(int i=0;i < arrayName.size();i ++){
//            Log.d("KhanhPhan",arrayName.get(i));
//        }

        for(String s : arrayName){
            Log.d("KhanhPhan",s);
        }
    }


}