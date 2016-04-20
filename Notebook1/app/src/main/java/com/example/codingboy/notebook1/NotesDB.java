package com.example.codingboy.notebook1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by codingBoy on 16/4/3.
 */
public class NotesDB extends SQLiteOpenHelper
{
    public static final String TABLE_NAME="notes";
    public static final String CONTENT="content";
    public static final String TIME="times";
    public static final String ID="_id";

    public static final String CREATE_TABLE="CREATE TABLE if not exists " + TABLE_NAME + " ( "
            +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +CONTENT+" TEXT NOT NULL,"
            +TIME+" TEXT NOT NULL)";
    public NotesDB(Context context)
    {
        super(context,"notes",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {

    }
}
