package com.example.bishua.hackagame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bishua.hackagame.models.Quiz;


public class QuizActivity extends ActionBarActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private int rightAnswer;
    private TextView textView;
    private int questionCount = 0;
    private int rightQuestionCount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Bundle bundle = getIntent().getExtras();
        Quiz quiz = new Quiz();

        if(bundle != null){
           quiz = (Quiz) bundle.getSerializable("quiz");
        }

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick(1);
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick(2);
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick(3);
            }
        });
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick(4);
            }
        });
        textView = (TextView) findViewById(R.id.textView);
        initControls(quiz);

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
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initControls(Quiz quiz){
        button1.setText(quiz.getFirstAnswer().getText());
        button2.setText(quiz.getSecondAnswer().getText());
        button3.setText(quiz.getThirdAnswer().getText());
        button4.setText(quiz.getFourthAnswer().getText());
        textView.setText(quiz.getQuestion().getText());
        rightAnswer = quiz.getRightAnswer();

    }

    private void onButtonClick(int answer){
        String massage = "";
        if(answer == rightAnswer){
           massage = "Right!";
           rightQuestionCount++;
        }else {
           massage = "Wrong";
        }

        new AlertDialog.Builder(this)
                .setMessage(massage)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert).show();
            questionCount++;
    }

    public void questionLoad(){

    }
    private void nextQuestion(){
        if(questionCount<10){

        }else{

        }

    }
    private void highScore(){
        Intent intent = new Intent(this, QuizActivity.class);
    }

}
