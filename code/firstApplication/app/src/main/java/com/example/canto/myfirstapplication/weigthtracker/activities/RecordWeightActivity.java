package com.example.canto.myfirstapplication.weigthtracker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.canto.myfirstapplication.R;
import com.example.canto.myfirstapplication.weigthtracker.WeightTableManager;

public class RecordWeightActivity extends Activity implements View.OnClickListener {
    private Button addTodoBtn;
    private EditText weightEditText;

    private WeightTableManager weightTableManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Record Weight");
        setContentView(R.layout.weight_activity_add_record);

        addTodoBtn = (Button) findViewById(R.id.add_record);
        weightEditText = (EditText) findViewById(R.id.weight_edittext);

        weightTableManager = new WeightTableManager(this);
        weightTableManager.open();

        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.add_record:
                final String weight = weightEditText.getText().toString();
                weightTableManager.insert(Double.parseDouble(weight));

                Intent main = new Intent(RecordWeightActivity.this, ListWeightActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }
}
