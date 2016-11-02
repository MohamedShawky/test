package com.develp.app.movieudacityapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abohabiba on 8/28/2016.
 */
public class MovieDetailes {

    @SerializedName("id")
    private Integer id;
    @SerializedName("poster_path")
    private String posterPath;

    public void setIDURl(int id, String posterPath){

        this.id = id;
        this.posterPath = posterPath;

    }

}
