package com.example.teamscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void teamA3P(View v) {
        TextView textView = findViewById(R.id.ta_textView);
        increment(textView, 3);
    }

    public void teamA2P(View v) {
        TextView textView = findViewById(R.id.ta_textView);
        increment(textView, 2);
    }

    public void teamA1P(View v) {
        TextView textView = findViewById(R.id.ta_textView);
        increment(textView, 1);
    }

    public void teamB3P(View v) {
        TextView textView = findViewById(R.id.tb_textView);
        increment(textView, 3);
    }

    public void teamB2P(View v) {
        TextView textView = findViewById(R.id.tb_textView);
        increment(textView, 2);
    }

    public void teamB1P(View v) {
        TextView textView = findViewById(R.id.tb_textView);
        increment(textView, 1);
    }

    public void reset(View v) {
        TextView textView = findViewById(R.id.tb_textView);
        textView.setText("0");
        textView = findViewById(R.id.ta_textView);
        textView.setText("0");
    }

    private void increment(TextView tv, int n) {
        int currentVal = Integer.parseInt(tv.getText().toString());
        tv.setText((currentVal + n) + "");
    }
}
