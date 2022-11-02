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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * The home screen.
 * From here, users can access all key sections of the app,
 * as well as view progress towards their daily quiz goal.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class Home extends AppCompatActivity {

    private long backPressedTime;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textViewNameHome = findViewById(R.id.text_view_name_home);
        TextView textViewHomeQuizDays = findViewById(R.id.text_view_home_quiz_days);
        TextView textViewHomeQuizMessage = findViewById(R.id.text_view_home_quiz_message);
        ImageView imageViewDay1Yes = findViewById(R.id.image_view_day_1_yes);
        ImageView imageViewDay2Yes = findViewById(R.id.image_view_day_2_yes);
        ImageView imageViewDay3Yes = findViewById(R.id.image_view_day_3_yes);
        ImageView imageViewDay4Yes = findViewById(R.id.image_view_day_4_yes);
        ImageView imageViewDay5Yes = findViewById(R.id.image_view_day_5_yes);
        ImageView imageViewDay6Yes = findViewById(R.id.image_view_day_6_yes);
        ImageView imageViewDay7Yes = findViewById(R.id.image_view_day_7_yes);
        ImageView imageViewDay1No = findViewById(R.id.image_view_day_1_no);
        ImageView imageViewDay2No = findViewById(R.id.image_view_day_2_no);
        ImageView imageViewDay3No = findViewById(R.id.image_view_day_3_no);
        ImageView imageViewDay4No = findViewById(R.id.image_view_day_4_no);
        ImageView imageViewDay5No = findViewById(R.id.image_view_day_5_no);
        ImageView imageViewDay6No = findViewById(R.id.image_view_day_6_no);

        ImageButton imageButtonInfo = findViewById(R.id.image_button_home_to_info);
        imageButtonInfo.setOnClickListener(v -> openInfo());

        Button buttonTopics = findViewById(R.id.button_home_to_topics);
        buttonTopics.setOnClickListener(v -> openTopics());

        Button buttonQuiz = findViewById(R.id.button_home_to_quiz_select);
        buttonQuiz.setOnClickListener(v -> openQuiz());

        Button buttonStats = findViewById(R.id.button_home_to_stats);
        buttonStats.setOnClickListener(v -> openStats());

        Button imageButtonSettings = findViewById(R.id.button_home_to_settings);
        imageButtonSettings.setOnClickListener(v -> openSettings());

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        // Gets the username entered by the user
        String strUsername = sharedPreferences.getString("username", "");

        textViewNameHome.setText("Hello, " + strUsername);

        // Gets the user's weekly quiz days goal
        int intDaysGoal = sharedPreferences.getInt("Days Goal", 0);

        // Gets the number of days the user has taken a quiz this week
        int intQuizDaysThisWeek = sharedPreferences.getInt("Quiz Days This Week", 0);


        // Gets whether or not the user has taken a quiz on each respective day
        boolean boolQuizMon = sharedPreferences.getBoolean("Quiz Mon", false);
        boolean boolQuizTue = sharedPreferences.getBoolean("Quiz Tue", false);
        boolean boolQuizWed = sharedPreferences.getBoolean("Quiz Wed", false);
        boolean boolQuizThu = sharedPreferences.getBoolean("Quiz Thu", false);
        boolean boolQuizFri = sharedPreferences.getBoolean("Quiz Fri", false);
        boolean boolQuizSat = sharedPreferences.getBoolean("Quiz Sat", false);
        boolean boolQuizSun = sharedPreferences.getBoolean("Quiz Sun", false);

        // Tells the user how many days they've taken a quiz this week
        if (intQuizDaysThisWeek == 1) {
            textViewHomeQuizDays.setText("You've taken a quiz on " + intQuizDaysThisWeek + " day this week.");
        } else {
            textViewHomeQuizDays.setText("You've taken a quiz on " + intQuizDaysThisWeek + " days this week.");
        }

        // Tells the user how many days they are away from reaching their goal, or if they've reached it
        if (intDaysGoal - intQuizDaysThisWeek == 1) {
            textViewHomeQuizMessage.setText((intDaysGoal - intQuizDaysThisWeek) + " more day to reach your goal.");
        } else if (intDaysGoal - intQuizDaysThisWeek > 1) {
            textViewHomeQuizMessage.setText((intDaysGoal - intQuizDaysThisWeek) + " more days to reach your goal.");
        } else {
            textViewHomeQuizMessage.setText("Congratulations! You've reached your goal!");
        }

        // Gets the current date
        LocalDate dateToday = LocalDate.now();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        /* Checks if any days of the week have passed without the user taking a quiz,
        then makes the circle red for each one */
        if (getDayNumberNew(dateToday) > 1 && !boolQuizMon) {
            imageViewDay1No.setVisibility(View.VISIBLE);
        }
        if (getDayNumberNew(dateToday) > 2 && !boolQuizTue) {
            imageViewDay2No.setVisibility(View.VISIBLE);
        }
        if (getDayNumberNew(dateToday) > 3 && !boolQuizWed) {
            imageViewDay3No.setVisibility(View.VISIBLE);
        }
        if (getDayNumberNew(dateToday) > 4 && !boolQuizThu) {
            imageViewDay4No.setVisibility(View.VISIBLE);
        }
        if (getDayNumberNew(dateToday) > 5 && !boolQuizFri) {
            imageViewDay5No.setVisibility(View.VISIBLE);
        }
        if (getDayNumberNew(dateToday) > 6 && !boolQuizSat) {
            imageViewDay6No.setVisibility(View.VISIBLE);
        }

        /* Checks if the user has taken a quiz for each respective day, then makes the circle green
        for each day they have */
        if (boolQuizMon) {
            imageViewDay1Yes.setVisibility(View.VISIBLE);
        }
        if (boolQuizTue) {
            imageViewDay2Yes.setVisibility(View.VISIBLE);
        }
        if (boolQuizWed) {
            imageViewDay3Yes.setVisibility(View.VISIBLE);
        }
        if (boolQuizThu) {
            imageViewDay4Yes.setVisibility(View.VISIBLE);
        }
        if (boolQuizFri) {
            imageViewDay5Yes.setVisibility(View.VISIBLE);
        }
        if (boolQuizSat) {
            imageViewDay6Yes.setVisibility(View.VISIBLE);
        }
        if (boolQuizSun) {
            imageViewDay7Yes.setVisibility(View.VISIBLE);
        }

        editor.apply();
    }

    /**
     * Method to go to the Info/About screen.
     */
    public void openInfo() {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }

    /**
     * Method to go to the Topics screen.
     */
    public void openTopics() {
        Intent intent = new Intent(this, Topics.class);
        startActivity(intent);
    }

    /**
     * Method to go to the Quiz Select screen.
     */
    public void openQuiz() {
        Intent intent = new Intent(this, QuizSelect.class);
        startActivity(intent);
    }

    /**
     * Method to go to the Stats screen.
     */
    public void openStats() {
        Intent intent = new Intent(this, Stats.class);
        startActivity(intent);
    }

    /**
     * Method to go to the through the Set Name and Set Goals screens again.
     */
    public void openSettings() {
        Intent intent = new Intent(this, SetName.class);
        startActivity(intent);
    }

    /**
     * Method to go to the Welcome screen.
     * Currently no longer used.
     */
    public void openMain() {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        finish();
    }

    /**
     * Takes the current date and returns the day of the week as an integer
     * (ie. Monday = 1, Tuesday = 2, etc.).
     *
     * @param date  the current date
     * @return      the current day of the week as an integer
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }

    /**
     * Makes sure there is an "end point" so the user does not end up going back through their
     * entire screen history.
     * Allows the user to exit the app while preventing them from doing so accidentally.
     */
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit app", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}