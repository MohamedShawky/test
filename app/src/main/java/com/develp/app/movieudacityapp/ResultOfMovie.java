package com.develp.app.movieudacityapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abohabiba on 8/21/2016.
 */
public class ResultOfMovie {

    @SerializedName("results")
    private List<MovieInfo> results;

    public List<MovieInfo> getResults() {
        return results;
    }

    public void setResults(List<MovieInfo> results) {
        this.results = results;
    }
}
