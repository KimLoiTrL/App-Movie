package com.midterm.movieapp.utils;

import com.midterm.movieapp.R;
import com.midterm.movieapp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies(){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Venom 2: Let There Be Carnage", R.drawable.thumbnail1, R.drawable.cover1));
        lstMovies.add(new Movie("Black Widow",R.drawable.thumbnail2, R.drawable.cover2));
        lstMovies.add(new Movie("Snake Eyes: G.I.Joe Origins",R.drawable.thumbnail3,R.drawable.cover3));
        lstMovies.add(new Movie("The King’s man - Kingsman",R.drawable.thumbnail4,R.drawable.cover4));
        lstMovies.add(new Movie("The Conjuring: The Devil Made Me Do It",R.drawable.thumbnail5,R.drawable.cover5));
        lstMovies.add(new Movie("The Shawshank redemption",R.drawable.thumbnail6,R.drawable.cover6));
        lstMovies.add(new Movie("The godfather",R.drawable.thumbnail7,R.drawable.cover7));
        lstMovies.add(new Movie("American Beauty",R.drawable.thumbnail8,R.drawable.cover8));
        lstMovies.add(new Movie("Zombieland",R.drawable.thumbnail9,R.drawable.cover9));
        //lstMovies.add(new Movie("World war Z",R.drawable.thumbnail10,R.drawable.cover0));
        return lstMovies;
    }

    public static List<Movie> getMonthMovies(){
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("The Ice Road ", R.drawable.month1, R.drawable.month_cv1));
        lstMovies.add(new Movie("Eternals",R.drawable.month2, R.drawable.month_cv2));
        lstMovies.add(new Movie("Dune",R.drawable.month3,R.drawable.month_cv3));
        lstMovies.add(new Movie("A Quiet Place 2",R.drawable.month4,R.drawable.month_cv4));
        lstMovies.add(new Movie("Suicide Forest Village",R.drawable.month5,R.drawable.month_cv5));
        return lstMovies;
    }


}
