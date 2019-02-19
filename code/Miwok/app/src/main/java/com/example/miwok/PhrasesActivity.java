package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "nereye gidin"));
        words.add(new Word("What is your name?", "adin ne"));
        words.add(new Word("My name is...", "benim adim"));
        words.add(new Word("How are you feeling?", "nasilsin?"));
        words.add(new Word("I’m feeling good.", "sukur"));
        words.add(new Word("Are you coming?", "gelcen mi"));
        words.add(new Word("Yes, I’m coming.", "geliom"));
        words.add(new Word("I’m coming.", "geliom"));
        words.add(new Word("Let’s go.", "gidek"));
        words.add(new Word("Come here.", "bel bura."));

        WordAdapter wordAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}
