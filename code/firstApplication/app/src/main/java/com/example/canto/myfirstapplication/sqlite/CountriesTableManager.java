package com.example.canto.myfirstapplication.sqlite;

import android.content.Context;
import android.database.Cursor;

import com.example.canto.myfirstapplication.common.DBTableManagerBase;

import java.util.HashMap;
import java.util.Map;

public class CountriesTableManager extends DBTableManagerBase {
    public CountriesTableManager(Context c) {
        super(c, CountriesTableConstants.DB_NAME, null, CountriesTableConstants.DB_VERSION);
    }

    @Override
    public String getCreateTableQuery() {
        return CountriesTableConstants.CREATE_TABLE;
    }

    @Override
    public String getTableName() {
        return CountriesTableConstants.TABLE_NAME;
    }

    public void insert(final String name, final String desc) {
        insert(new HashMap<String, Object>() {{
            put(CountriesTableConstants.SUBJECT, name);
            put(CountriesTableConstants.DESC, desc);
        }});
    }

    public Cursor fetch() {
        return fetch(CountriesTableConstants.COLUMNS, null, null, null, null, null);
    }

    public int update(long _id, final String name, final String desc) {
        Map<String, Object> values = new HashMap<String, Object>() {{
            put(CountriesTableConstants.SUBJECT, name);
            put(CountriesTableConstants.DESC, desc);
        }};
        return update(values, CountriesTableConstants._ID + " = " + _id, null);
    }

    public void delete(long _id) {
        delete(CountriesTableConstants._ID + "=" + _id, null);
    }
}
