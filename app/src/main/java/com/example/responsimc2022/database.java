package com.example.responsimc2022;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBresponsimc2022 extends SQLiteOpenHelper{

    private static final String NamaDatabse = "unpi.db";
    private static final int VersiDatabase = 1;

    public DBresponsimc2022(Context context) {
        super(context, NamaDatabse, null, VersiDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}