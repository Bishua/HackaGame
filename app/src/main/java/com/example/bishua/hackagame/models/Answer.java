package com.example.bishua.hackagame.models;

import java.io.Serializable;

/**
 * Created by BishUA on 13.09.2014.
 */
public class Answer implements Serializable {
    private String text;
    private String image;
    private String url;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
