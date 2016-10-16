package com.example.abhinav_pc.moviedb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AbHiNav-PC on 11-Sep-16.
 */
public class MovieAdapter extends ArrayAdapter<MovieData> {

    Context mContext;
    ArrayList<MovieData> mMovie;

    public MovieAdapter(Context context, ArrayList<MovieData> Movie) {
        super(context, 0, Movie);
        mContext = context;
        mMovie = Movie;
    }

    public static class ViewHolder {
        ImageView poster;
        TextView movieTitle;
        TextView movieRating;
        TextView VoteCount;
        TextView popularity;
        TextView releaseDate;
        TextView movieId;


        ViewHolder(ImageView poster, TextView movieTitle, TextView movieRating,TextView VoteCount,TextView popularity,TextView releaseDate,TextView movieId) {
            this.poster = poster;
            this.movieTitle = movieTitle;
            this.movieRating = movieRating;
            this.VoteCount=VoteCount;
            this.popularity=popularity;
            this.releaseDate=releaseDate;
            this.movieId=movieId;
        }


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item_layout, null);
            ImageView poster = (ImageView) convertView.findViewById(R.id.Poster_ID);
            TextView Title = (TextView) convertView.findViewById(R.id.Title_ID);
            TextView Rating = (TextView) convertView.findViewById(R.id.Rating_id);
            TextView popularity=(TextView)convertView.findViewById(R.id.popularity_id);
            TextView ReleaseDate=(TextView)convertView.findViewById(R.id.ReleaseDate);
            TextView votecount=(TextView)convertView.findViewById(R.id.voteCount);
            TextView movieId=(TextView)convertView.findViewById(R.id.movieId);
            ViewHolder vh = new ViewHolder(poster, Title, Rating,votecount,popularity,ReleaseDate,movieId);
            convertView.setTag(vh);
        }

        ViewHolder vh = (ViewHolder) convertView.getTag();
        MovieData currentMovie = mMovie.get(position);
//        vh.poster.setBackgroundResource();
//        Do with picasso
        Picasso.with(mContext).load("http://image.tmdb.org/t/p/w342/"+currentMovie.poster_ID).into(vh.poster);
        vh.movieTitle.setText( currentMovie.MovieName);
        vh.releaseDate.setText("Release Date: " + currentMovie.releaseDate);
        vh.VoteCount.setText("vote count: "+currentMovie.voteCount+"");
        vh.popularity.setText("popularity: "+currentMovie.popularity+"");

        vh.movieRating.setText("Rating: "+currentMovie.Rating + "");
        vh.movieId.setText("ID : "+currentMovie.movieID+"");

        return convertView;

    }
}

