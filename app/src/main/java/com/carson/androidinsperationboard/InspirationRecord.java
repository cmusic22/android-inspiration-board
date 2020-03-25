package com.carson.androidinsperationboard;

import androidx.annotation.NonNull;

import java.util.Date;

@Entity
public class InspirationRecord {

    @PrimaryKey
    @NonNull
    private Date date;
    private String inspiration;
    private String hashtag;
    //image column

    public InspirationRecord(@NonNull Date date, String inspiration, String hashtag { //image column)
        this.date = date;
        this.inspiration = inspiration;
        this.hashtag = hashtag;
        //image
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    public String getInspiration() {
        return inspiration;
    }

    public void setInspiration(String inspiration) {
        this.inspiration = inspiration;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    @Override
    public String toString(){
        return "InspirationRecord{" +
                "inspiration" + inspiration +
                "hashtag=" + hashtag + "}"; //need to add picture bitmap to string
    }
}
