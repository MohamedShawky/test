package com.develp.app.movieudacityapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by abohabiba on 8/22/2016.
 */
public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.MyHolder> {


    List<MovieInfo> movieInfoList;
    Context context;
    String posterPath;


    public RecyclerView_Adapter(List<MovieInfo> movieInfoList, Context context) {
        this.context = context;
        this.movieInfoList = movieInfoList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poster_image, null);
        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        posterPath = "http://image.tmdb.org/t/p/w320/"+movieInfoList.get(position).getPosterPath();

        Picasso.with(context).load(posterPath).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainDetailes.class);

                int  id = movieInfoList.get(position).getId();

                DataOFMovie dataOFMovie_id = new DataOFMovie(id);

                context.startActivity(intent);

               DataOFMovie dataOFMovie = new DataOFMovie( movieInfoList.get(position).getOriginalTitle(), movieInfoList.get(position).getReleaseDate().substring(0,4) ,String.valueOf(movieInfoList.get(position).getId()) ,movieInfoList.get(position).getVoteAverage().toString() ,"http://image.tmdb.org/t/p/w320/"+movieInfoList.get(position).getPosterPath());

            }
        });
       /* holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainDetailes.class);
                DataOFMovie dataOFMovie = new DataOFMovie( movieInfoList.get(position).getOriginalTitle(), movieInfoList.get(position).getReleaseDate().substring(0,4) ,String.valueOf(movieInfoList.get(position).getId()) ,movieInfoList.get(position).getVoteAverage().toString() ,"http://image.tmdb.org/t/p/w320/"+movieInfoList.get(position).getPosterPath());
                context.startActivity(intent);

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return movieInfoList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        CardView cardView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.photo_poster);

            cardView = (CardView) itemView.findViewById(R.id.view);
        }
    }
}
