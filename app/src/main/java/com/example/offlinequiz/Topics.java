package com.example.offlinequiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The screen where the user can select a topic to learn about.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class Topics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        // initialise buttons
        Button buttonRhythm = (Button) findViewById(R.id.button_topics_to_learn_rhythm);
        buttonRhythm.setOnClickListener(v -> openLearnRhythm());

        Button buttonScales = (Button) findViewById(R.id.button_topics_to_learn_scales);
        buttonScales.setOnClickListener(v -> openLearnScales());

        Button buttonIntervals = (Button) findViewById(R.id.button_topics_to_learn_intervals);
        buttonIntervals.setOnClickListener(v -> Toast.makeText(Topics.this, "Coming soon!", Toast.LENGTH_SHORT).show());
    }

    /**
     * Method to open the learning materials for the Rhythm topic
     */
    public void openLearnRhythm() {
        Intent intent = new Intent(this, LearnRhythm.class);
        startActivity(intent);
    }

    /**
     * Method to open the learning materials for the Scales topic
     */
    public void openLearnScales() {
        Intent intent = new Intent(this, LearnScales.class);
        startActivity(intent);
    }
}