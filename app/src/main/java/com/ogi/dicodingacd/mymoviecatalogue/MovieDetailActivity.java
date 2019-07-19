package com.ogi.dicodingacd.mymoviecatalogue;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogi.dicodingacd.mymoviecatalogue.model.Movie;

public class MovieDetailActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton fabShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        CollapsingToolbarLayout ctlTitle = findViewById(R.id.tv_title_movie);
        TextView tvRating = findViewById(R.id.tv_rating_movie);
        TextView tvOverview = findViewById(R.id.tv_overview_movie);
        TextView tvRelease = findViewById(R.id.tv_release_movie);
        TextView tvGenre = findViewById(R.id.tv_genre_movie);
        TextView tvDirector = findViewById(R.id.tv_director_movie);
        TextView tvScreenplay = findViewById(R.id.tv_screenplay_movie);
        TextView tvWriter = findViewById(R.id.tv_writer_movie);
        ImageView ivPoster = findViewById(R.id.iv_poster_movie);
        fabShare = findViewById(R.id.btn_share);
        fabShare.setOnClickListener(this);

        Movie movie = getIntent().getParcelableExtra(getResources().getString(R.string.extra_movie_detail));
        ivPoster.setImageResource(movie.getPoster());
        ctlTitle.setTitle(movie.getTitle());

        tvRating.setText(String.valueOf(movie.getRating() + getResources().getString(R.string.percent)));
        tvOverview.setText(movie.getOverview());
        tvRelease.setText(movie.getRelease());
        tvGenre.setText(movie.getGenres());
        tvDirector.setText(movie.getDirector());
        tvScreenplay.setText(movie.getScreenplay());
        tvWriter.setText(movie.getWriter());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_share){
            Intent myShare = new Intent(Intent.ACTION_SEND);
            myShare.setType(getResources().getString(R.string.text_plain));
            String shareBody = getResources().getString(R.string.extra_body);
            myShare.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.extra_subject));
            myShare.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(myShare, getResources().getString(R.string.share_via)));
        }
    }
}
