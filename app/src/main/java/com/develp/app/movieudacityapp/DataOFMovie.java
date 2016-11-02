package com.develp.app.movieudacityapp;

/**
 * Created by abohabiba on 8/26/2016.
 */
public class DataOFMovie {

    private  static String title;
    private  static String date;
    private  static String time;
    private  static String vote;
    private  static String image;
    private  static int id;

    public DataOFMovie(int id) {
        this.id = id;
    }

    public DataOFMovie(String title, String date, String time, String vote, String image) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.vote = vote;
        this.image = image;

    }

    public static int getId() {
        return id;
    }

    public static String getTitle() {
        return title;
    }

    public static String getDate() {
        return date;
    }

    public static String getTime()
    {
      return time;
    }

    public static String getVote() {
        return vote;
    }

    public static String getImage() {
        return image;
    }
}
