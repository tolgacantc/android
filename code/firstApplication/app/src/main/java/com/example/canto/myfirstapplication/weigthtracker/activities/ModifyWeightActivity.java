package com.example.canto.myfirstapplication.weigthtracker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.canto.myfirstapplication.R;
import com.example.canto.myfirstapplication.weigthtracker.WeightTableManager;

public class ModifyWeightActivity extends Activity implements View.OnClickListener {
    private EditText weightText;
    private Button updateBtn, deleteBtn;

    private long _weight_id;

    private WeightTableManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modify Record");

        setContentView(R.layout.weight_activity_modify_record);

        dbManager = new WeightTableManager(this);
        dbManager.open();

        weightText = (EditText) findViewById(R.id.weight_edittext);

        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("weight_id");
        String weight = intent.getStringExtra("weight");

        _weight_id = Long.parseLong(id);

        weightText.setText(weight);

        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                String weight = weightText.getText().toString();

                dbManager.update(_weight_id, Double.parseDouble(weight));
                this.returnHome();
                break;

            case R.id.btn_delete:
                dbManager.delete(_weight_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), ListWeightActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
