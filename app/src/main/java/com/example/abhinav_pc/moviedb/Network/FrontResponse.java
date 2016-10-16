package com.example.abhinav_pc.moviedb.Network;

import com.example.abhinav_pc.moviedb.MovieData;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by AbHiNav-PC on 04-Oct-16.
 */
public class FrontResponse  {
    public ArrayList<MovieData> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<MovieData> movies) {
        this.movies = movies;
    }

    @SerializedName("results")
    ArrayList<MovieData> movies;
}
