package com.example.bishua.hackagame.dao;

import com.example.bishua.hackagame.models.Quiz;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Illia on 14.09.2014.
 */
public interface QuizListDao {
    public List<Quiz> getQuizes() throws JSONException;

}
