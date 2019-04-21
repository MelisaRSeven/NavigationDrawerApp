package com.example.navigationdrawerapp.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Post {
    private int pictureID;
    private String title, content, time, mail;

    public Post(int pictureID, String title, String content, String time, String mail) {
        this.pictureID = pictureID;
        this.title = title;
        this.content = content;
        this.time = time;
        this.mail = mail;
    }

    public Date timeCalculator() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD-MM-YYYY", Locale.getDefault());
        try {
            return simpleDateFormat.parse(getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public int getPictureID() {
        return pictureID;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getMail() {
        return mail;
    }
}
