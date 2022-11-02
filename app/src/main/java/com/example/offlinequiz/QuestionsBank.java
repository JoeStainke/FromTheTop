package com.example.offlinequiz;

import java.util.ArrayList;
import java.util.List;

/**
 * The bank of questions to be used in the quiz activity.
 * Questions from the user's chosen topic and difficulty are added to the questions list
 * when a quiz is started.
 *
 * @author Joe Stainke
 * @version 1.0
 */

public class QuestionsBank {

    private static List<QuestionsList> listQuestionsRhythmEasy() {

        final List<QuestionsList> listQuestions = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("How many beats does a semibreve last?", "One", "Two", "Three", "Four", "Four", "");
        final QuestionsList question2 = new QuestionsList("How many beats does a minim last?", "One", "Two", "Three", "Four", "Two", "");
        final QuestionsList question3 = new QuestionsList("How many beats does a crotchet last?", "One", "Two", "Three", "Four", "One", "");
        final QuestionsList question4 = new QuestionsList("How many beats does a quaver last?", "A quarter", "A half", "One", "Two", "A half", "");
        final QuestionsList question5 = new QuestionsList("How many beats does a semiquaver last?", "An eighth", "A quarter", "A half", "One", "A quarter", "");
        final QuestionsList question6 = new QuestionsList("How many beats does a demisemiquaver last?", "An eighth", "A quarter", "A half", "One", "An eighth", "");
        final QuestionsList question7 = new QuestionsList("What effect does a dot after a note or a rest have?", "Doubles the length", "Halves the length", "Increases the length by 50%", "Increases the length by 75%", "Increases the length by 50%", "");
        final QuestionsList question8 = new QuestionsList("For how many beats does a dotted minim last?", "2", "3", "4", "6", "3", "");
        final QuestionsList question9 = new QuestionsList("How many quavers can fit into a bar of 3/4?", "2", "3", "4", "6", "6", "");
        final QuestionsList question10 = new QuestionsList("For how many beats does a dotted semibreve last?", "2", "4", "6", "8", "6", "");
        final QuestionsList question11 = new QuestionsList("What time signature might you be in if a bar consists of two crotchets and a minim?", "2/4", "3/4", "4/4", "6/8", "4/4", "");
        final QuestionsList question12 = new QuestionsList("What time signature might you be in if a bar consists of a quaver and a crotchet?", "2/4", "3/8", "3/4", "6/8", "3/8", "");

        listQuestions.add(question1);
        listQuestions.add(question2);
        listQuestions.add(question3);
        listQuestions.add(question4);
        listQuestions.add(question5);
        listQuestions.add(question6);
        listQuestions.add(question7);
        listQuestions.add(question8);
        listQuestions.add(question9);
        listQuestions.add(question10);
        listQuestions.add(question11);
        listQuestions.add(question12);

        return listQuestions;
    }

    private static List<QuestionsList> listQuestionsRhythmMedium() {

        final List<QuestionsList> listQuestions = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Rhythm Medium: Answer is 1", "1", "2", "3", "4", "1", "");
        final QuestionsList question2 = new QuestionsList("Rhythm Medium: Answer is 2", "1", "2", "3", "4", "2", "");
        final QuestionsList question3 = new QuestionsList("Rhythm Medium: Answer is 3", "1", "2", "3", "4", "3", "");
        final QuestionsList question4 = new QuestionsList("Rhythm Medium: Answer is 4", "1", "2", "3", "4", "4", "");
        final QuestionsList question5 = new QuestionsList("Rhythm Medium: Answer is 0", "1", "2", "3", "0", "0", "");
        final QuestionsList question6 = new QuestionsList("Rhythm Medium: Answer is 9", "1", "9", "3", "4", "9", "");
        final QuestionsList question7 = new QuestionsList("Rhythm Medium: Answer is 1", "1", "2", "3", "4", "1", "");
        final QuestionsList question8 = new QuestionsList("Rhythm Medium: Answer is 2", "1", "2", "3", "4", "2", "");
        final QuestionsList question9 = new QuestionsList("Rhythm Medium: Answer is 3", "1", "2", "3", "4", "3", "");
        final QuestionsList question10 = new QuestionsList("Rhythm Medium: Answer is 4", "1", "2", "3", "4", "4", "");
        final QuestionsList question11 = new QuestionsList("Rhythm Medium: Answer is 0", "1", "2", "3", "0", "0", "");
        final QuestionsList question12 = new QuestionsList("Rhythm Medium: Answer is 9", "1", "9", "3", "4", "9", "");

        listQuestions.add(question1);
        listQuestions.add(question2);
        listQuestions.add(question3);
        listQuestions.add(question4);
        listQuestions.add(question5);
        listQuestions.add(question6);
        listQuestions.add(question7);
        listQuestions.add(question8);
        listQuestions.add(question9);
        listQuestions.add(question10);
        listQuestions.add(question11);
        listQuestions.add(question12);

        return listQuestions;
    }

