package com.carson.androidinsperationboard;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {InspirationRecord.class}, version = 1, exportSchema = false)
public abstract class InspirationDatabase extends RoomDatabase {
    private static volatile InspirationDatabase INSTANCE;

    public abstract InspirationDAO inspirationDAO; //abstract method

    static InspirationDatabase getDatabase(final Context context) {
        if (INSTANCE ==null) {
            synchronized (InspirationDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            InspirationDatabase.class, "Inspiration").build();
                }
            }
        }
        return INSTANCE;
    }
}
