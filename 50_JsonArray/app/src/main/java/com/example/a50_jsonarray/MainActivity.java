package com.example.a50_jsonarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    Button btnLoadData;
    TextView txtViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        btnLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new readJsonArrayContent().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo2.json");
            }
        });
    }

    private class readJsonArrayContent extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                URLConnection urlConnection = url.openConnection();
                InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }

                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("danhsach");

                String output = "";
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String contentOfJsonObject = jsonObject1.getString("khoahoc");
                    output = output + (contentOfJsonObject + "\n");
                }

                txtViewContent.setText(output);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Mapping() {
        btnLoadData = (Button) findViewById(R.id.btnLoadData);
        txtViewContent = (TextView) findViewById(R.id.txtViewContent);
    }
}