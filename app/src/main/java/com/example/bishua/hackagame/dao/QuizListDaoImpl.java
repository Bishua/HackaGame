package com.example.bishua.hackagame.dao;

import android.content.Context;

import com.example.bishua.hackagame.models.Answer;
import com.example.bishua.hackagame.models.Question;
import com.example.bishua.hackagame.models.Quiz;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illia on 14.09.2014.
 */
public class QuizListDaoImpl implements QuizListDao {
    Context myContext;
    String jsonString = null;
    JSONObject jsonObject = null;

    public QuizListDaoImpl(Context myContext){
        this.myContext = myContext;
    }

    @Override
    public List<Quiz> getQuizes() throws JSONException {
        JSONObject parent = this.parseJsonData();
        List<Quiz> quizes = new ArrayList<Quiz>();
        for(int i = 0; i < 2; i++){
            JSONObject child = parent.getJSONObject(String.valueOf(i));
            Quiz quiz = new Quiz(
                    new Question(child.getString("question"), null),
                    new Answer(child.getString("answer1"), null, null),
                    new Answer(child.getString("answer2"), null, null),
                    new Answer(child.getString("answer3"), null, null),
                    new Answer(child.getString("answer4"), null, null),
                    child.getInt("rightAnswer"));
            quizes.add(i, quiz);
        }
        return quizes;

    }

    public JSONObject parseJsonData() throws JSONException{
        try {
            InputStream  is = myContext.getAssets().open("examples.json");
            int sizeOfJSONFile = is.available();

            byte[] bytes = new byte[sizeOfJSONFile];

            is.read(bytes);

            is.close();

            jsonString = new String(bytes, "UTF-8");


            jsonObject = new JSONObject(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
