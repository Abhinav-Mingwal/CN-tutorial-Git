package com.example.abhinav_pc.moviedb.Network;

import android.support.annotation.CallSuper;

import com.example.abhinav_pc.moviedb.MovieData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AbHiNav-PC on 04-Oct-16.
 */
public interface ApiServices {
    @GET("movie?sort_by=popularity.desc&api_key=6ed2279f7b98c9369069fe4760ac0e1f")
    Call<FrontResponse> getMovies();
    @GET("movie/{id}")
    Call<MovieResponse> getMovieInfo(@Path("id") String id,@Query("api_key") String api_key);
    @GET("movie/{id}/videos")
    Call<YoutubeResponse> getTrailerInfo(@Path("id") String id,@Query("api_key") String api_key);
}
