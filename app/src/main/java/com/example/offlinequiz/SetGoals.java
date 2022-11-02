package com.example.offlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The screen where the user can select how many days per week they would like to take a quiz.
 * This sets the user's weekly goal.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class SetGoals extends AppCompatActivity {

    private Button buttonContinue2;
    private SharedPreferences sharedPreferences;
    private NumberPicker numberPicker;
    private TextView textViewSetDays;
    private int intDaysGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goals);

        buttonContinue2 = (Button) findViewById(R.id.button_set_goals_to_info);
        Button buttonConfirmDays = (Button) findViewById(R.id.button_confirm_days);
        numberPicker = (NumberPicker) findViewById(R.id.number_picker_set_goals);
        textViewSetDays = (TextView) findViewById(R.id.text_view_set_days);

        // Sets the range of the number picker to correspond with the days of the week
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(7);
        textViewSetDays.setText(String.format("%s day per week", numberPicker.getValue()));

        // Sets the text next to the number picker
        numberPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
            if (numberPicker.getValue() == 1) {
                textViewSetDays.setText(String.format("%s day per week", newVal));
            }
            else {
                textViewSetDays.setText(String.format("%s days per week", newVal));
            }
        });

        sharedPreferences = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        // Sets the user's goal of quiz days per week and makes the continue button visible
        buttonConfirmDays.setOnClickListener(view -> {

            intDaysGoal = numberPicker.getValue();
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putInt("Days Goal", intDaysGoal);
            editor.apply();

            Toast.makeText(SetGoals.this, "Goal set!", Toast.LENGTH_SHORT).show();
            buttonContinue2.setVisibility(View.VISIBLE);
            });

        /* Sets the Boolean for completing the intro as true so the Continue button on the Welcome
        screen goes straight to the home screen instead of the intro/setup screens again */
        buttonContinue2.setOnClickListener(view -> {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Intro Completed", true);
            editor.apply();

            openInfo();
        });
    }

    /**
     * Method to go to the Info screen.
     */
    public void openInfo() {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }
}