    private static List<QuestionsList> listQuestionsRhythmHard() {

        final List<QuestionsList> listQuestions = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Rhythm Hard: Answer is 1", "1", "2", "3", "4", "1", "");
        final QuestionsList question2 = new QuestionsList("Rhythm Hard: Answer is 2", "1", "2", "3", "4", "2", "");
        final QuestionsList question3 = new QuestionsList("Rhythm Hard: Answer is 3", "1", "2", "3", "4", "3", "");
        final QuestionsList question4 = new QuestionsList("Rhythm Hard: Answer is 4", "1", "2", "3", "4", "4", "");
        final QuestionsList question5 = new QuestionsList("Rhythm Hard: Answer is 0", "1", "2", "3", "0", "0", "");
        final QuestionsList question6 = new QuestionsList("Rhythm Hard: Answer is 9", "1", "9", "3", "4", "9", "");
        final QuestionsList question7 = new QuestionsList("Rhythm Hard: Answer is 1", "1", "2", "3", "4", "1", "");
        final QuestionsList question8 = new QuestionsList("Rhythm Hard: Answer is 2", "1", "2", "3", "4", "2", "");
        final QuestionsList question9 = new QuestionsList("Rhythm Hard: Answer is 3", "1", "2", "3", "4", "3", "");
        final QuestionsList question10 = new QuestionsList("Rhythm Hard: Answer is 4", "1", "2", "3", "4", "4", "");
        final QuestionsList question11 = new QuestionsList("Rhythm Hard: Answer is 0", "1", "2", "3", "0", "0", "");
        final QuestionsList question12 = new QuestionsList("Rhythm Hard: Answer is 9", "1", "9", "3", "4", "9", "");

        listQuestions.add(question1);
        listQuestions.add(question2);
        listQuestions.add(question3);
        listQuestions.add(question4);
        listQuestions.add(question5);
        listQuestions.add(question6);
        listQuestions.add(question7);
        listQuestions.add(question8);
        listQuestions.add(question9);
        listQuestions.add(question10);
        listQuestions.add(question11);
        listQuestions.add(question12);

        return listQuestions;
    }

    private static List<QuestionsList> listQuestionsScalesEasy() {

        final List<QuestionsList> listQuestions = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("What scale consists entirely of half steps?", "Major", "Melodic Minor", "Harmonic Minor", "Chromatic", "Chromatic", "");
        final QuestionsList question2 = new QuestionsList("What notes are sharpened in the D major scale?", "C & F", "E & G", "A & C", "C & G", "C & F", "");
        final QuestionsList question3 = new QuestionsList("What is the only major scale with no flats or sharps?", "G", "C", "F", "D", "C", "");
        final QuestionsList question4 = new QuestionsList("What is the final interval between the preceding note and repeating the tonic at the top of the major scale?", "Half Step", "Whole Step", "Two Step", "No Steps", "Half Step", "");
        final QuestionsList question5 = new QuestionsList("What is the interval between the first and second step in the major scale?", "Half Step", "Whole Step", "Two Step", "No Steps", "Whole Step", "");
        final QuestionsList question6 = new QuestionsList("Which one of these is NOT a form of the minor scale?", "Harmonic", "Natural", "Melodic", "Original", "Original", "");
        final QuestionsList question7 = new QuestionsList("What do all forms of the minor scale have in common?", "They have at least one flat and one sharp", "The first interval is a half step", "The third note is flattened", "They use the same notes when ascending and descending", "The third note is flattened", "");
        final QuestionsList question8 = new QuestionsList("The natural minor scale is based on which mode?", "Ionian", "Aeolian", "Dorian", "Phrygian", "Aeolian", "");
        final QuestionsList question9 = new QuestionsList("What is the fifth note in the D major scale?", "D", "F#", "A", "E", "A", "");
        final QuestionsList question10 = new QuestionsList("What is the first and last note of the major scale known as?", "The tonic", "The supertonic", "The diatonic", "The chronic", "The tonic", "");
        final QuestionsList question11 = new QuestionsList("What makes the melodic minor unique?", "It is different on the way back down than it is on the way up", "The third note is flattened", "It is based on a mode", "It contains all twelve notes", "It is different on the way back down than it is on the way up", "");
        final QuestionsList question12 = new QuestionsList("What is applied to the 7th note of the harmonic minor scale to raise it by a semitone?", "A mistake", "An accidental", "A flat", "A correction", "An accidental", "");

        listQuestions.add(question1);
        listQuestions.add(question2);
        listQuestions.add(question3);
        listQuestions.add(question4);
        listQuestions.add(question5);
        listQuestions.add(question6);
        listQuestions.add(question7);
        listQuestions.add(question8);
        listQuestions.add(question9);
        listQuestions.add(question10);
        listQuestions.add(question11);
        listQuestions.add(question12);

        return listQuestions;
    }

