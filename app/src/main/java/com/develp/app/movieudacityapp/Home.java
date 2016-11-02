package com.develp.app.movieudacityapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment {
    private final static String API_KEY = "78bf6a2ef253cfbbb8e3067ab8956a4b";
    RecyclerView recyclerView;
    Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragmentre

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        setHasOptionsMenu(true);

        top_rated();

        return view;
    }

    private void favorite() {
        Interface interfaceApi = Api_client.getRetrofitObject().create(Interface.class);

        Call<ResultOfMovie> favoriteMovie = interfaceApi.getFavoriteMovie(API_KEY);

        favoriteMovie.enqueue(new Callback<ResultOfMovie>() {

            @Override
            public void onResponse(Call<ResultOfMovie> call, Response<ResultOfMovie> response) {

                List<MovieInfo> movieInformation = response.body().getResults();

                RecyclerView_Adapter recyclerViewAdapter = new RecyclerView_Adapter(movieInformation,getContext());

                recyclerView.setAdapter(recyclerViewAdapter);

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<ResultOfMovie> call, Throwable t) {

            }
        });
    }

    private void pupolar() {

        Interface interfaceApi = Api_client.getRetrofitObject().create(Interface.class);

        Call<ResultOfMovie> pupolarMovie = interfaceApi.getPopular(API_KEY);

        pupolarMovie.enqueue(new Callback<ResultOfMovie>() {

            @Override
            public void onResponse(Call<ResultOfMovie> call, Response<ResultOfMovie> response) {

                List<MovieInfo> movieInformation = response.body().getResults();

                RecyclerView_Adapter recyclerViewAdapter = new RecyclerView_Adapter(movieInformation,getContext());

                recyclerView.setAdapter(recyclerViewAdapter);

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<ResultOfMovie> call, Throwable t) {

            }
        });
    }

    private void top_rated() {
        Interface interfaceApi = Api_client.getRetrofitObject().create(Interface.class);

        Call<ResultOfMovie> topRated = interfaceApi.getTopRatedMovie(API_KEY);

        topRated.enqueue(new Callback<ResultOfMovie>() {

            @Override
            public void onResponse(Call<ResultOfMovie> call, Response<ResultOfMovie> response) {

                List<MovieInfo> movieInformation = response.body().getResults();

                RecyclerView_Adapter recyclerViewAdapter = new RecyclerView_Adapter(movieInformation,getContext());

                recyclerView.setAdapter(recyclerViewAdapter);

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<ResultOfMovie> call, Throwable t) {

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.popular :
                pupolar();
                return true;
            case R.id.top_rated :
                top_rated();
                return true;
            case R.id.favorite :
                favorite();
                return true;

        }


        return super.onOptionsItemSelected(item);
    }
}
