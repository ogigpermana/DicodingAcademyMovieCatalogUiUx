package com.ogi.dicodingacd.mymoviecatalogue.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogi.dicodingacd.mymoviecatalogue.MovieDetailActivity;
import com.ogi.dicodingacd.mymoviecatalogue.R;
import com.ogi.dicodingacd.mymoviecatalogue.model.Movie;
import com.ogi.dicodingacd.mymoviecatalogue.viewholder.MovieViewHolder;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> movies;
    private Context mContext;

    public MovieAdapter(Context mContext, List<Movie> movies) {
        this.mContext = mContext;
        this.movies = movies;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_movie, viewGroup, false);
       final MovieViewHolder movieViewHolder = new MovieViewHolder(layout);
       movieViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int position = movieViewHolder.getAdapterPosition();
               Intent intent = new Intent(mContext, MovieDetailActivity.class);
               intent.putExtra("MOVIE_DETAIL", movies.get(position));
               mContext.startActivity(intent);
           }
       });
       return  movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setMovieData(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size() ;
    }
}
