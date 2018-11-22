package com.example.canto.myfirstapplication.weigthtracker;

import android.content.Context;
import android.database.Cursor;

import com.example.canto.myfirstapplication.common.DBTableManagerBase;

import java.util.HashMap;
import java.util.Map;

public class WeightTableManager extends DBTableManagerBase {
    public WeightTableManager(Context c) {
        super(c, WeightTableConstants.DB_NAME, null, WeightTableConstants.DB_VERSION);
    }

    @Override
    public String getCreateTableQuery() {
        return WeightTableConstants.CREATE_TABLE;
    }

    @Override
    public String getTableName() {
        return WeightTableConstants.TABLE_NAME;
    }

    public Cursor fetch() {
        return fetch(WeightTableConstants.COLUMNS, null, null, null, null, null);
    }

    public void delete(long _id) {
        delete( WeightTableConstants._ID + "=" + _id, null);
    }

    public void insert(final Double weight) {
        insert(new HashMap<String, Object>() {{
            put(WeightTableConstants.WEIGHT, weight);
        }});
    }

    public int update(long _id, final double weight) {
        Map<String, Object> values = new HashMap<String, Object>() {{
            put(WeightTableConstants.WEIGHT, weight);
        }};
        return update(values, WeightTableConstants._ID + " = " + _id, null);
    }

}
