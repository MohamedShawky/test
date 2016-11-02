package com.develp.app.movieudacityapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abohabiba on 8/29/2016.
 */
public class TrailrerResult {
    @SerializedName("results")
    private List<MovieTrailer> results;

    public List<MovieTrailer> getResults() {
        return results;
    }

    public void setResults(List<MovieTrailer> results) {
        this.results = results;
    }


}


