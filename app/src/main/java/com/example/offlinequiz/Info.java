package com.example.offlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The about/info screen.
 * Provides the user with context around learning.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Button buttonHome = findViewById(R.id.button_info_to_home);

        buttonHome.setOnClickListener(v -> openHome());
    }

    /**
     * Method to go to the Home screen.
     */
    public void openHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}