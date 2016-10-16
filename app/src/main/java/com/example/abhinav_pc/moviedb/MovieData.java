package com.example.abhinav_pc.moviedb;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AbHiNav-PC on 11-Sep-16.
 */
public class MovieData {
    @SerializedName("poster_path")
    String poster_ID;
    @SerializedName("original_title")
    String MovieName;
    @SerializedName("vote_average")
    double Rating;
    @SerializedName("popularity")
    double popularity;
    @SerializedName("vote_count")
    double voteCount;
    @SerializedName("id")
    int movieID;
    @SerializedName("release_date")
    String releaseDate;


}
