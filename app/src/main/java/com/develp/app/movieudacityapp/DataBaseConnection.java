package com.develp.app.movieudacityapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by abohabiba on 8/31/2016.
 */
public class DataBaseConnection {

    private Context context;
    DataBaseHelper dataBaseHelper;

    public DataBaseConnection(Context context) {

        dataBaseHelper = new DataBaseHelper(context);
        this.context = context;

    }

    public  long insert(int id,String url ){

        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHelper.Url,url);

        contentValues.put(DataBaseHelper.Id,id);

        Long i = sqLiteDatabase.insert(DataBaseHelper.tableName,null, contentValues);

        return i;

    }

    public  int  delet(int id ){

        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();

        String [] idDelete = {DataBaseHelper.Id};

        int i = sqLiteDatabase.delete(DataBaseHelper.tableName,DataBaseHelper.Id +"=?", idDelete);

        return i;

    }

}
