package com.carson.androidinsperationboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

//passes messages from View to Repository

public class InspirationViewModel {

    private InspirationRepository repository;

    private LiveData<List<InspirationRecord>> allRecords;

    public InspirationViewModel(@NonNull Application application){
        super(application);
        repository = new InspirationRepository(application);
        allRecords = repository.getAllRecords();
    }

    public  LiveData<List<InspirationRecord>> getAllRecords() {
        return allRecords;
    }

    public LiveData<InspirationRecord> getDetailRecord(Date date) {
        return repository.getDetailRecord(date);
    }

    public void insert(InspirationRecord record){
        repository.insert(record);
    }

    public void delete(InspirationRecord record){
        repository.delete(record);
    }
}
