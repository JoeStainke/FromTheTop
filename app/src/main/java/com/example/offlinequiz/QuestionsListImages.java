package com.example.offlinequiz;

import android.media.Image;

/**
 * The structure and layout for image-based questions in the quiz activity.
 * Questions are then filled in from the QuestionsBank class.
 *
 * Not currently used.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class QuestionsListImages {

    private final Image imgQuestion;
    private final String strOption1, strOption2, strOption3, strOption4, strAnswer;
    private String strUserSelectedAnswer;

    public QuestionsListImages(Image imgQuestion, String strOption1, String strOption2,
                         String strOption3, String strOption4, String strAnswer,
                         String strUserSelectedAnswer) {
        this.imgQuestion = imgQuestion;
        this.strOption1 = strOption1;
        this.strOption2 = strOption2;
        this.strOption3 = strOption3;
        this.strOption4 = strOption4;
        this.strAnswer = strAnswer;
        this.strUserSelectedAnswer = strUserSelectedAnswer;
    }

    public Image getImgQuestion() {
        return imgQuestion;
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
