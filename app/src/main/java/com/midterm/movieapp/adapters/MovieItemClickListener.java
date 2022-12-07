package com.midterm.movieapp.adapters;

import android.widget.ImageView;

import com.midterm.movieapp.models.Movie;

public interface MovieItemClickListener {
    void onMovieClick(Movie movie, ImageView movieImageView); //ImgView to make the shared animation between the 2 activity

}
