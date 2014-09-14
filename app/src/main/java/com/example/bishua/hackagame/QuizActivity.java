package com.example.bishua.hackagame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bishua.hackagame.models.Answer;
import com.example.bishua.hackagame.models.Question;
import com.example.bishua.hackagame.models.Quiz;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuizActivity extends ActionBarActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private int rightAnswer;
    private TextView textView;
    private int questionCount = 0;
    private int rightQuestionCount = 0;
    private Quiz quiz;
    private List<Quiz> list = new ArrayList<Quiz>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        button1 = (Button) findViewById(R.id.button1);

        button2 = (Button) findViewById(R.id.button2);

        button3 = (Button) findViewById(R.id.button3);

        button4 = (Button) findViewById(R.id.button4);

        textView = (TextView) findViewById(R.id.textView);

//        quiz = quizGenerator.getNext();
        getQuizes();
        Quiz quiz1 = list.get(0);
        initControls(quiz1);


    }


    public void buttonAction(View view) {
        int answer = 0;
        switch (view.getId()) {
            case R.id.button1:
                answer = 1;
                break;
            case R.id.button2:
                answer = 2;
                break;
            case R.id.button3:
                answer = 3;
                break;
            case R.id.button4:
                answer = 4;
                break;
        }
        String massage = "";
        if (answer == rightAnswer) {
            massage = "Right!";
            rightQuestionCount++;
            view.getId();


        } else {
            massage = "Wrong";

        }

        new AlertDialog.Builder(this)
                .setMessage(massage)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        quiz = list.get(new Random().nextInt(5));
                        initControls(quiz);
                    }
                })

                .setIcon(android.R.drawable.ic_dialog_alert).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("quiz", quiz);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        quiz = (Quiz) savedInstanceState.getSerializable("quiz");
        initControls(quiz);
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void initControls(Quiz quiz) {
        button1.setText(quiz.getFirstAnswer().getText());
        button2.setText(quiz.getSecondAnswer().getText());
        button3.setText(quiz.getThirdAnswer().getText());
        button4.setText(quiz.getFourthAnswer().getText());
        textView.setText(quiz.getQuestion().getText());
        rightAnswer = quiz.getRightAnswer();


    }


    private void getQuizes() {
        XmlResourceParser quizes = getResources().getXml(R.xml.quizes);
        int eventType = -1;
        while (eventType != XmlResourceParser.END_DOCUMENT) {
            if (eventType == XmlResourceParser.START_TAG) {
                String strName = quizes.getName();
                if (strName.equals("quiz")) {
                    Quiz quiz = new Quiz(
                            new Question(quizes.getAttributeValue(null, "question"), ""),
                            new Answer(quizes.getAttributeValue(null, "firstanswer"), "", ""),
                            new Answer(quizes.getAttributeValue(null, "secondanswer"), "", ""),
                            new Answer(quizes.getAttributeValue(null,"thirdanswer"), "", ""),
                            new Answer(quizes.getAttributeValue(null, "fourthanswer"), "", ""),
                            quizes.getAttributeIntValue(null, "rightanswer", 0));
                    list.add(quiz);

                }
            }

            try {
                eventType = quizes.next();
            } catch (IOException ioException) {
                Toast.makeText(this, "Error i/o", Toast.LENGTH_LONG).show();
            } catch (XmlPullParserException xmlPullParserException) {
                Toast.makeText(this, "Error parse xml", Toast.LENGTH_LONG)
                        .show();
            }
        }
    }

}