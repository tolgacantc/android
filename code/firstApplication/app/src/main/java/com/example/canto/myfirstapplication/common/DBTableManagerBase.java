package com.example.canto.myfirstapplication.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Map;

public abstract class DBTableManagerBase extends SQLiteOpenHelper {
    protected SQLiteDatabase database;

    public DBTableManagerBase(Context c, final String dbName, SQLiteDatabase.CursorFactory factory, int version) {
        super(c, dbName, factory, version);
    }

    public abstract String getCreateTableQuery();
    public abstract String getTableName();

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getCreateTableQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + getTableName());
        onCreate(db);
    }


    public DBTableManagerBase open() throws SQLException {
        this.database = getWritableDatabase();
        return this;
    }

    public void close () {
        super.close();
    }

    public void insert(Map<String, Object> columns) {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, Object> col : columns.entrySet()) {
            setContentValue(contentValues, col.getKey(), col.getValue());
        }
        database.insert(getTableName(), null, contentValues);
    }

    public Cursor fetch(final String[] cols,
                        String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        Cursor cursor = database.query(getTableName(), cols, selection, selectionArgs,groupBy, having, orderBy);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(final Map<String, Object> columns,
                      String whereClause, String[] whereArgs) {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, Object> col : columns.entrySet()) {
            setContentValue(contentValues, col.getKey(), col.getValue());
        }
        return database.update(getTableName(), contentValues, whereClause, whereArgs);
    }

    public void delete(final String whereClause, final String[] whereArgs) {
        database.delete(getTableName(), whereClause, whereArgs);
    }

    private void setContentValue(ContentValues contentValues, String key, Object value) {
        if (value instanceof String) {
            contentValues.put(key, ((String) value));
        } else if (value instanceof Long) {
            contentValues.put(key, ((Long) value));
        } else if (value instanceof Double) {
            contentValues.put(key, ((Double) value));
        } else {
            throw new RuntimeException("Not defined type");
        }
    }
}
