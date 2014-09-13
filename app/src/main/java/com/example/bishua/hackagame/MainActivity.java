package com.example.bishua.hackagame;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.bishua.hackagame.models.Answer;
import com.example.bishua.hackagame.models.Question;
import com.example.bishua.hackagame.models.Quiz;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }


    }
    public void startGame(View view){

        Intent intent = new Intent(this, QuizActivity.class);
        //dummy data
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
        question.setText("question");
        quiz.setFirstAnswer(answer1);
        quiz.setSecondAnswer(answer2);
        quiz.setThirdAnswer(answer3);
        quiz.setFourthAnswer(answer4);
        quiz.setQuestion(question);
        quiz.setRightAnswer(1);
        //end dummy data

        Bundle bundle = new Bundle();
        bundle.putSerializable("quiz", quiz);
        intent.putExtras(bundle);
        startActivity(intent);

    }
    public void openQuizWithData(Quiz quiz){
        Intent intent = new Intent(this, QuizActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quiz", quiz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
