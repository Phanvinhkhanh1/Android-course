package com.example.a46_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    Button btnProcess;
    TextView txtViewInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();
        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Work().execute();
            }
        });
    }

    private class Work extends AsyncTask<Void, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtViewInformation.setText("Starting..." + "\n");
        }

        @Override
        protected String doInBackground(Void... voids) {

            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress("Done " + i + "\n");
            }
            return "Done!";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtViewInformation.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtViewInformation.append(values[0]);
        }
    }

    public void Mapping() {
        btnProcess = (Button) findViewById(R.id.btnProcess);
        txtViewInformation = (TextView) findViewById(R.id.txtViewInfor);
    }
}