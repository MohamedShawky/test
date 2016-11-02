package com.develp.app.movieudacityapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abohabiba on 8/29/2016.
 */
public class MovieReview {

    @SerializedName("content")
    private String content;

    @SerializedName("auther")
    private  String auther;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }
}
