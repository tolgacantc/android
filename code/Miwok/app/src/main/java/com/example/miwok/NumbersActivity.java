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
        words.add(new Word("one", "bir", R.drawable.number_one));
        words.add(new Word("two", "iki", R.drawable.number_two));
        words.add(new Word("three", "uc", R.drawable.number_three));
        words.add(new Word("four", "dort", R.drawable.number_four));
        words.add(new Word("five", "bes", R.drawable.number_five));
        words.add(new Word("six", "alti", R.drawable.number_six));
        words.add(new Word("seven", "yedi", R.drawable.number_seven));
        words.add(new Word("eight", "sekiz", R.drawable.number_eight));
        words.add(new Word("nine", "dokuz", R.drawable.number_nine));
        words.add(new Word("ten", "on", R.drawable.number_ten));

        ArrayAdapter<Word> itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
