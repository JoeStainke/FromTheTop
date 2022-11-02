package com.example.offlinequiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

/**
 * The quiz results screen.
 * The user is shown details about the results of the quiz they have just completed.
 * The user's high score and number of attempts for the chosen topic and difficulty are updated
 * as necessary.
 * Progress towards the user's daily quiz goal is also updated.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class QuizResults extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final Button buttonReturnHome = findViewById(R.id.button_quiz_results_to_home);
        final TextView textViewTopic = findViewById(R.id.text_view_topic);
        final TextView textViewCorrectAnswers = findViewById(R.id.text_view_correct_answers);
        final TextView textViewIncorrectAnswers = findViewById(R.id.text_view_incorrect_answers);
        final TextView textViewQuizScore = findViewById(R.id.text_view_quiz_score);
        final TextView textViewNewHighScore = findViewById(R.id.text_view_new_high_score);
        final TextView textViewGoalReached = findViewById(R.id.text_view_goal_reached);

        // Gets data passed through from the Quiz Activity and works out a percentage score
        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getIncorrectAnswers = getIntent().getIntExtra("incorrect", 0);
        final int getQuizScore = ((getCorrectAnswers) * 10);
        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        // Gets a calendar based on the user's time zone
        Calendar calendar = Calendar.getInstance();

        // Gets the current week number (from 1-53)
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

        // Gets the current date
        LocalDate dateToday = LocalDate.now();

        textViewTopic.setText((getSelectedTopicName));
        textViewCorrectAnswers.setText("Correct Answers: " + getCorrectAnswers);
        textViewIncorrectAnswers.setText("Incorrect Answers: " + getIncorrectAnswers);
        textViewQuizScore.setText("Score: " + getQuizScore + "%");

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        // Gets all the current quiz statistics so they can be updated as required

        // Gets the current high score for each quiz
        int intRhythmEasyHighScore = sharedPreferences.getInt("Rhythm Easy High Score", 0);
        int intScalesEasyHighScore = sharedPreferences.getInt("Scales Easy High Score", 0);
        int intRhythmMediumHighScore = sharedPreferences.getInt("Rhythm Medium High Score", 0);
        int intScalesMediumHighScore = sharedPreferences.getInt("Scales Medium High Score", 0);
        int intRhythmHardHighScore = sharedPreferences.getInt("Rhythm Hard High Score", 0);
        int intScalesHardHighScore = sharedPreferences.getInt("Scales Hard High Score", 0);

        // Gets the number of attempts for each quiz
        int intRhythmEasyAttempts = sharedPreferences.getInt("Rhythm Easy Attempts", 0);
        int intScalesEasyAttempts = sharedPreferences.getInt("Scales Easy Attempts", 0);
        int intRhythmMediumAttempts = sharedPreferences.getInt("Rhythm Medium Attempts", 0);
        int intScalesMediumAttempts = sharedPreferences.getInt("Scales Medium Attempts", 0);
        int intRhythmHardAttempts = sharedPreferences.getInt("Rhythm Hard Attempts", 0);
        int intScalesHardAttempts = sharedPreferences.getInt("Scales Hard Attempts", 0);

        // Checks whether or not has already been completed on the current day
        boolean quizMon = sharedPreferences.getBoolean("Quiz Mon", false);
        boolean quizTue = sharedPreferences.getBoolean("Quiz Tue", false);
        boolean quizWed = sharedPreferences.getBoolean("Quiz Wed", false);
        boolean quizThu = sharedPreferences.getBoolean("Quiz Thu", false);
        boolean quizFri = sharedPreferences.getBoolean("Quiz Fri", false);
        boolean quizSat = sharedPreferences.getBoolean("Quiz Sat", false);
        boolean quizSun = sharedPreferences.getBoolean("Quiz Sun", false);
        int intQuizDaysThisWeek = sharedPreferences.getInt("Quiz Days This Week", 0);
        int intDaysGoal = sharedPreferences.getInt("Days Goal", 0);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Updates the week number of the most recently taken quiz
        editor.putInt("Quiz Week", weekOfYear);
        editor.apply();

        /* For each quiz topic and difficulty, the number of attempts is increased by one,
        and the high score is updated if it is higher than the current high score */
        if (Objects.equals(getSelectedTopicName, "Rhythm - Easy")) {
            editor.putInt("Rhythm Easy Attempts", intRhythmEasyAttempts + 1);
            editor.apply();
            if (getQuizScore > intRhythmEasyHighScore) {
                editor.putInt("Rhythm Easy High Score", getQuizScore);
                editor.apply();
                textViewNewHighScore.setVisibility(View.VISIBLE);
            }
        }

        if (Objects.equals(getSelectedTopicName, "Scales - Easy")) {
            editor.putInt("Scales Easy Attempts", intScalesEasyAttempts + 1);
            editor.apply();
            if (getQuizScore > intScalesEasyHighScore) {
                editor.putInt("Scales Easy High Score", getQuizScore);
                editor.apply();
                textViewNewHighScore.setVisibility(View.VISIBLE);
            }
        }

        if (Objects.equals(getSelectedTopicName, "Rhythm - Medium")) {
            editor.putInt("Rhythm Medium Attempts", intRhythmMediumAttempts + 1);
            editor.apply();
            if (getQuizScore > intRhythmMediumHighScore) {
                editor.putInt("Rhythm Medium High Score", getQuizScore);
                editor.apply();
                textViewNewHighScore.setVisibility(View.VISIBLE);
            }
        }

        if (Objects.equals(getSelectedTopicName, "Scales - Medium")) {
            editor.putInt("Scales Medium Attempts", intScalesMediumAttempts + 1);
            editor.apply();
            if (getQuizScore > intScalesMediumHighScore) {
                editor.putInt("Scales Medium High Score", getQuizScore);
                editor.apply();
                textViewNewHighScore.setVisibility(View.VISIBLE);
            }
        }

        if (Objects.equals(getSelectedTopicName, "Rhythm - Hard")) {
            editor.putInt("Rhythm Hard Attempts", intRhythmHardAttempts + 1);
            editor.apply();
            if (getQuizScore > intRhythmHardHighScore) {
                editor.putInt("Rhythm Hard High Score", getQuizScore);
                editor.apply();
                textViewNewHighScore.setVisibility(View.VISIBLE);
            }
        }

        if (Objects.equals(getSelectedTopicName, "Scales - Hard")) {
            editor.putInt("Scales Hard Attempts", intScalesHardAttempts + 1);
            editor.apply();
            if (getQuizScore > intScalesHardHighScore) {
                editor.putInt("Scales Hard High Score", getQuizScore);
                editor.apply();
                textViewNewHighScore.setVisibility(View.VISIBLE);
            }
        }

        /* Check the day of the week and whether or not a quiz has been taken today.
        If it is the user's first quiz of the day the Boolean for that day is set to true,
        and the number of days in the current week where the user has taken a quiz
        is increased by one */
        if (getDayNumberNew(dateToday) == 1 && !quizMon) {
            editor.putBoolean("Quiz Mon", true);
            editor.putInt("Quiz Days This Week", intQuizDaysThisWeek + 1);
        }

        if (getDayNumberNew(dateToday) == 2 && !quizTue) {
            editor.putBoolean("Quiz Tue", true);
            editor.putInt("Quiz Days This Week", intQuizDaysThisWeek + 1);
        }

        if (getDayNumberNew(dateToday) == 3 && !quizWed) {
            editor.putBoolean("Quiz Wed", true);
            editor.putInt("Quiz Days This Week", intQuizDaysThisWeek + 1);
        }

        if (getDayNumberNew(dateToday) == 4 && !quizThu) {
            editor.putBoolean("Quiz Thu", true);
            editor.putInt("Quiz Days This Week", intQuizDaysThisWeek + 1);
        }

        if (getDayNumberNew(dateToday) == 5 && !quizFri) {
            editor.putBoolean("Quiz Fri", true);
            editor.putInt("Quiz Days This Week", intQuizDaysThisWeek + 1);
        }

        if (getDayNumberNew(dateToday) == 6 && !quizSat) {
            editor.putBoolean("Quiz Sat", true);
            editor.putInt("Quiz Days This Week", intQuizDaysThisWeek + 1);
        }

        if (getDayNumberNew(dateToday) == 7 && !quizSun) {
            editor.putBoolean("Quiz Sun", true);
            editor.putInt("Quiz Days This Week", intQuizDaysThisWeek + 1);
        }

        // Updates the current integer for the day of the week
        editor.putInt("The Day Today", getDayNumberNew(dateToday));
        editor.apply();

        // Lets the user know that they have reached their goal
        // Doesn't show up, might be in the wrong place or something
        if (intDaysGoal - intQuizDaysThisWeek <= 0) {
            textViewGoalReached.setVisibility(View.VISIBLE);
        }

        buttonReturnHome.setOnClickListener(v -> {
            startActivity(new Intent(QuizResults.this, Home.class));
            finish();
        });
    }

    /**
     * Puts in today's date and returns the day of the week as an integer,
     * (i.e. Monday = 1, Tuesday = 2, etc.)
     * @param date  the current date
     * @return      the current day of the week as an integer
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }
}