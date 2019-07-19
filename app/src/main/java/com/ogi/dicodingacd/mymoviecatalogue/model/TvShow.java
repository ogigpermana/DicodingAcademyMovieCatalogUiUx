package com.ogi.dicodingacd.mymoviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String title, overview, release, genres, creator;
    private int poster, rating;

    public TvShow(String title, String overview, String release, String genres, String creator, int poster, int rating) {
        this.title = title;
        this.overview = overview;
        this.release = release;
        this.genres = genres;
        this.creator = creator;
        this.poster = poster;
        this.rating = rating;
    }

    protected TvShow(Parcel in) {
        title = in.readString();
        overview = in.readString();
        release = in.readString();
        genres = in.readString();
        creator = in.readString();
        poster = in.readInt();
        rating = in.readInt();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public TvShow(){}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(release);
        parcel.writeString(genres);
        parcel.writeString(creator);
        parcel.writeInt(poster);
        parcel.writeInt(rating);
    }
}
