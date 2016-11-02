package com.develp.app.movieudacityapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abohabiba on 8/29/2016.
 */
public class ReviwerResult {

        @SerializedName("results")
        private List<MovieReview> results;

        public List<MovieReview> getResults() {
            return results;
        }

        public void setResults(List<MovieReview> results) {
            this.results = results;
        }
    }


