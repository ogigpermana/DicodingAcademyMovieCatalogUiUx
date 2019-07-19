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
import com.ogi.dicodingacd.mymoviecatalogue.adapter.TvShowAdapter;
import com.ogi.dicodingacd.mymoviecatalogue.model.TvShow;

import java.util.ArrayList;
import java.util.List;

public class TvShowFragment extends Fragment {

    private String[] dataTvShowTitle, dataTvShowOverview, dataTvShowRelease, dataTvShowGenres, dataTvShowCreator;
    private int[] dataTvShowRating;
    private TypedArray dataTvShowPoster;

    private List<TvShow> tvShows;

    // define empty constructor
    public TvShowFragment() {}


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_tv_show, container, false);
        RecyclerView recyclerView = layout.findViewById(R.id.rv_tv_shows_id);
        TvShowAdapter tvShowAdapter = new TvShowAdapter(getContext(), tvShows);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(tvShowAdapter);
        return layout;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepare();
        itemAdd();
    }

    private void prepare(){
        dataTvShowTitle = getResources().getStringArray(R.array.data_tvshow_title);
        dataTvShowOverview = getResources().getStringArray(R.array.data_tvshow_overview);
        dataTvShowRelease = getResources().getStringArray(R.array.data_tvshow_release);
        dataTvShowGenres = getResources().getStringArray(R.array.data_tvshow_genres);
        dataTvShowCreator = getResources().getStringArray(R.array.data_tvshow_creator);
        dataTvShowRating = getResources().getIntArray(R.array.data_tvshow_rating);
        dataTvShowPoster = getResources().obtainTypedArray(R.array.data_image_poster_tvshow);
    }

    private void itemAdd(){
        tvShows = new ArrayList<>();
        for (int i = 0; i < dataTvShowTitle.length; i++){
            TvShow tvShow = new TvShow();
            tvShow.setTitle(dataTvShowTitle[i]);
            tvShow.setOverview(dataTvShowOverview[i]);
            tvShow.setRelease(dataTvShowRelease[i]);
            tvShow.setGenres(dataTvShowGenres[i]);
            tvShow.setCreator(dataTvShowCreator[i]);
            tvShow.setRating(dataTvShowRating[i]);
            tvShow.setPoster(dataTvShowPoster.getResourceId(i, -1));
            tvShows.add(tvShow);
        }
    }
}
