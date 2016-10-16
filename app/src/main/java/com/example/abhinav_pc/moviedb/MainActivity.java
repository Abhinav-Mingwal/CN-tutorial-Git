package com.example.abhinav_pc.moviedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.abhinav_pc.moviedb.Network.ApiServices;
import com.example.abhinav_pc.moviedb.Network.FrontResponse;
import com.example.abhinav_pc.moviedb.Network.URLconstants;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    MovieAdapter movieAdapter;
    ArrayList<MovieData> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.mainListView);
        movieList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(URLconstants.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServices service = retrofit.create(ApiServices.class);
        Call<FrontResponse> call = service.getMovies();
        call.enqueue(new Callback<FrontResponse>() {
            @Override
            public void onResponse(Call<FrontResponse> call, Response<FrontResponse> response) {
                ArrayList<MovieData> movieList = response.body().getMovies();
                if (movieList == null)
                    return;
                else {
                    for (MovieData obj : movieList) {
                        MainActivity.this.movieList.add(obj);
                    }
                    movieAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<FrontResponse> call, Throwable t) {

            }
        });


        movieAdapter = new MovieAdapter(this, movieList);
        listView.setAdapter(movieAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, MovieActivity.class);
                String temp = ((TextView) view.findViewById(R.id.movieId)).getText().toString();
                i.putExtra("MovieID", temp);
                startActivity(i);
            }
        });

    }
}