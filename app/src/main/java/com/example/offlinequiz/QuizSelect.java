package com.example.offlinequiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The screen where the user can select a topic to take a quiz on.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class QuizSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_select);

        Button buttonRhythm = (Button) findViewById(R.id.button_quiz_select_to_quiz_rhythm);
        buttonRhythm.setOnClickListener(v -> openQuizRhythm());

        Button buttonScales = (Button) findViewById(R.id.button_quiz_select_to_quiz_scales);
        buttonScales.setOnClickListener(v -> openQuizScales());

        Button buttonIntervals = (Button) findViewById(R.id.button_quiz_select_to_quiz_intervals);
        buttonIntervals.setOnClickListener(v -> Toast.makeText(QuizSelect.this, "Coming soon!", Toast.LENGTH_SHORT).show());
    }

    /**
     * Method to go to the Rhythm Quiz screen.
     */
    public void openQuizRhythm() {
        Intent intent = new Intent(this, QuizRhythm.class);
        startActivity(intent);
    }

    /**
     * Method to go to the Scales Quiz screen.
     */
    public void openQuizScales() {
        Intent intent = new Intent(this, QuizScales.class);
        startActivity(intent);
    }
}