package com.develp.app.movieudacityapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abohabiba on 8/21/2016.
 */
public class Api_client {

    private  static String basicUrl = "http://api.themoviedb.org/3/";
    static Retrofit retrofitObject = null;

    public static Retrofit getRetrofitObject() {

        if(retrofitObject == null){

            retrofitObject = new Retrofit.Builder().baseUrl(basicUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofitObject;
    }


}
