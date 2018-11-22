package com.example.canto.myfirstapplication.weigthtracker.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.canto.myfirstapplication.R;
import com.example.canto.myfirstapplication.weigthtracker.WeightTableConstants;
import com.example.canto.myfirstapplication.weigthtracker.WeightTableManager;

public class ListWeightActivity extends AppCompatActivity {
    private WeightTableManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    final int[] to = new int[] { R.id.weight_id, R.id.record_date, R.id.weight};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.country_fragment_emp_list);

        dbManager = new WeightTableManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.weight_activity_view_record, cursor, WeightTableConstants.COLUMNS,
                to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView weightIdTextView = (TextView) view.findViewById(R.id.weight_id);
                TextView recordDateTextView = (TextView) view.findViewById(R.id.record_date);
                TextView weightTextView = (TextView) view.findViewById(R.id.weight);

                String id = weightIdTextView.getText().toString();
                String recordDate = recordDateTextView.getText().toString();
                String weight = weightTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModifyWeightActivity.class);
                modify_intent.putExtra("record_date", recordDate);
                modify_intent.putExtra("weight", weight);
                modify_intent.putExtra("weight_id", id);

                startActivity(modify_intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            Intent add_mem = new Intent(this, RecordWeightActivity.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

}
