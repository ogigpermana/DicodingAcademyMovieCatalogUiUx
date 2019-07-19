package com.ogi.dicodingacd.mymoviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title, overview, release, genres, director, screenplay, writer;
    private int rating, poster;

    public Movie(String title, String overview, String release, String genres, String director, String screenplay, String writer, int rating, int poster) {
        this.title = title;
        this.overview = overview;
        this.release = release;
        this.genres = genres;
        this.director = director;
        this.screenplay = screenplay;
        this.writer = writer;
        this.rating = rating;
        this.poster = poster;
    }

    public Movie(Parcel in) {
        title = in.readString();
        overview = in.readString();
        release = in.readString();
        genres = in.readString();
        director = in.readString();
        screenplay = in.readString();
        writer = in.readString();
        rating = in.readInt();
        poster = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenplay() {
        return screenplay;
    }

    public void setScreenplay(String screenplay) {
        this.screenplay = screenplay;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public Movie(){}

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
        parcel.writeString(director);
        parcel.writeString(screenplay);
        parcel.writeString(writer);
        parcel.writeInt(rating);
        parcel.writeInt(poster);
    }
}
