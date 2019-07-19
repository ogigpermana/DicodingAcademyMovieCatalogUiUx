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

import com.ogi.dicodingacd.mymoviecatalogue.model.TvShow;

public class TvShowDetailActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton fabShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        CollapsingToolbarLayout ctlTitle = findViewById(R.id.tv_title_tv_show);
        TextView tvRating = findViewById(R.id.tv_rating_tv_show);
        TextView tvOverview = findViewById(R.id.tv_overview_tv_show);
        TextView tvRelease = findViewById(R.id.tv_release_tv_show);
        TextView tvGenre = findViewById(R.id.tv_genre_tv_show);
        TextView tvCreator = findViewById(R.id.tv_creator_tv_show);
        ImageView ivPoster = findViewById(R.id.iv_poster_tv_show);
        fabShare = findViewById(R.id.btn_share);
        fabShare.setOnClickListener(this);

        TvShow tvShow = getIntent().getParcelableExtra(getResources().getString(R.string.extra_tvshow_detail));
        ivPoster.setImageResource(tvShow.getPoster());
        ctlTitle.setTitle(tvShow.getTitle());

        tvRating.setText(String.valueOf(tvShow.getRating() + getResources().getString(R.string.percent)));
        tvOverview.setText(tvShow.getOverview());
        tvRelease.setText(tvShow.getRelease());
        tvGenre.setText(tvShow.getGenres());
        tvCreator.setText(tvShow.getCreator());
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
