package com.example.offlinequiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.Collections;
import java.util.List;

/**
 * The quiz activity.
 * Here, questions are retrieved from the QuestionsBank class based on the user's chosen topic
 * and difficulty.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestionCount;
    private TextView textViewQuestion;
    private TextView textViewCorrectAnswer;
    private AppCompatButton buttonOption1, buttonOption2, buttonOption3, buttonOption4;
    private AppCompatButton buttonConfirmNext;
    private List<QuestionsList> listQuestions;
    private int intCurrentQuestionPosition = 0;
    private String strSelectedOptionByUser = "";
    private boolean boolAnswered;
    private boolean boolOption1Selected, boolOption2Selected, boolOption3Selected, boolOption4Selected;
    private String strSelectedTopicName = "";
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final TextView textViewSelectedTopicName = findViewById(R.id.text_view_topic_name);

        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewQuestion = findViewById(R.id.text_view_question);

        buttonOption1 = findViewById(R.id.option_1);
        buttonOption2 = findViewById(R.id.option_2);
        buttonOption3 = findViewById(R.id.option_3);
        buttonOption4 = findViewById(R.id.option_4);

        textViewCorrectAnswer = findViewById(R.id.text_view_correct_answer);

        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        // Gets the selected topic and difficulty, then displays it at the top
        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");
        textViewSelectedTopicName.setText((getSelectedTopicName));
        strSelectedTopicName = (getSelectedTopicName);

        // Gets the corresponding question list from the selected topic and difficulty
        listQuestions = QuestionsBank.getQuestions(getSelectedTopicName);

        // Shuffles the question list and returns the first 10
        Collections.shuffle(listQuestions);
        listQuestions = listQuestions.subList(0, 10);

        // Sets the text for the question and answer options
        textViewQuestion.setText(listQuestions.get(0).getStrQuestion());
        buttonOption1.setText(listQuestions.get(0).getStrOption1());
        buttonOption2.setText(listQuestions.get(0).getStrOption2());
        buttonOption3.setText(listQuestions.get(0).getStrOption3());
        buttonOption4.setText(listQuestions.get(0).getStrOption4());

        /* When an option is pressed, its text and background colours are updated to reflect this,
        and each other option is set to its default non-selected colours.
        The Boolean for the selected option is set to true and all others are set to false.
        The text is passed through to be compared with the correct answer text once the user has
        confirmed their answer. */
        buttonOption1.setOnClickListener(v -> {
            buttonOption1.setBackgroundResource(R.drawable.round_back_purple_10);
            buttonOption1.setTextColor(Color.WHITE);
            buttonOption2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption2.setTextColor(Color.parseColor("#1F6BB8"));
            buttonOption3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption3.setTextColor(Color.parseColor("#1F6BB8"));
            buttonOption4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption4.setTextColor(Color.parseColor("#1F6BB8"));
            boolOption1Selected = true;
            boolOption2Selected = false;
            boolOption3Selected = false;
            boolOption4Selected = false;
            strSelectedOptionByUser = buttonOption1.getText().toString();
            listQuestions.get(intCurrentQuestionPosition).setStrUserSelectedAnswer(strSelectedOptionByUser);
        });

        buttonOption2.setOnClickListener(v -> {
            buttonOption1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption1.setTextColor(Color.parseColor("#1F6BB8"));
            buttonOption2.setBackgroundResource(R.drawable.round_back_purple_10);
            buttonOption2.setTextColor(Color.WHITE);
            buttonOption3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption3.setTextColor(Color.parseColor("#1F6BB8"));
            buttonOption4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption4.setTextColor(Color.parseColor("#1F6BB8"));
            boolOption1Selected = false;
            boolOption2Selected = true;
            boolOption3Selected = false;
            boolOption4Selected = false;
            strSelectedOptionByUser = buttonOption2.getText().toString();
            listQuestions.get(intCurrentQuestionPosition).setStrUserSelectedAnswer(strSelectedOptionByUser);
        });

        buttonOption3.setOnClickListener(v -> {
            buttonOption1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption1.setTextColor(Color.parseColor("#1F6BB8"));
            buttonOption2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption2.setTextColor(Color.parseColor("#1F6BB8"));
            buttonOption3.setBackgroundResource(R.drawable.round_back_purple_10);
            buttonOption3.setTextColor(Color.WHITE);
            buttonOption4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption4.setTextColor(Color.parseColor("#1F6BB8"));
            boolOption1Selected = false;
            boolOption2Selected = false;
            boolOption3Selected = true;
            boolOption4Selected = false;
            strSelectedOptionByUser = buttonOption3.getText().toString();
            listQuestions.get(intCurrentQuestionPosition).setStrUserSelectedAnswer(strSelectedOptionByUser);
        });

        buttonOption4.setOnClickListener(v -> {
            buttonOption1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption1.setTextColor(Color.parseColor("#1F6BB8"));
            buttonOption2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption2.setTextColor(Color.parseColor("#1F6BB8"));
            buttonOption3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption3.setTextColor(Color.parseColor("#1F6BB8"));
            buttonOption4.setBackgroundResource(R.drawable.round_back_purple_10);
            buttonOption4.setTextColor(Color.WHITE);
            boolOption1Selected = false;
            boolOption2Selected = false;
            boolOption3Selected = false;
            boolOption4Selected = true;
            strSelectedOptionByUser = buttonOption4.getText().toString();
            listQuestions.get(intCurrentQuestionPosition).setStrUserSelectedAnswer(strSelectedOptionByUser);
        });

        /* If no answer is selected, the system prompts the user to select an answer.
        If an answer is selected, the correct answer is revealed and the button will now load the
        next question when it is pressed again */
        buttonConfirmNext.setOnClickListener(v -> {
            if (!boolAnswered) {
                if (boolOption1Selected || boolOption2Selected || boolOption3Selected || boolOption4Selected) {
                    boolAnswered = true;
                    revealAnswer();
                } else  {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                changeNextQuestion();
            }
        });
    }

    /**
     * A method to load the next question, increase the displayed question number, and reset
     * the Booleans so each option is now unselected and the question is not answered.
     * After answering the final question, the method will load the Quiz Results screen
     * and pass through the necessary data.
     */
    @SuppressLint("SetTextI18n")
    private void changeNextQuestion() {

        intCurrentQuestionPosition++;

        textViewCorrectAnswer.setVisibility(View.INVISIBLE);

        boolAnswered = false;

        boolOption1Selected = false;
        boolOption2Selected = false;
        boolOption3Selected = false;
        boolOption4Selected = false;

        if (intCurrentQuestionPosition < 10) {
            strSelectedOptionByUser = "";

            buttonOption1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption1.setTextColor(Color.parseColor("#1F6BB8"));

            buttonOption2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption2.setTextColor(Color.parseColor("#1F6BB8"));

            buttonOption3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption3.setTextColor(Color.parseColor("#1F6BB8"));

            buttonOption4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            buttonOption4.setTextColor(Color.parseColor("#1F6BB8"));

            textViewQuestionCount.setText((intCurrentQuestionPosition + 1) + "/" + "10");
            textViewQuestion.setText(listQuestions.get(intCurrentQuestionPosition).getStrQuestion());
            buttonOption1.setText(listQuestions.get(intCurrentQuestionPosition).getStrOption1());
            buttonOption2.setText(listQuestions.get(intCurrentQuestionPosition).getStrOption2());
            buttonOption3.setText(listQuestions.get(intCurrentQuestionPosition).getStrOption3());
            buttonOption4.setText(listQuestions.get(intCurrentQuestionPosition).getStrOption4());

            buttonConfirmNext.setText("Confirm");
        } else {

            Intent intent = new Intent(QuizActivity.this, QuizResults.class);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getIncorrectAnswers());
            intent.putExtra("selectedTopic", strSelectedTopicName);
            startActivity(intent);

            finish();
        }
    }

    /**
     * Gets the number of answers the user has answered correctly.
     * @return  the number of answers the user has answered correctly
     */
    private int getCorrectAnswers() {

        int intCorrectAnswers = 0;

        for (int i = 0; i < 10; i++) {

            final String getUserSelectedAnswer = listQuestions.get(i).getStrUserSelectedAnswer();
            final String getAnswer = listQuestions.get(i).getStrAnswer();

            if (getUserSelectedAnswer.equals((getAnswer))) {
                intCorrectAnswers++;
            }
        }

        return intCorrectAnswers;
    }

    /**
     * Gets the number of answers the user has answered incorrectly.
     * @return  the number of answers the user has answered incorrectly.
     */
    private int getIncorrectAnswers() {

        int intIncorrectAnswers = 0;

        for (int i = 0; i < 10; i++) {

            final String getUserSelectedAnswer = listQuestions.get(i).getStrUserSelectedAnswer();
            final String getAnswer = listQuestions.get(i).getStrAnswer();

            if (!getUserSelectedAnswer.equals((getAnswer))) {
                intIncorrectAnswers++;
            }
        }

        return intIncorrectAnswers;
    }

    /**
     * Prevents the user from accidentally exiting the quiz by requiring them to press the back
     * button twice within 2 seconds to quit.
     */
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(this, "Press back again to exit quiz", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    /**
     * Reveals the correct answer by changing its colour to green and displaying some information
     * text below in case it is not obvious from the colours.
     * Also changes the text on the "Confirm" button to "Next" until the final question has
     * been answered, then it changes it to "Finish Quiz"
     */
    @SuppressLint("SetTextI18n")
    private void revealAnswer() {

        final String getAnswer = listQuestions.get(intCurrentQuestionPosition).getStrAnswer();

        if (buttonOption1.getText().toString().equals(getAnswer)) {
            buttonOption1.setBackgroundResource(R.drawable.round_back_green10);
            buttonOption1.setTextColor(Color.WHITE);
            textViewCorrectAnswer.setText("Answer 1 is correct");
        } else if (buttonOption2.getText().toString().equals(getAnswer)) {
            buttonOption2.setBackgroundResource(R.drawable.round_back_green10);
            buttonOption2.setTextColor(Color.WHITE);
            textViewCorrectAnswer.setText("Answer 2 is correct");
        } else if (buttonOption3.getText().toString().equals(getAnswer)) {
            buttonOption3.setBackgroundResource(R.drawable.round_back_green10);
            buttonOption3.setTextColor(Color.WHITE);
            textViewCorrectAnswer.setText("Answer 3 is correct");
        } else if (buttonOption4.getText().toString().equals(getAnswer)) {
            buttonOption4.setBackgroundResource(R.drawable.round_back_green10);
            buttonOption4.setTextColor(Color.WHITE);
            textViewCorrectAnswer.setText("Answer 4 is correct");
        }
        textViewCorrectAnswer.setVisibility(View.VISIBLE);

        if (intCurrentQuestionPosition < 9) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish Quiz");
        }
    }
}