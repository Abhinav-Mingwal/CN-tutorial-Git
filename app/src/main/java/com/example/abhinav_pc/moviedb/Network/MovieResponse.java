package com.example.abhinav_pc.moviedb.Network;

import android.util.Log;

import com.example.abhinav_pc.moviedb.Genre;
import com.example.abhinav_pc.moviedb.MovieData;
import com.example.abhinav_pc.moviedb.movieData2;
import com.example.abhinav_pc.moviedb.prod;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by AbHiNav-PC on 04-Oct-16.
 */
public class MovieResponse {

//    public movieData2 getMovieInfo() {
//        return MovieInfo;
//    }
//
//    public void setMovieInfo(movieData2 movieInfo) {
//        MovieInfo = movieInfo;
//    }

    @SerializedName("backdrop_path")
    String poster_ID;

    public String getPoster_ID() {
        Log.i("ABCD", "  BEFORE" );
        return poster_ID;
    }

    public void setPoster_ID(String poster_ID) {
        this.poster_ID = poster_ID;
    }

    @SerializedName("original_title")
    String MovieName;
    @SerializedName("vote_average")
    double Rating;
    @SerializedName("popularity")
    double popularity;
    @SerializedName("production_companies")
    ArrayList<prod> production;
    @SerializedName("vote_count")
    int voteCount;
    @SerializedName("id")
    int movieID;
    @SerializedName("release_date")
    String ReleaseDate;

    public ArrayList<Genre> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Genre> genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }


    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public ArrayList<prod> getProduction() {

        Log.i("ABCD"," production Before "+production.size());
        return production;
    }

    public void setProduction(ArrayList<prod> production) {
        this.production = production;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    @SerializedName("overview")
    String Overview;
    @SerializedName("genres")
    ArrayList<Genre> genre;
//    public movieData2 getMovieInfo(){
//        movieData2 obj=new movieData2(getPoster_ID(),getMovieName(),getRating(),getPopularity(),getProduction(),getVoteCount(),getVoteAVG(),getMovieID(),getReleaseDate(),getOverview(),getGenre());
//        return obj;
//    }

}
