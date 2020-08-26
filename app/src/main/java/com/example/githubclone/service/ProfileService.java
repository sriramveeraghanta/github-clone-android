package com.example.githubclone.service;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class ProfileService extends AsyncTask<String, Void, JSONObject> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        Log.i("method", strings[0]);
        Log.i("URL", strings[1]);

        HttpsURLConnection urlConnection = null;
        BufferedReader bufferedReader = null;
        String responseString = null;

        try {
            URL url = new URL(strings[1]);
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod(strings[0]);
            urlConnection.connect();
            int lengthOfFile = urlConnection.getContentLength();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            if (inputStream == null) {
                return null;
            }

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }

            responseString = buffer.toString();
            JSONObject jsonObject = new JSONObject(responseString);

            return jsonObject;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(JSONObject s) {
        super.onPostExecute(s);
    }
}