    private static List<QuestionsList> listQuestionsScalesMedium() {

        final List<QuestionsList> listQuestions = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Scales: Answer is 1", "1", "2", "3", "4", "1", "");
        final QuestionsList question2 = new QuestionsList("Scales: Answer is 2", "1", "2", "3", "4", "2", "");
        final QuestionsList question3 = new QuestionsList("Scales: Answer is 3", "1", "2", "3", "4", "3", "");
        final QuestionsList question4 = new QuestionsList("Scales: Answer is 4", "1", "2", "3", "4", "4", "");
        final QuestionsList question5 = new QuestionsList("Scales: Answer is 0", "1", "2", "3", "0", "0", "");
        final QuestionsList question6 = new QuestionsList("Scales: Answer is 9", "1", "9", "3", "4", "9", "");
        final QuestionsList question7 = new QuestionsList("Scales: Answer is 1", "1", "2", "3", "4", "1", "");
        final QuestionsList question8 = new QuestionsList("Scales: Answer is 2", "1", "2", "3", "4", "2", "");
        final QuestionsList question9 = new QuestionsList("Scales: Answer is 3", "1", "2", "3", "4", "3", "");
        final QuestionsList question10 = new QuestionsList("Scales: Answer is 4", "1", "2", "3", "4", "4", "");
        final QuestionsList question11 = new QuestionsList("Scales: Answer is 0", "1", "2", "3", "0", "0", "");
        final QuestionsList question12 = new QuestionsList("Scales: Answer is 9", "1", "9", "3", "4", "9", "");

        listQuestions.add(question1);
        listQuestions.add(question2);
        listQuestions.add(question3);
        listQuestions.add(question4);
        listQuestions.add(question5);
        listQuestions.add(question6);
        listQuestions.add(question7);
        listQuestions.add(question8);
        listQuestions.add(question9);
        listQuestions.add(question10);
        listQuestions.add(question11);
        listQuestions.add(question12);

        return listQuestions;
    }

    private static List<QuestionsList> listQuestionsScalesHard() {

        final List<QuestionsList> listQuestions = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Scales: Answer is 1", "1", "2", "3", "4", "1", "");
        final QuestionsList question2 = new QuestionsList("Scales: Answer is 2", "1", "2", "3", "4", "2", "");
        final QuestionsList question3 = new QuestionsList("Scales: Answer is 3", "1", "2", "3", "4", "3", "");
        final QuestionsList question4 = new QuestionsList("Scales: Answer is 4", "1", "2", "3", "4", "4", "");
        final QuestionsList question5 = new QuestionsList("Scales: Answer is 0", "1", "2", "3", "0", "0", "");
        final QuestionsList question6 = new QuestionsList("Scales: Answer is 9", "1", "9", "3", "4", "9", "");
        final QuestionsList question7 = new QuestionsList("Scales: Answer is 1", "1", "2", "3", "4", "1", "");
        final QuestionsList question8 = new QuestionsList("Scales: Answer is 2", "1", "2", "3", "4", "2", "");
        final QuestionsList question9 = new QuestionsList("Scales: Answer is 3", "1", "2", "3", "4", "3", "");
        final QuestionsList question10 = new QuestionsList("Scales: Answer is 4", "1", "2", "3", "4", "4", "");
        final QuestionsList question11 = new QuestionsList("Scales: Answer is 0", "1", "2", "3", "0", "0", "");
        final QuestionsList question12 = new QuestionsList("Scales: Answer is 9", "1", "9", "3", "4", "9", "");

        listQuestions.add(question1);
        listQuestions.add(question2);
        listQuestions.add(question3);
        listQuestions.add(question4);
        listQuestions.add(question5);
        listQuestions.add(question6);
        listQuestions.add(question7);
        listQuestions.add(question8);
        listQuestions.add(question9);
        listQuestions.add(question10);
        listQuestions.add(question11);
        listQuestions.add(question12);

        return listQuestions;
    }

    // Returns a list of all questions (not currently used)
    private static List<QuestionsList> listAllQuestions() {
        return new ArrayList<>();
    }

    // Checks the topic and difficulty the user has requested and returns the corresponding questions list
    public static List<QuestionsList> getQuestions(String strSelectedTopicName) {
        switch (strSelectedTopicName) {
            case "Rhythm - Easy":
                return listQuestionsRhythmEasy();
            case "Rhythm - Medium":
                return listQuestionsRhythmMedium();
            case "Rhythm - Hard":
                return listQuestionsRhythmHard();
            case "Scales - Easy":
                return listQuestionsScalesEasy();
            case "Scales - Medium":
                return listQuestionsScalesMedium();
            case "Scales - Hard":
                return listQuestionsScalesHard();
            default:
                return listAllQuestions();
        }
    }
}
