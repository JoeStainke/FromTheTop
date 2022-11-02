package com.example.offlinequiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

/**
 * The welcome screen.
 * On first launch, it will lead to the setup activities.
 * On subsequent launches (if setup is completed), it will lead to the home screen.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        // Creates a Boolean to keep track of whether or not the intro has been completed
        boolean boolIntroCompleted = sharedPreferences.getBoolean("Intro Completed", false);

        // Gets a calendar based on the user's time zone
        Calendar calendar = Calendar.getInstance();

        // Gets the week number (from 1-53) from when the user last took a quiz
        int intLastQuizWeek = sharedPreferences.getInt("Quiz Week", 0);

        // Gets the current week number (from 1-53)
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

        /* Sends the user to the Set Name screen if the intro has not been completed
        or the Home screen if the intro has been completed.
         */
        Button buttonContinue = (Button) findViewById(R.id.button_main_to_home);
        if (!boolIntroCompleted) {
            buttonContinue.setOnClickListener(v -> openSetName());
        } else {
            buttonContinue.setOnClickListener(v -> openHome());
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();

        /* Checks if the current week matches the week when the user last completed a quiz.
        If they do not match (i.e. it is a new week),
        all progress to towards their weekly goal is reset */
        if (weekOfYear != intLastQuizWeek) {
            editor.putInt("Quiz Days This Week", 0);
            editor.putBoolean("Quiz Mon", false);
            editor.putBoolean("Quiz Tue", false);
            editor.putBoolean("Quiz Wed", false);
            editor.putBoolean("Quiz Thu", false);
            editor.putBoolean("Quiz Fri", false);
            editor.putBoolean("Quiz Sat", false);
            editor.putBoolean("Quiz Sun", false);
            editor.apply();
        }
    }
    // method to go to set name page
    public void openSetName() {
        Intent intent = new Intent(this, SetName.class);
        startActivity(intent);
    }

    // method to go to home page
    public void openHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }
}