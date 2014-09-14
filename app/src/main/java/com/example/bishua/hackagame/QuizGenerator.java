package com.example.bishua.hackagame;

import com.example.bishua.hackagame.models.Answer;
import com.example.bishua.hackagame.models.Question;
import com.example.bishua.hackagame.models.Quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BishUA on 14.09.2014.
 */
public class QuizGenerator {
    List<Quiz> quizList = new ArrayList<Quiz>();
    int i =0;
    public QuizGenerator(){
        for(int i = 0; i<10; i++) {
            Quiz quiz = new Quiz();
            Answer answer1 = new Answer();
            answer1.setText("one");
            Answer answer2 = new Answer();
            answer2.setText("two");
            Answer answer3 = new Answer();
            answer3.setText("three");
            Answer answer4 = new Answer();
            answer4.setText("four");
            Question question = new Question();
            question.setText("question " +i);
            quiz.setFirstAnswer(answer1);
            quiz.setSecondAnswer(answer2);
            quiz.setThirdAnswer(answer3);
            quiz.setFourthAnswer(answer4);
            quiz.setQuestion(question);
            quiz.setRightAnswer(1);
            quizList.add(quiz);
        }
    }
    public Quiz getNext(){

        return quizList.get(i++);
    }

}
