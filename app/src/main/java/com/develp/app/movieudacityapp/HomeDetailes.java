 package com.develp.app.movieudacityapp;

 import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


 public class HomeDetailes extends Fragment {

     private final static String API_KEY = "78bf6a2ef253cfbbb8e3067ab8956a4b";

     RecyclerView recyclerViewT;
     RecyclerView recyclerViewR;
     TextView titleMovie;
     ImageView imageMovie;
     TextView dateMovie;
     TextView timeMovie;
     TextView averageMovie;
     Button favMovie;
     int id;
     DataBaseConnection dataBaseConnection;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_home_detailes, container, false);

        recyclerViewT = (RecyclerView) view.findViewById(R.id.recyclerViewTrialer);

        recyclerViewR = (RecyclerView) view.findViewById(R.id.recyclerReview);

        favMovie = (Button) view.findViewById(R.id.favButton);

        id = DataOFMovie.getId();

         final String url = DataOFMovie.getImage();

        Interface trailerApi = Api_client.getRetrofitObject().create(Interface.class);

        Call<TrailrerResult> movieTrailer = trailerApi.getMovieTrailer(id, API_KEY);

        movieTrailer.enqueue(new Callback<TrailrerResult>() {
            @Override
            public void onResponse(Call<TrailrerResult> call, Response<TrailrerResult> response) {

                List<MovieTrailer> movieTrailers = response.body().getResults();

                Adapter_Trailer adapter_trailer_review = new Adapter_Trailer(movieTrailers, getContext());

                recyclerViewT.setAdapter(adapter_trailer_review);

                recyclerViewT.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
            }

            @Override
            public void onFailure(Call<TrailrerResult> call, Throwable t) {

            }
        });

        Interface reviewApi = Api_client.getRetrofitObject().create(Interface.class);

        Call<ReviwerResult> movieReview = reviewApi.getMovieReview(id, API_KEY);

        movieReview.enqueue(new Callback<ReviwerResult>() {
            @Override
            public void onResponse(Call<ReviwerResult> call, Response<ReviwerResult> response) {

                List<MovieReview> results = response.body().getResults();

                Adapter_Review adapter_review = new Adapter_Review(results,getContext());

                recyclerViewR.setAdapter(adapter_review);

                recyclerViewR.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<ReviwerResult> call, Throwable t) {

            }
        });


        Interface anInterface = Api_client.getRetrofitObject().create(Interface.class);

        Call<MovieInfo> movieDetailes = anInterface.getMovieDetails(id,API_KEY);

        titleMovie = (TextView) view.findViewById(R.id.Title);
        dateMovie = (TextView) view.findViewById(R.id.dateText);
        averageMovie = (TextView) view.findViewById(R.id.voteText);
        timeMovie = (TextView) view.findViewById(R.id.timeText);
        imageMovie = (ImageView) view.findViewById(R.id.posterImageView);


        movieDetailes.enqueue(new Callback<MovieInfo>() {

            @Override
            public void onResponse(Call<MovieInfo> call, Response<MovieInfo> response) {

                titleMovie.setText(response.body().getOriginalTitle());

                Picasso.with(getContext()).load("http://image.tmdb.org/t/p/w320/"+response.body().getPosterPath()).into(imageMovie);

                dateMovie.setText(response.body().getReleaseDate().substring(0,4));

                timeMovie.setText(response.body().getRuntime()+" min");

                averageMovie.setText(response.body().getVoteAverage()+"avg");


            }

            @Override
            public void onFailure(Call<MovieInfo> call, Throwable t) {

            }
        });


        dataBaseConnection = new DataBaseConnection(getActivity());

        favMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                favMovie.setText("Make As un Favforite");

                dataBaseConnection.insert(id,url);

            }
        });

        return  view;
    }
/*String title = DataOFMovie.getTitle();

     String imagemovie = DataOFMovie.getImage();

     String datemovie = DataOFMovie. getDate();
     String timemovie = DataOFMovie.getTime();
     String averagemovie = DataOFMovie.getVote();*/
}
