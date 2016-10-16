package com.example.abhinav_pc.moviedb;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.abhinav_pc.moviedb.Network.ApiServices;
import com.example.abhinav_pc.moviedb.Network.FrontResponse;
import com.example.abhinav_pc.moviedb.Network.MovieResponse;
import com.example.abhinav_pc.moviedb.Network.URLconstants;
import com.example.abhinav_pc.moviedb.Network.YoutubeResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieActivity extends AppCompatActivity {
    String poster_ID;
    String MovieName;
    double Rating;
    double popularity;
    ArrayList<prod> production = new ArrayList<>();
    int voteCount;
    int movieID;
    String ReleaseDate;
    String Overview;
    ArrayList<Genre> genre = new ArrayList<>();
    ArrayList<YoutubeKey> key = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie2);
        Intent intent = getIntent();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URLconstants.Movie_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServices service = retrofit.create(ApiServices.class);
        Call<MovieResponse> callMovie = service.getMovieInfo(intent.getStringExtra("MovieID").substring(5), "6ed2279f7b98c9369069fe4760ac0e1f");
        callMovie.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                poster_ID = response.body().getPoster_ID();
                Log.i("ABCD", "  " + poster_ID);
                MovieName = response.body().getMovieName();
                Log.i("ABCD", "  " + MovieName);
                Rating = response.body().getRating();
                Log.i("ABCD", "  " + Rating);
                popularity = response.body().getPopularity();
                ArrayList<prod> obj1 = response.body().getProduction();
                for (int i = 0; i < obj1.size(); i++) {
                    production.add(obj1.get(i));
                }
                voteCount = response.body().getVoteCount();
                movieID = response.body().getMovieID();
                ReleaseDate = response.body().getReleaseDate();
                Overview = response.body().getOverview();
                ArrayList<Genre> obj2 = response.body().getGenre();
                for (int i = 0; i < obj2.size(); i++) {
                    genre.add(obj2.get(i));
                }
                movieData2 movieOBJ = new movieData2(poster_ID, MovieName, Rating, popularity, production, voteCount, movieID, ReleaseDate, Overview, genre);
                TextFinal(movieOBJ);

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        Call<YoutubeResponse> callyoutube = service.getTrailerInfo(intent.getStringExtra("MovieID").substring(5), "6ed2279f7b98c9369069fe4760ac0e1f");
        callyoutube.enqueue(new Callback<YoutubeResponse>() {
            @Override
            public void onResponse(Call<YoutubeResponse> call, Response<YoutubeResponse> response) {
                Log.i("ABCD", " BEFORE");
                MovieActivity.this.key = response.body().getYoutubeInfo();
                Log.i("ABCD", " AFTER");
                if (MovieActivity.this.key == null) {
                    return;
                } else {
                    HorizontalScrollView scroll=(HorizontalScrollView) findViewById(R.id.ScrollTrailer);
                    LinearLayout trailerLinear = new LinearLayout(getApplicationContext());
                    LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    trailerLinear.setLayoutParams(params);
                    trailerLinear.setOrientation(LinearLayout.HORIZONTAL);
                    for (int i = 0; i < MovieActivity.this.key.size(); i++) {
                        ImageButton trailerIMG = new ImageButton(getApplicationContext());
                        Picasso.with(MovieActivity.this).load("http://img.youtube.com/vi/" + key.get(i).key + "/hqdefault.jpg").into(trailerIMG);
                        trailerLinear.addView(trailerIMG);
                        final int clickedIndex = i;
                        trailerIMG.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intentF = getIntent();
                                Intent intent1 = new Intent();
                                intent1.setAction(intent1.ACTION_VIEW);
                                Log.i("ABCD", "  " + intentF.getStringExtra("MovieID"));
                                intent1.setData(Uri.parse("https://www.youtube.com/watch?v=" + key.get(clickedIndex).key));
                                startActivity(intent1);
                            }
                        });
                    }
                    scroll.addView(trailerLinear);
                }
            }

            @Override
            public void onFailure(Call<YoutubeResponse> call, Throwable t) {

            }
        });
    }


    public void TextFinal(movieData2 movie) {
        TextView MovieName = (TextView) findViewById(R.id.title2);
        ImageView poster = (ImageView) findViewById(R.id.poster2);
        TextView movieId = (TextView) findViewById(R.id.movieId2);
        TextView popularity = (TextView) findViewById(R.id.popularity_id2);
        TextView rating = (TextView) findViewById(R.id.Rating_id2);
        TextView genre = (TextView) findViewById(R.id.Genre2);
        TextView overview = (TextView) findViewById(R.id.OverView2);
        TextView releaseDate = (TextView) findViewById(R.id.ReleaseDate2);
        TextView voteCount = (TextView) findViewById(R.id.voteCount2);
        TextView production = (TextView) findViewById(R.id.production);


        MovieName.setText(this.MovieName);
        Picasso.with(this).load("http://image.tmdb.org/t/p/w342" + movie.poster_ID).resize(750, 350).centerCrop().into(poster);
        movieId.setText("ID: " + this.movieID);
        rating.setText("Rating: " + this.Rating);
        StringBuffer genreSTR = new StringBuffer("");
        for (Genre obj : this.genre) {
            genreSTR.append(obj.name + ", ");
        }
        genre.setText("Genre: " + genreSTR.toString());
        voteCount.setText("Vote Count: " + this.voteCount);
        releaseDate.setText("Release Date: " + this.ReleaseDate);
        popularity.setText("Popularity :" + this.popularity);
        overview.setText(this.Overview);
        StringBuffer prodSTR = new StringBuffer("");
        for (prod obj : this.production) {
            prodSTR.append(obj.name + ", ");
        }
        production.setText("Production :" + prodSTR.toString());
    }


}
