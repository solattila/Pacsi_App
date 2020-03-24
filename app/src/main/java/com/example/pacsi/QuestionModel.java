package com.example.pacsi;

import android.widget.ImageView;

public class QuestionModel {

    private int mQuestion;
    private int mAnswer1;
    private boolean mAnswerBool1;
    private int mAnswer2;
    private boolean mAnswerBool2;
    private int mAnswer3;
    private boolean mAnswerBool3;
    private int mAnswer4;
    private boolean mAnswerBool4;
    private int mQuestionImage;

    public QuestionModel(int question, int answer1, boolean answerBool1, int answer2, boolean answerBool2,
                         int answer3, boolean answerBool3, int answer4, boolean answerBool4, int questionImage) {
        mQuestion = question;
        mAnswer1 = answer1;
        mAnswerBool1 = answerBool1;
        mAnswer2 = answer2;
        mAnswerBool2 = answerBool2;
        mAnswer3 = answer3;
        mAnswerBool3 = answerBool3;
        mAnswer4 = answer4;
        mAnswerBool4 = answerBool4;
        mQuestionImage = questionImage;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public int getAnswer1() {
        return mAnswer1;
    }

    public void setAnswer1(int answer1) {
        mAnswer1 = answer1;
    }

    public boolean isAnswerBool1() {
        return mAnswerBool1;
    }

    public void setAnswerBool1(boolean answerBool1) {
        mAnswerBool1 = answerBool1;
    }

    public int getAnswer2() {
        return mAnswer2;
    }

    public void setAnswer2(int answer2) {
        mAnswer2 = answer2;
    }

    public boolean isAnswerBool2() {
        return mAnswerBool2;
    }

    public void setAnswerBool2(boolean answerBool2) {
        mAnswerBool2 = answerBool2;
    }

    public int getAnswer3() {
        return mAnswer3;
    }

    public void setAnswer3(int answer3) {
        mAnswer3 = answer3;
    }

    public boolean isAnswerBool3() {
        return mAnswerBool3;
    }

    public void setAnswerBool3(boolean answerBool3) {
        mAnswerBool3 = answerBool3;
    }

    public int getAnswer4() {
        return mAnswer4;
    }

    public void setAnswer4(int answer4) {
        mAnswer4 = answer4;
    }

    public boolean isAnswerBool4() {
        return mAnswerBool4;
    }

    public void setAnswerBool4(boolean answerBool4) {
        mAnswerBool4 = answerBool4;
    }

    public int getQuestionImage() {
        return mQuestionImage;
    }

    public void setQuestionImage(int questionImage) {
        mQuestionImage = questionImage;
    }
}
