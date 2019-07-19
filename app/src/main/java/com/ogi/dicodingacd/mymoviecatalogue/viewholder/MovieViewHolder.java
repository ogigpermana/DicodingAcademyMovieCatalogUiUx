package com.ogi.dicodingacd.mymoviecatalogue.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogi.dicodingacd.mymoviecatalogue.R;
import com.ogi.dicodingacd.mymoviecatalogue.model.Movie;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private TextView tvTitle, tvRelease, tvOverview, tvRating;
    private ImageView ivPoster;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title_movie);
        tvRelease = itemView.findViewById(R.id.tv_release_movie);
        tvOverview = itemView.findViewById(R.id.tv_overview_movie);
        ivPoster = itemView.findViewById(R.id.iv_poster_movie);
        tvRating = itemView.findViewById(R.id.tv_rating_movie);
    }

    public void setMovieData(Movie movie){
        ivPoster.setImageResource(movie.getPoster());
        tvTitle.setText(movie.getTitle());
        tvRelease.setText(movie.getRelease());
        tvOverview.setText(movie.getOverview());
        tvRating.setText(String.valueOf( movie.getRating()+ "%"));
    }
}
