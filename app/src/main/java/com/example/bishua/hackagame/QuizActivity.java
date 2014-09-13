package com.example.bishua.hackagame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.bishua.hackagame.models.Quiz;


public class QuizActivity extends ActionBarActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
//        Quiz quiz = (Quiz)savedInstanceState.getSerializable("quiz");\
        Bundle bundle = getIntent().getExtras();
        Quiz quiz = new Quiz();

        if(bundle != null){
           quiz = (Quiz) bundle.getSerializable("quiz");
        }

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
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
        button1.setText(quiz.getAnswer1().getText());
        button2.setText(quiz.getAnswer2().getText());
        button3.setText(quiz.getAnswer3().getText());
        button4.setText(quiz.getAnswer4().getText());
        textView.setText(quiz.getQuestion().getText());
    }
}
