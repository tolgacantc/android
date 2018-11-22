package com.example.canto.myfirstapplication.sqlite.activities;

/**
 * Created by anupamchugh on 19/10/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.canto.myfirstapplication.R;
import com.example.canto.myfirstapplication.sqlite.CountriesTableManager;

public class AddCountryActivity extends Activity implements OnClickListener {

    private Button addTodoBtn;
    private EditText subjectEditText;
    private EditText descEditText;

    private CountriesTableManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Record");

        setContentView(R.layout.country_activity_add_record);

        subjectEditText = (EditText) findViewById(R.id.subject_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);

        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new CountriesTableManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = subjectEditText.getText().toString();
                final String desc = descEditText.getText().toString();

                dbManager.insert(name, desc);

                Intent main = new Intent(AddCountryActivity.this, ListCountryActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }
}