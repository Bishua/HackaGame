package com.example.bishua.hackagame.models;

import java.io.Serializable;

/**
 * Created by BishUA on 13.09.2014.
 */
public class Quiz implements Serializable {
    private Question question;
    private Answer firstAnswer;
    private Answer secondAnswer;
    private Answer thirdAnswer;
    private Answer fourthAnswer;
    private int rightAnswer;

    public Quiz(Question question, Answer answer1, Answer answer2, Answer answer3, Answer answer4, int rightAnswer){
        this.question = question;
        this.firstAnswer = answer1;
        this.secondAnswer = answer2;
        this.thirdAnswer = answer3;
        this.fourthAnswer = answer4;
        this.rightAnswer= rightAnswer;
    }

    public Quiz(){}

    public Answer getFourthAnswer() {
        return fourthAnswer;
    }

    public void setFourthAnswer(Answer fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(Answer firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public Answer getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(Answer secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public Answer getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(Answer thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

}
