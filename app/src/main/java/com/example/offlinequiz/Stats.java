package com.example.offlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

/**
 * The screen where the user can view their stats.
 * Stats shown include course progress for each topic, and high score and number of attempts
 * for each quiz.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class Stats extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        TextView textViewNameStats = (TextView) findViewById(R.id.text_view_my_stats);
        TextView textViewRhythmCourse = (TextView) findViewById(R.id.text_view_stats_rhythm_course);
        TextView textViewScalesCourse = (TextView) findViewById(R.id.text_view_stats_scales_course);
        TextView textViewRhythmEasyHighScore = (TextView) findViewById(R.id.text_view_stats_rhythm_easy_high_score);
        TextView textViewScalesEasyHighScore = (TextView) findViewById(R.id.text_view_stats_scales_easy_high_score);
        TextView textViewRhythmMediumHighScore = (TextView) findViewById(R.id.text_view_stats_rhythm_medium_high_score);
        TextView textViewScalesMediumHighScore = (TextView) findViewById(R.id.text_view_stats_scales_medium_high_score);
        TextView textViewRhythmHardHighScore = (TextView) findViewById(R.id.text_view_stats_rhythm_hard_high_score);
        TextView textViewScalesHardHighScore = (TextView) findViewById(R.id.text_view_stats_scales_hard_high_score);
        TextView textViewRhythmEasyAttempts = (TextView) findViewById(R.id.text_view_stats_rhythm_easy_attempts);
        TextView textViewScalesEasyAttempts = (TextView) findViewById(R.id.text_view_stats_scales_easy_attempts);
        TextView textViewRhythmMediumAttempts = (TextView) findViewById(R.id.text_view_stats_rhythm_medium_attempts);
        TextView textViewScalesMediumAttempts = (TextView) findViewById(R.id.text_view_stats_scales_medium_attempts);
        TextView textViewRhythmHardAttempts = (TextView) findViewById(R.id.text_view_stats_rhythm_hard_attempts);
        TextView textViewScalesHardAttempts = (TextView) findViewById(R.id.text_view_stats_scales_hard_attempts);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        boolean boolCourseCompletedRhythm = sharedPreferences.getBoolean("Course Completed Rhythm", false);
        boolean boolCourseCompletedScales = sharedPreferences.getBoolean("Course Completed Scales", false);
        int intRhythmEasyHighScore = sharedPreferences.getInt("Rhythm Easy High Score", 0);
        int intScalesEasyHighScore = sharedPreferences.getInt("Scales Easy High Score", 0);
        int intRhythmMediumHighScore = sharedPreferences.getInt("Rhythm Medium High Score", 0);
        int intScalesMediumHighScore = sharedPreferences.getInt("Scales Medium High Score", 0);
        int intRhythmHardHighScore = sharedPreferences.getInt("Rhythm Hard High Score", 0);
        int intScalesHardHighScore = sharedPreferences.getInt("Scales Hard High Score", 0);
        int intRhythmEasyAttempts = sharedPreferences.getInt("Rhythm Easy Attempts", 0);
        int intScalesEasyAttempts = sharedPreferences.getInt("Scales Easy Attempts", 0);
        int intRhythmMediumAttempts = sharedPreferences.getInt("Rhythm Medium Attempts", 0);
        int intScalesMediumAttempts = sharedPreferences.getInt("Scales Medium Attempts", 0);
        int intRhythmHardAttempts = sharedPreferences.getInt("Rhythm Hard Attempts", 0);
        int intScalesHardAttempts = sharedPreferences.getInt("Scales Hard Attempts", 0);

        textViewNameStats.setText(username + "'s Stats");

        if (boolCourseCompletedRhythm) {
            textViewRhythmCourse.setText("Course Completed: Yes");
        }

        if (boolCourseCompletedScales) {
            textViewScalesCourse.setText("Course Completed: Yes");
        }

        textViewRhythmEasyHighScore.setText("Best: " + intRhythmEasyHighScore + "%");
        textViewScalesEasyHighScore.setText("Best: " + intScalesEasyHighScore + "%");
        textViewRhythmMediumHighScore.setText("Best: " + intRhythmMediumHighScore + "%");
        textViewScalesMediumHighScore.setText("Best: " + intScalesMediumHighScore + "%");
        textViewRhythmHardHighScore.setText("Best: " + intRhythmHardHighScore + "%");
        textViewScalesHardHighScore.setText("Best: " + intScalesHardHighScore + "%");
        textViewRhythmEasyAttempts.setText("Attempts: " + intRhythmEasyAttempts);
        textViewScalesEasyAttempts.setText("Attempts: " + intScalesEasyAttempts);
        textViewRhythmMediumAttempts.setText("Attempts: " + intRhythmMediumAttempts);
        textViewScalesMediumAttempts.setText("Attempts: " + intScalesMediumAttempts);
        textViewRhythmHardAttempts.setText("Attempts: " + intRhythmHardAttempts);
        textViewScalesHardAttempts.setText("Attempts: " + intScalesHardAttempts);
    }
}