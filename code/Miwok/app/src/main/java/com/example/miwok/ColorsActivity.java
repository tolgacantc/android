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
        words.add(new Word("red", "kirmizi"));
        words.add(new Word("mustard yellow", "sari"));
        words.add(new Word("dusty yellow", "sari"));
        words.add(new Word("green", "yesil"));
        words.add(new Word("brown", "kahve"));
        words.add(new Word("gray", "gri"));
        words.add(new Word("black", "siyah"));
        words.add(new Word("white", "beyaz"));

        WordAdapter wordAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}
