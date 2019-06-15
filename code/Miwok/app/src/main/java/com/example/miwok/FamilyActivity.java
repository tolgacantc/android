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
        words.add(new Word("father", "baba", R.drawable.family_father));
        words.add(new Word("mother", "anne", R.drawable.family_mother));
        words.add(new Word("son", "ogul", R.drawable.family_son));
        words.add(new Word("daughter", "kiz", R.drawable.family_daughter));
        words.add(new Word("older brother", "abi", R.drawable.family_older_brother));
        words.add(new Word("younger brother", "erkek kardes", R.drawable.family_younger_brother));
        words.add(new Word("older sister", "abla", R.drawable.family_older_sister));
        words.add(new Word("younger sister", "kiz kardes", R.drawable.family_younger_sister));
        words.add(new Word("grandmother ", "buyuk anne", R.drawable.family_grandmother));
        words.add(new Word("grandfather", "dede", R.drawable.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}
