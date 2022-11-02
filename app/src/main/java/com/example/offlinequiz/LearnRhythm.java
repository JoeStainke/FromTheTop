package com.example.offlinequiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Easy-level learning materials for the rhythm topic.
 * Here, users can view and interact with the learning materials.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class LearnRhythm extends AppCompatActivity {

    private SoundPool soundPool;
    private int soundR1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_rhythm);

        final Button quizRhythm = findViewById(R.id.button_learn_rhythm_to_quiz_rhythm);
        final Button returnHome = findViewById(R.id.button_learn_rhythm_to_home);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        // Designates that the user's device will recognise the audio files as music
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        // Builds a class for SoundPool objects and sets the max streams as 1 so the sounds don't overlap
        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build();

        soundR1 = soundPool.load(this, R.raw.r1, 1);

        // Sets the course as completed and stops all sound from playing when the button is pressed
        quizRhythm.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Course Completed Rhythm", true);
            editor.apply();
            soundPool.autoPause();
            startActivity(new Intent(LearnRhythm.this, QuizRhythm.class));
        });

        // Sets the course as completed and stops all sound from playing when the button is pressed
        returnHome.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Course Completed Rhythm", true);
            editor.apply();
            soundPool.autoPause();
            startActivity(new Intent(LearnRhythm.this, Home.class));
        });
    }

    /**
     *Starts playing the requested sound file.
     *
     * @param v the play button that is pressed by the user
     */
    public void playSound(View v) {
        if (v.getId() == R.id.button_play_rhythm_1) {
            soundPool.play(soundR1, 1, 1, 0, 0, 1);
        }
    }

    /**
     * Stops the sound from playing.
     *
     * @param v the stop button that is pressed by the user
     */
    public void pauseSound(View v) {
        if (v.getId() == R.id.button_pause_rhythm_1) {
            soundPool.autoPause();
        }
    }

    /**
     * Releases the SoundPool resources when the screen is exited.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}