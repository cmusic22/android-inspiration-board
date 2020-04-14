package com.carson.androidinsperationboard;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public class InspirationDAO {
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   void insert (InspirationRecord... ir;)

   @Update
   void update(InspirationRecord... ir;)

   @Query ("SELECT * FROM InspirationRecord WHERE date = date";) //change to primary key
    LiveData<InspirationRecord> getDetailRecord();

   @Query("SELECT * FROM InspirationRecord";)
   LiveData<List<InspirationRecord>> getAllRecords();

   @Query ("DELETE FROM InspirationRecord WHERE data = date";)
   void deleteInspiration ();

}
