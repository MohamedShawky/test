package com.develp.app.movieudacityapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abohabiba on 8/29/2016.
 */
public class MovieTrailer {

    @SerializedName("Key")
    private String Key;

    @SerializedName("name")
    private  String name;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
