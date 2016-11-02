package com.develp.app.movieudacityapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by abohabiba on 8/31/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String dataBaseNAme = "MakeAsFavorite";
    public static final String tableName = "Favorite";
    private static final int  dataVersion = 1;
    public static final String Id = "id";
    public static final String Url = "url";
    private static final String CreatTable =
            "CREATE TABLE"+tableName+"("+Id+" INTEGER, "+Url+" Text);";
    private static final String DropTable =
            "DROP TABLE IF EXISTS "+tableName;

    //, String name, SQLiteDatabase.CursorFactory factory, int version
    //, name, factory, version

    private static Context context;

    public DataBaseHelper(Context context) {
        super(context, dataBaseNAme, null, dataVersion);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

         try {

             sqLiteDatabase.execSQL(CreatTable);

         }catch (SQLException se){

             Toast.makeText(null,"exceptoin onCreat"+se,Toast.LENGTH_LONG).show();

         }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{

            sqLiteDatabase.execSQL(DropTable);
            onCreate(sqLiteDatabase);

        }catch (SQLException se){

            Toast.makeText(null,"exceptoin upgrade"+se,Toast.LENGTH_LONG).show();

        }




    }
}
