package com.example.abhinav_pc.moviedb;


import java.util.ArrayList;

/**
 * Created by AbHiNav-PC on 15-Sep-16.
 */
public class movieData2 {
    String poster_ID;
    String MovieName;
    double Rating;
    double popularity;
    ArrayList<prod> production;
    int voteCount;
    int movieID;
    String ReleaseDate;
    String Overview;
    ArrayList<Genre> genre;
    public movieData2(String poster_ID,String MovieName,double Rating,double popularity,ArrayList<prod> production,int voteCount,int movieID,String ReleaseDate,String Overview,ArrayList<Genre> genre){
        this.poster_ID=poster_ID;
        this.MovieName=MovieName;
        this.Rating=Rating;
        this.popularity=popularity;
        this.production=new ArrayList<>();
        for(int i=0;i<production.size();i++){
            this.production.add(production.get(i));
        }

        this.voteCount=voteCount;
        this.movieID=movieID;
        this.ReleaseDate=ReleaseDate;
        this.Overview=Overview;
        this.genre=new ArrayList<>();
        for(int i=0;i<genre.size();i++){
            this.genre.add(genre.get(i));
        }
    }

}










