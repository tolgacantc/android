package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an array of words
        List<Word> words = new ArrayList<>();
        words.add(new Word("one", "bir"));
        words.add(new Word("two", "iki"));
        words.add(new Word("three", "uc"));
        words.add(new Word("four", "dort"));
        words.add(new Word("five", "bes"));
        words.add(new Word("six", "alti"));
        words.add(new Word("seven", "yedi"));
        words.add(new Word("eight", "sekiz"));
        words.add(new Word("nine", "dokuz"));
        words.add(new Word("ten", "on"));

        ArrayAdapter<Word> itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
