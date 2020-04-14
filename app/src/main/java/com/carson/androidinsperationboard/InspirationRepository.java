package com.carson.androidinsperationboard;

//rest of app will talk to this to access data
//single source of truth
//defines methods the app will call to query the database


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

public class InspirationRepository {

    private InspirationDAO inspirationDAO;

    public InspirationRepository(Application application){
        InspirationDatabase db = InspirationDatabase.getDatabase(application);
        inspirationDAO = db.inspirationDAO();
    }

    public void insert(InspirationRecord record){
        //insert record asynchronously
        new InsertInspirationAsync(inspirationDAO).execute(record);
    }

    static class InsertInspirationAsync extends AsyncTask<InspirationRecord, Void, Void> {

        private InspirationDAO inspirationDAO;

        InsertInspirationAsync(InspirationDAO inspirationDAO){
            this.inspirationDAO = inspirationDAO;
        }

        @Override
        protected Void doInBackground(InspirationRecord... inspirationRecords) {
            inspirationDAO.insert(inspirationRecords);
            return null;
        }
    }


    public void delete(InspirationRecord record){
        //delete record asynchronously
        new DeleteInspirationAsync(inspirationDAO).execute(record);
    }

    static class DeleteInspirationAsync extends AsyncTask<InspirationRecord, Void, Void> {

        private InspirationDAO inspirationDAO;

        DeleteInspirationAsync(InspirationDAO inspirationDAO){
            this.inspirationDAO = inspirationDAO;
        }

        @Override
        protected Void doInBackground(InspirationRecord... inspirationRecords){
            inspirationDAO.deleteInspiration(inspirationRecords);
            return null;
        }

    }

    public LiveData<List<InspirationRecord>> getAllRecords() {
        return inspirationDAO.getAllRecords();
    }

    public LiveData<InspirationRecord> getDetailRecord(Date date){
        return inspirationDAO.getDetailRecord(date);
    }

    public LiveData<InspirationRecord> deleteInspiration(Date date){
        return inspirationDAO.deleteInspiration(date);
    }

}
