package com.towhid.roomdatabasewithmvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SemisterViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Semister>> allSemister;

    public SemisterViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        this.allSemister = repository.getAllSemister();
    }

    public LiveData<List<Semister>> getAllSemister() {

        return allSemister;
    }
    public void insertSemister(Semister semister){
        repository.insertSemister(semister);
    }

}
