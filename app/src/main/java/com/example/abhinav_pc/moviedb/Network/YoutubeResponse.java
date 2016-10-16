package com.example.abhinav_pc.moviedb.Network;

import android.util.Log;

import com.example.abhinav_pc.moviedb.YoutubeKey;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by AbHiNav-PC on 10-Oct-16.
 */
public class YoutubeResponse {

    public ArrayList<YoutubeKey> getYoutubeInfo() {
        Log.i("ABCD"," "+YoutubeInfo.size());
        return YoutubeInfo;
    }

    public void setYoutubeInfo(ArrayList<YoutubeKey> youtubeInfo) {
        YoutubeInfo = youtubeInfo;
    }

    @SerializedName("results")
    ArrayList<YoutubeKey> YoutubeInfo;
}
