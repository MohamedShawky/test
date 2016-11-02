package com.develp.app.movieudacityapp;

import android.content.Context;
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
public class Adapter_Review extends RecyclerView.Adapter<Adapter_Review.MyHolder> {

    List<MovieReview> movieInfoList;
    Context context;

    public Adapter_Review(List<MovieReview> movieInfoList, Context context) {
        this.context = context;
        this.movieInfoList = movieInfoList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review, null);
        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {


        String auther = movieInfoList.get(position).getAuther();

        String content = movieInfoList.get(position).getContent();

        holder.textViewAuther.setText(auther);

        holder.textViewContent.setText(content);

    }


    @Override
    public int getItemCount() {
        return movieInfoList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder{

        CardView cardView;

        TextView textViewAuther;

        TextView textViewContent;

        public MyHolder(View itemView) {
            super(itemView);

            textViewAuther = (TextView) itemView.findViewById(R.id.autherText);

            textViewContent = (TextView) itemView.findViewById(R.id.contentText);

            cardView = (CardView) itemView.findViewById(R.id.cardReview);
        }
    }
}
