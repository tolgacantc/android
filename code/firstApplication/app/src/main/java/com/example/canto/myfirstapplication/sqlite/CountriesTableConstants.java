package com.example.canto.myfirstapplication.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CountriesTableConstants {
    // Table Name
    static final String TABLE_NAME = "COUNTRIES";

    // Table columns
    public static final String _ID = "_id";
    public static final String SUBJECT = "subject";
    public static final String DESC = "description";

    static final String[] COLUMNS = new String[] { _ID, SUBJECT, DESC };
    // Database Information
    static final String DB_NAME = "COUNTRIES.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT + " TEXT NOT NULL, " + DESC + " TEXT);";

}
