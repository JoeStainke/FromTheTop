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
 * The screen where the user can select a difficulty and start a scales quiz.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class QuizScales extends AppCompatActivity {

    private String strSelectedTopicName = "";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_scales);

        final Button buttonScalesEasy = findViewById(R.id.select_topic_scales_easy);
        final Button buttonScalesMedium = findViewById(R.id.select_topic_scales_medium);
        final Button buttonScalesHard = findViewById(R.id.select_topic_scales_hard);

        final TextView textViewHighScoreEasy = findViewById(R.id.text_view_quiz_scales_high_score_easy);
        final TextView textViewHighScoreMedium = findViewById(R.id.text_view_quiz_scales_high_score_medium);
        final TextView textViewHighScoreHard = findViewById(R.id.text_view_quiz_scales_high_score_hard);
        final TextView textViewAttemptsEasy = findViewById(R.id.text_view_quiz_scales_attempts_easy);
        final TextView textViewAttemptsMedium = findViewById(R.id.text_view_quiz_scales_attempts_medium);
        final TextView textViewAttemptsHard = findViewById(R.id.text_view_quiz_scales_attempts_hard);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        int intScalesEasyHighScore = sharedPreferences.getInt("Scales Easy High Score", 0);
        int intScalesMediumHighScore = sharedPreferences.getInt("Scales Medium High Score", 0);
        int intScalesHardHighScore = sharedPreferences.getInt("Scales Hard High Score", 0);
        int intScalesEasyAttempts = sharedPreferences.getInt("Scales Easy Attempts", 0);
        int intScalesMediumAttempts = sharedPreferences.getInt("Scales Medium Attempts", 0);
        int intScalesHardAttempts = sharedPreferences.getInt("Scales Hard Attempts", 0);

        textViewHighScoreEasy.setText("High Score: " + intScalesEasyHighScore + "%");
        textViewHighScoreMedium.setText("High Score: " + intScalesMediumHighScore + "%");
        textViewHighScoreHard.setText("High Score: " + intScalesHardHighScore + "%");
        textViewAttemptsEasy.setText("Number of Attempts: " + intScalesEasyAttempts);
        textViewAttemptsMedium.setText("Number of Attempts: " + intScalesMediumAttempts);
        textViewAttemptsHard.setText("Number of Attempts: " + intScalesHardAttempts);

        final Button buttonStart = findViewById(R.id.button_start_quiz);

        buttonScalesEasy.setOnClickListener(v -> {
            strSelectedTopicName = "Scales - Easy";

            buttonScalesEasy.setBackgroundResource(R.drawable.round_back_blue_stroke10);

            buttonScalesMedium.setBackgroundResource(R.drawable.round_back_blue10);

            buttonScalesHard.setBackgroundResource(R.drawable.round_back_blue10);
        });

        buttonScalesMedium.setOnClickListener(v -> {
            strSelectedTopicName = "Scales - Medium";

            buttonScalesMedium.setBackgroundResource(R.drawable.round_back_blue_stroke10);

            buttonScalesEasy.setBackgroundResource(R.drawable.round_back_blue10);

            buttonScalesHard.setBackgroundResource(R.drawable.round_back_blue10);
        });

        buttonScalesHard.setOnClickListener(v -> {

            strSelectedTopicName = "Scales - Hard";

            buttonScalesHard.setBackgroundResource(R.drawable.round_back_blue_stroke10);

            buttonScalesEasy.setBackgroundResource(R.drawable.round_back_blue10);

            buttonScalesMedium.setBackgroundResource(R.drawable.round_back_blue10);
        });

        buttonStart.setOnClickListener(v -> {

            if(strSelectedTopicName.isEmpty()){
                Toast.makeText(QuizScales.this, "Please select a topic!", Toast.LENGTH_SHORT).show();
            }
            else if(strSelectedTopicName.equals("Scales - Easy")){
                Intent intent = new Intent(QuizScales.this, QuizActivity.class);
                intent.putExtra("selectedTopic", strSelectedTopicName);
                startActivity(intent);
            }
            else{
                Toast.makeText(QuizScales.this, "Coming soon!", Toast.LENGTH_SHORT).show();
            }
        });

        /*
        Replace with this once medium and hard quizzes have been added

        buttonStart.setOnClickListener(v -> {

            if(strSelectedTopicName.isEmpty()){
                Toast.makeText(QuizScales.this, "Please select a topic!", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(QuizScales.this, QuizActivity.class);
                intent.putExtra("selectedTopic", strSelectedTopicName);
                startActivity(intent);
            }
        });
         */
    }
}