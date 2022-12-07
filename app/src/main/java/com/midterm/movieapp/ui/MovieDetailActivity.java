package com.midterm.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.midterm.movieapp.R;
import com.midterm.movieapp.adapters.CastAdapter;
import com.midterm.movieapp.models.Cast;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //ini views
        iniViews();

        //setup list cast
        setupRvCast();

    }

    void iniViews(){

        RvCast = findViewById(R.id.rv_cast);
        play_fab = findViewById(R.id.play_fab);
        //get the data
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description = findViewById(R.id.detail_movie_desc);

        //setup animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
    }

    void setupRvCast(){

        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("Michelle Williams",R.drawable.a_michelle_williams));
        mdata.add(new Cast("Naomie Harris",R.drawable.a_naomie_harris));
        mdata.add(new Cast("Reid Scott",R.drawable.a_reid_scott));
        mdata.add(new Cast("Stephen Graham",R.drawable.a_stephen_graham));
        mdata.add(new Cast("Tom Hardy",R.drawable.a_tom_hardy));
        mdata.add(new Cast("Woody Harrelson",R.drawable.a_woody_harrelson));

        castAdapter = new CastAdapter(this, mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }

}