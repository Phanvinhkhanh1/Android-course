package com.example.a51_jsonlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewVnFlag, imgViewUsFlag;
    TextView txtViewContent;
    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        imgViewUsFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                country = "en";
                new readJsonContentFromInternet().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");
            }
        });

        imgViewVnFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                country = "vn";
                new readJsonContentFromInternet().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");
            }
        });

    }

    private class readJsonContentFromInternet extends AsyncTask<String, Void, String> {
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
                txtViewContent.setText(readContent(s, country));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String readContent(String content, String country) throws JSONException {
        String output = "";
        JSONObject jsonObject = new JSONObject(content);
        JSONObject jsonLanguage = jsonObject.getJSONObject("language");

        JSONObject jsonDetail = jsonLanguage.getJSONObject(country);
        String name = jsonDetail.getString("name");
        String address = jsonDetail.getString("address");
        String course1 = jsonDetail.getString("course1");
        String course2 = jsonDetail.getString("course2");
        String course3 = jsonDetail.getString("course3");

        output = output + name + "\n" + address + "\n" + course1 + "\n" + course2 + "\n" + course3 + "\n";
        return output;
    }

    public void Mapping() {
        imgViewVnFlag = (ImageView) findViewById(R.id.imgViewVietnamFlag);
        imgViewUsFlag = (ImageView) findViewById(R.id.imgViewUsFlag);
        txtViewContent = (TextView) findViewById(R.id.txtViewContent);
    }
}