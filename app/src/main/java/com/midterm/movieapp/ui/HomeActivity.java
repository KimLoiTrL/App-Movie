package com.midterm.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.midterm.movieapp.models.Movie;
import com.midterm.movieapp.adapters.MovieAdapter;
import com.midterm.movieapp.adapters.MovieItemClickListener;
import com.midterm.movieapp.R;
import com.midterm.movieapp.models.Slide;
import com.midterm.movieapp.adapters.SliderPagerAdapter;
import com.midterm.movieapp.utils.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV, moviesRvMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniMonthMovies();

    }

    private void iniMonthMovies() {
        MovieAdapter monthMovieAdapter = new MovieAdapter(this, DataSource.getMonthMovies(), this);
        moviesRvMonth.setAdapter(monthMovieAdapter);
        moviesRvMonth.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniPopularMovies() {
        //setup recyclerview
        //data
        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(), this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        //prepare a list of slide
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1,"Mortal Kombat \nCuộc chiến sinh tử"));
        lstSlides.add(new Slide(R.drawable.slide2,"DUNE"));
        lstSlides.add(new Slide(R.drawable.slide3,"Spider-Man \nNo Way Home"));
        lstSlides.add(new Slide(R.drawable.slide4,"Godzilla vs. Kong"));
        lstSlides.add(new Slide(R.drawable.slide5,"Black Widow"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);
        sliderpager.setAdapter(adapter);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(sliderpager, true);
    }

    private void iniViews() {
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);
        moviesRvMonth = findViewById(R.id.rv_movies_month);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        //here we send movie infomation to detail activity
        //also we ll create the transition animation between the 2 activity
        //Toast.makeText(this, "clicked:" + movie.getTitle(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MovieDetailActivity.class);
        //send movie infomation to DetailActivity
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        //lets create the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                                                    movieImageView, "sharedName");
        startActivity(intent, options.toBundle());

    }

    class SliderTimer extends TimerTask{
        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sliderpager.getCurrentItem() < lstSlides.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }

}