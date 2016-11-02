package com.develp.app.movieudacityapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by abohabiba on 8/21/2016.
 */
public interface Interface {

     @GET("movie/top_rated")
     Call<ResultOfMovie> getTopRatedMovie(@Query("api_key") String api_Key);

     @GET("movie/favorite")
     Call<ResultOfMovie> getFavoriteMovie(@Query("api_key") String api_Key);

     @GET("movie/popular")
     Call<ResultOfMovie> getPopular(@Query("api_key") String api_Key);

     @GET("movie/{id}")
     Call<MovieInfo> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

   // @GET("movie/{id}/{type}")
   // Call<trailerReviews> getMovie(@Path("id") int id, @Path("type") String Type , @Query("api_key") String apiKey);
    @GET("movie/{id}/videos")
    Call<TrailrerResult> getMovieTrailer(@Path("id") int id,  @Query("api_key") String apiKey);

    @GET("movie/{id}/reviews")
    Call<ReviwerResult> getMovieReview(@Path("id") int id, @Query("api_key") String apiKey);



}
