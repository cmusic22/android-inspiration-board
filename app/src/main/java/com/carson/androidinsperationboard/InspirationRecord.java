package com.carson.androidinsperationboard;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class InspirationRecord {

    @PrimaryKey
    @NonNull
    private String date;
    private String inspiration;
    private String hashtag;
    private Bitmap bitmap;
    //image column

    public InspirationRecord(@NonNull String date, String inspiration, String hashtag, Bitmap bitmap ){ //image column)
        this.date = date;
        this.inspiration = inspiration;
        this.hashtag = hashtag;
        this.bitmap = bitmap;
    }

    @NonNull

    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
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

    public Bitmap getBitmap() {return bitmap;}

    public void setBitmap(Bitmap bitmap) {this.bitmap = bitmap; }

    @Override
    public String toString(){
        return "InspirationRecord{" + "date=" + date +
                "inspiration=" + inspiration +
                "hashtag=" + hashtag + "bitmap=" + bitmap"}"; //need to add picture bitmap to string
    }
}
