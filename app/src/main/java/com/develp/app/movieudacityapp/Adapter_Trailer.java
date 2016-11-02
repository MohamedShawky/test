package com.develp.app.movieudacityapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abohabiba on 8/22/2016.
 */
public class Adapter_Trailer extends RecyclerView.Adapter<Adapter_Trailer.MyHolder> {

    List<MovieTrailer> movieInfoList;
    Context context;
    String Key;

    public Adapter_Trailer(List<MovieTrailer> movieInfoList, Context context) {
        this.context = context;
        this.movieInfoList = movieInfoList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer, null);
        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {


        String name = movieInfoList.get(position).getName();

         Key = "http://www.youtube.com/watch?v="+movieInfoList.get(position).getKey();

        holder.textViewTrailer.setText(name);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(Key));

                intent = Intent.createChooser(intent, "Choose");

                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return movieInfoList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder{

        CardView cardView;

        TextView textViewTrailer;

        public MyHolder(View itemView) {
            super(itemView);

            textViewTrailer = (TextView) itemView.findViewById(R.id.trailerText);

            cardView = (CardView) itemView.findViewById(R.id.cardTrailer);
        }
    }
}
