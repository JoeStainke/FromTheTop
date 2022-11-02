package com.example.offlinequiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The screen where the user can select a difficulty and start a rhythm quiz.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class QuizRhythm extends AppCompatActivity {

    private String strSelectedTopicName = "";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_rhythm);

        final Button buttonRhythmEasy = findViewById(R.id.select_topic_rhythm_easy);
        final Button buttonRhythmMedium = findViewById(R.id.select_topic_rhythm_medium);
        final Button buttonRhythmHard = findViewById(R.id.select_topic_rhythm_hard);

        final TextView textViewHighScoreEasy = findViewById(R.id.text_view_quiz_rhythm_high_score_easy);
        final TextView textViewHighScoreMedium = findViewById(R.id.text_view_quiz_rhythm_high_score_medium);
        final TextView textViewHighScoreHard = findViewById(R.id.text_view_quiz_rhythm_high_score_hard);
        final TextView textViewAttemptsEasy = findViewById(R.id.text_view_quiz_rhythm_attempts_easy);
        final TextView textViewAttemptsMedium = findViewById(R.id.text_view_quiz_rhythm_attempts_medium);
        final TextView textViewAttemptsHard = findViewById(R.id.text_view_quiz_rhythm_attempts_hard);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        int intRhythmEasyHighScore = sharedPreferences.getInt("Rhythm Easy High Score", 0);
        int intRhythmMediumHighScore = sharedPreferences.getInt("Rhythm Medium High Score", 0);
        int intRhythmHardHighScore = sharedPreferences.getInt("Rhythm Hard High Score", 0);
        int intRhythmEasyAttempts = sharedPreferences.getInt("Rhythm Easy Attempts", 0);
        int intRhythmMediumAttempts = sharedPreferences.getInt("Rhythm Medium Attempts", 0);
        int intRhythmHardAttempts = sharedPreferences.getInt("Rhythm Hard Attempts", 0);

        textViewHighScoreEasy.setText("High Score: " + intRhythmEasyHighScore + "%");
        textViewHighScoreMedium.setText("High Score: " + intRhythmMediumHighScore + "%");
        textViewHighScoreHard.setText("High Score: " + intRhythmHardHighScore + "%");
        textViewAttemptsEasy.setText("Number of Attempts: " + intRhythmEasyAttempts);
        textViewAttemptsMedium.setText("Number of Attempts: " + intRhythmMediumAttempts);
        textViewAttemptsHard.setText("Number of Attempts: " + intRhythmHardAttempts);

        final Button buttonStart = findViewById(R.id.button_start_quiz);

        buttonRhythmEasy.setOnClickListener(v -> {
            strSelectedTopicName = "Rhythm - Easy";

            buttonRhythmEasy.setBackgroundResource(R.drawable.round_back_blue_stroke10);

            buttonRhythmMedium.setBackgroundResource(R.drawable.round_back_blue10);

            buttonRhythmHard.setBackgroundResource(R.drawable.round_back_blue10);
        });

        buttonRhythmMedium.setOnClickListener(v -> {
            strSelectedTopicName = "Rhythm - Medium";

            buttonRhythmMedium.setBackgroundResource(R.drawable.round_back_blue_stroke10);

            buttonRhythmEasy.setBackgroundResource(R.drawable.round_back_blue10);

            buttonRhythmHard.setBackgroundResource(R.drawable.round_back_blue10);
        });

        buttonRhythmHard.setOnClickListener(v -> {

            strSelectedTopicName = "Rhythm - Hard";

            buttonRhythmHard.setBackgroundResource(R.drawable.round_back_blue_stroke10);

            buttonRhythmEasy.setBackgroundResource(R.drawable.round_back_blue10);

            buttonRhythmMedium.setBackgroundResource(R.drawable.round_back_blue10);
        });

        buttonStart.setOnClickListener(v -> {

            if(strSelectedTopicName.isEmpty()){
                Toast.makeText(QuizRhythm.this, "Please select a topic!", Toast.LENGTH_SHORT).show();
            }
            else if (strSelectedTopicName.equals("Rhythm - Easy")){
                Intent intent = new Intent(QuizRhythm.this, QuizActivity.class);
                intent.putExtra("selectedTopic", strSelectedTopicName);
                startActivity(intent);
            }
            else{
                Toast.makeText(QuizRhythm.this, "Coming soon!", Toast.LENGTH_SHORT).show();
            }
        });

        /*
        Replace with this once medium and hard quizzes have been added

        buttonStart.setOnClickListener(v -> {

            if(strSelectedTopicName.isEmpty()){
                Toast.makeText(QuizRhythm.this, "Please select a topic!", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(QuizRhythm.this, QuizActivity.class);
                intent.putExtra("selectedTopic", strSelectedTopicName);
                startActivity(intent);
            }
        });
         */
    }
}