package com.ogi.dicodingacd.mymoviecatalogue.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogi.dicodingacd.mymoviecatalogue.R;
import com.ogi.dicodingacd.mymoviecatalogue.model.TvShow;

public class TvShowViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle, tvOverview, tvRelease, tvRating;
    private ImageView ivPoster;

    public TvShowViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title_tv_show_id);
        tvOverview = itemView.findViewById(R.id.tv_overview_tv_show_id);
        tvRelease = itemView.findViewById(R.id.tv_release_tv_show_id);
        ivPoster = itemView.findViewById(R.id.iv_poster_tv_show_id);
        tvRating = itemView.findViewById(R.id.tv_rating_tv_show_id);
    }

    public void setTvShowsData(TvShow tvShow){
        ivPoster.setImageResource(tvShow.getPoster());
        tvTitle.setText(tvShow.getTitle());
        tvRelease.setText(tvShow.getRelease());
        tvOverview.setText(tvShow.getOverview());
        tvRating.setText(String.valueOf(tvShow.getRating() + "%"));
    }
}
