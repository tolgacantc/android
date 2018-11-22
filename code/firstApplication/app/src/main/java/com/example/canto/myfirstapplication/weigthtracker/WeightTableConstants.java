package com.example.canto.myfirstapplication.weigthtracker;

public class WeightTableConstants {
    static final String TABLE_NAME = "WEIGHTS";

    // Table columns
    public static final String _ID = "_id";
    public static final String RECORD_DATE = "record_date";
    public static final String WEIGHT = "weight";

    public static final String[] COLUMNS = new String[] { _ID, RECORD_DATE, WEIGHT};

    // Database Information
    static final String DB_NAME = "WEIGHTS.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + RECORD_DATE + " TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP, "
            + WEIGHT + " REAL);";

}
