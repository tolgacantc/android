package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "baba"));
        words.add(new Word("mother", "anne"));
        words.add(new Word("son", "ogul"));
        words.add(new Word("daughter", "kiz"));
        words.add(new Word("older brother", "abi"));
        words.add(new Word("younger brother", "erkek kardes"));
        words.add(new Word("older sister", "abla"));
        words.add(new Word("younger sister", "kiz kardes"));
        words.add(new Word("grandmother ", "buyuk anne"));
        words.add(new Word("grandfather", "dede"));

        WordAdapter wordAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}
