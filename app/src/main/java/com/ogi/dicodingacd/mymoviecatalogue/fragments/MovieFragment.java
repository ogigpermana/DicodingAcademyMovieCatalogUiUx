package com.ogi.dicodingacd.mymoviecatalogue.fragments;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogi.dicodingacd.mymoviecatalogue.R;
import com.ogi.dicodingacd.mymoviecatalogue.adapter.MovieAdapter;
import com.ogi.dicodingacd.mymoviecatalogue.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {

    private String[] dataMovieTitle, dataMovieOverview, dataMovieRelease, dataMovieGenres, dataMovieDirector, dataMovieScreenPlay, dataMovieWriter;
    private int[] dataMovieRating;
    private TypedArray dataImagePoster;

    private List<Movie> movieList;

    // define empty constructor
    public MovieFragment() { }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_movie, container, false);
        RecyclerView recyclerView = layout.findViewById(R.id.rv_movies_id);
        MovieAdapter mAdapter = new MovieAdapter(getContext(), movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        return layout;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepare();
        addItem();
    }

    private void prepare(){
        dataMovieTitle = getResources().getStringArray(R.array.data_movie_title);
        dataMovieOverview = getResources().getStringArray(R.array.data_movie_overview);
        dataMovieRelease = getResources().getStringArray(R.array.data_movie_release);
        dataMovieGenres = getResources().getStringArray(R.array.data_movie_genres);
        dataMovieDirector = getResources().getStringArray(R.array.data_movie_director);
        dataMovieScreenPlay = getResources().getStringArray(R.array.data_movie_screenplay);
        dataMovieWriter = getResources().getStringArray(R.array.data_movie_writer);
        dataMovieRating = getResources().getIntArray(R.array.data_movie_rating);
        dataImagePoster = getResources().obtainTypedArray(R.array.data_image_poster);
    }

    private void addItem(){
        movieList = new ArrayList<>();
        for (int i = 0; i < dataMovieTitle.length; i++){
            Movie movie = new Movie();
            movie.setTitle(dataMovieTitle[i]);
            movie.setOverview(dataMovieOverview[i]);
            movie.setRelease(dataMovieRelease[i]);
            movie.setGenres(dataMovieGenres[i]);
            movie.setDirector(dataMovieDirector[i]);
            movie.setScreenplay(dataMovieScreenPlay[i]);
            movie.setWriter(dataMovieWriter[i]);
            movie.setRating(dataMovieRating[i]);
            movie.setPoster(dataImagePoster.getResourceId(i, -1));

            movieList.add(movie);
        }
    }
}
