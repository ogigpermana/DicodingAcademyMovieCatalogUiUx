package com.ogi.dicodingacd.mymoviecatalogue.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogi.dicodingacd.mymoviecatalogue.R;
import com.ogi.dicodingacd.mymoviecatalogue.TvShowDetailActivity;
import com.ogi.dicodingacd.mymoviecatalogue.model.TvShow;
import com.ogi.dicodingacd.mymoviecatalogue.viewholder.TvShowViewHolder;

import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowViewHolder> {
    private Context mContext;
    private List<TvShow> tvShows;

    public TvShowAdapter(Context mContext, List<TvShow> tvShows) {
        this.mContext = mContext;
        this.tvShows = tvShows;
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_tvshow, viewGroup, false);
        final TvShowViewHolder tvShowViewHolder = new TvShowViewHolder(layout);
        tvShowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = tvShowViewHolder.getAdapterPosition();
                Intent intent = new Intent(mContext, TvShowDetailActivity.class);
                intent.putExtra("TVSHOW_DETAIL", tvShows.get(position));
                mContext.startActivity(intent);
            }
        });
        return tvShowViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder tvShowViewHolder, int i) {
        tvShowViewHolder.setTvShowsData(tvShows.get(i));
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }
}
