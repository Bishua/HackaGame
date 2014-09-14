package com.example.bishua.hackagame.models;

import java.io.Serializable;

/**
 * Created by BishUA on 13.09.2014.
 */
public class Question implements Serializable {
    private String text;
    private String image;

    public Question(){}
    public Question(String text, String image){
        this.text = text;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



}
