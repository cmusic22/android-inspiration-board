package com.carson.androidinsperationboard;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public class InspirationDAO {
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   void insert (InspirationRecord... wr);

   @Update
   void update(InspirationRecord... wr);

   @Query("SELECT * FROM InspirationRecord WHERE date = :date")
    LiveData<InspirationRecord> getDetailRecord;

   @Query("SELECT * FROM InspirationRecord")
   LiveData<List<InspirationRecord>> getAllRecords();

   //@Query("DELETE * FROM InspirationRecord WHERE date = :date")

}
