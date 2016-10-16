package com.example.abhinav_pc.moviedb;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by AbHiNav-PC on 17-Sep-16.
 */
public class youtubeAsyncTask extends AsyncTask<String,Void,YoutubeKey>{

    youtubeAsyncTaskListner listener;

    public interface youtubeAsyncTaskListner {
        void onYoutubeKeyFetched(YoutubeKey Key);
    }

    public void setListener(youtubeAsyncTaskListner listener) {
        this.listener=listener;
    }

    @Override
    protected YoutubeKey doInBackground(String... params) {
        String urlString = params[0];
        StringBuffer output = new StringBuffer("");

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            Scanner scn = new Scanner(inputStream);

            while (scn.hasNext()) {
                output.append(scn.nextLine());

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return getYoutubeData(output.toString());
    }
    public YoutubeKey getYoutubeData(String output){
        YoutubeKey obj=new YoutubeKey();
        try {
            JSONObject object=new JSONObject(output);
            JSONArray result=object.getJSONArray("results");
            for(int i=0;i<result.length();i++){
                JSONObject resultKey=result.getJSONObject(i);
                obj.key= resultKey.getString("key");
                obj.name=resultKey.getString("name");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;

    }

    @Override
    protected void onPostExecute(YoutubeKey Key) {
        if(listener!=null){
            listener.onYoutubeKeyFetched(Key);
        }
    }
}
