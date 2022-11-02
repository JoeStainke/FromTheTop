package com.example.offlinequiz;

/**
 * The structure and layout for questions in the quiz activity.
 * Questions are then filled in from the QuestionsBank class.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class QuestionsList {

    private final String strQuestion, strOption1, strOption2, strOption3, strOption4, strAnswer;
    private String strUserSelectedAnswer;

    public QuestionsList(String strQuestion, String strOption1, String strOption2,
                         String strOption3, String strOption4, String strAnswer,
                         String strUserSelectedAnswer) {
        this.strQuestion = strQuestion;
        this.strOption1 = strOption1;
        this.strOption2 = strOption2;
        this.strOption3 = strOption3;
        this.strOption4 = strOption4;
        this.strAnswer = strAnswer;
        this.strUserSelectedAnswer = strUserSelectedAnswer;
    }

    public String getStrQuestion() {
        return strQuestion;
    }

    public String getStrOption1() {
        return strOption1;
    }

    public String getStrOption2() {
        return strOption2;
    }

    public String getStrOption3() {
        return strOption3;
    }

    public String getStrOption4() {
        return strOption4;
    }

    public String getStrAnswer() {
        return strAnswer;
    }

    public String getStrUserSelectedAnswer() {
        return strUserSelectedAnswer;
    }

    public void setStrUserSelectedAnswer(String strUserSelectedAnswer) {
        this.strUserSelectedAnswer = strUserSelectedAnswer;
    }
}
