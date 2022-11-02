package com.example.offlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

/**
 * The screen where the user can set their name to be shown elsewhere in the app.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class SetName extends AppCompatActivity {

    private Button buttonContinue;
    private EditText editTextUsername;
    private SharedPreferences sharedPreferences;
    private String strUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_name);

        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        Button buttonSetName = (Button) findViewById(R.id.button_set_name);
        buttonContinue = (Button) findViewById(R.id.button_set_name_to_set_goals);

        sharedPreferences = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        /* Sets the user's name to the text they have entered, stripping any surrounding whitespace,
        and makes the Continue button visible.
        If the user has not entered anything, it will prompt them to before they are allowed
        to continue */
        buttonSetName.setOnClickListener(view -> {
            strUsername = editTextUsername.getText().toString().trim();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", strUsername);
            editor.apply();

            if (Objects.equals(strUsername, "")) {
                Toast.makeText(SetName.this, "Please enter a username", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SetName.this, "Username set. Hello, " + strUsername + "!", Toast.LENGTH_SHORT).show();
                buttonContinue.setVisibility(View.VISIBLE);
            }
        });

        buttonContinue.setOnClickListener(view -> openSetGoals());
    }

    /**
     * Method to open the Set Goals screen.
     * Prevents the user from being able to continue if they have re-set their name to an empty
     * string
     */
    public void openSetGoals() {
        Intent intent = new Intent(this, SetGoals.class);
        if (Objects.equals(strUsername, "")) {
            Toast.makeText(SetName.this, "Please set a username (nice try!)", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(intent);
        }
    }
}