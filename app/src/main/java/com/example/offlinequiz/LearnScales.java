package com.example.offlinequiz;

import android.annotation.SuppressLint;
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
 * Easy-level learning materials for the scales topic.
 * Here, users can view and interact with the learning materials.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class LearnScales extends AppCompatActivity {

    private SoundPool soundPool;
    private int soundS1, soundS2, soundS4, soundS5, soundS6, soundS7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_scales);

        final Button quizScales = findViewById(R.id.button_learn_scales_to_quiz_scales);
        final Button returnHome = findViewById(R.id.button_learn_scales_to_home);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        // Designates that the user's device will recognise the audio files as music
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        // Builds a class for SoundPool objects and sets the max streams as 1 so the sounds don't overlap
        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build();

        // Sound 3 is deliberately the same as sound 2
        soundS1 = soundPool.load(this, R.raw.s1, 1);
        soundS2 = soundPool.load(this, R.raw.s2, 1);
        int soundS3 = soundPool.load(this, R.raw.s2, 1);
        soundS4 = soundPool.load(this, R.raw.s4, 1);
        soundS5 = soundPool.load(this, R.raw.s5, 1);
        soundS6 = soundPool.load(this, R.raw.s6, 1);
        soundS7 = soundPool.load(this, R.raw.s7, 1);

        // Sets the course as completed and stops all sound from playing when the button is pressed
        quizScales.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Course Completed Scales", true);
            editor.apply();
            soundPool.autoPause();
            startActivity(new Intent(LearnScales.this, QuizScales.class));
        });

        // Sets the course as completed and stops all sound from playing when the button is pressed
        returnHome.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Course Completed Scales", true);
            editor.apply();
            soundPool.autoPause();
            startActivity(new Intent(LearnScales.this, Home.class));
        });
    }

    /**
     * Starts playing the requested sound file.
     * @param v the play button that is pressed by the user
     */
    @SuppressLint("NonConstantResourceId")
    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.button_play_scales_1:
                soundPool.play(soundS1, 1, 1, 0, 0, 1);
                break;
            case R.id.button_play_scales_2:
                soundPool.play(soundS2, 1, 1, 0, 0, 1);
                break;
            case R.id.button_play_scales_3:
                soundPool.play(soundS2, 1, 1, 0, 0, 1);
                break;
            case R.id.button_play_scales_4:
                soundPool.play(soundS4, 1, 1, 0, 0, 1);
                break;
            case R.id.button_play_scales_5:
                soundPool.play(soundS5, 1, 1, 0, 0, 1);
                break;
            case R.id.button_play_scales_6:
                soundPool.play(soundS6, 1, 1, 0, 0, 1);
                break;
            case R.id.button_play_scales_7:
                soundPool.play(soundS7, 1, 1, 0, 0, 1);
                break;
        }
    }

    /**
     * Stops all sounds from playing.
     *
     * @param v the stop button that is pressed by the user
     */
    @SuppressLint("NonConstantResourceId")
    public void pauseSound(View v) {
        switch (v.getId()) {
            case R.id.button_pause_scales_1:
                soundPool.autoPause();
            case R.id.button_pause_scales_2:
                soundPool.autoPause();
            case R.id.button_pause_scales_3:
                soundPool.autoPause();
            case R.id.button_pause_scales_4:
                soundPool.autoPause();
            case R.id.button_pause_scales_5:
                soundPool.autoPause();
            case R.id.button_pause_scales_6:
                soundPool.autoPause();
            case R.id.button_pause_scales_7:
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