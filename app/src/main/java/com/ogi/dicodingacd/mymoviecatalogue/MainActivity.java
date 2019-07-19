package com.ogi.dicodingacd.mymoviecatalogue;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.ogi.dicodingacd.mymoviecatalogue.adapter.ViewPagerAdapter;
import com.ogi.dicodingacd.mymoviecatalogue.fragments.MovieFragment;
import com.ogi.dicodingacd.mymoviecatalogue.fragments.TvShowFragment;
import com.ogi.dicodingacd.mymoviecatalogue.model.Movie;
import com.ogi.dicodingacd.mymoviecatalogue.viewholder.MovieViewHolder;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
            getSupportActionBar().setElevation(0);
        }

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new MovieFragment(), getResources().getString(R.string.tab_movie));
        adapter.AddFragment(new TvShowFragment(), getResources().getString(R.string.tab_tvshow));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_movie_white_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_live_tv_white_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.change_language_settings){
            Intent setLang = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(setLang);
        }else if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
