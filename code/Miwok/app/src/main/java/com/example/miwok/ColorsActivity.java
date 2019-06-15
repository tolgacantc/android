package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "kirmizi", R.drawable.color_red));
        words.add(new Word("mustard yellow", "sari", R.drawable.color_dusty_yellow));
        words.add(new Word("dusty yellow", "sari", R.drawable.color_dusty_yellow));
        words.add(new Word("green", "yesil", R.drawable.color_green));
        words.add(new Word("brown", "kahve", R.drawable.color_brown));
        words.add(new Word("gray", "gri", R.drawable.color_gray));
        words.add(new Word("black", "siyah", R.drawable.color_black));
        words.add(new Word("white", "beyaz", R.drawable.color_white));

        WordAdapter wordAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}
