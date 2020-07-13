package com.towhid.roomdatabasewithmvvm;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private SemisterDao semisterDao;
    private LiveData<List<Semister>> allSemister;

    Repository(Application application) {
        SemisterDatabase db = SemisterDatabase.getDatabase(application);
        semisterDao = db.semisterDao();
        allSemister = semisterDao.getAllSemister();
    }
    public LiveData<List<Semister>> getAllSemister() {
        return allSemister;
    }
    public void insertSemister(Semister semister) {
        new InsectTask(semisterDao).execute(semister);

    }
    public class InsectTask extends AsyncTask<Semister, Void, Void> {

        private SemisterDao semisterDao;

        public InsectTask(SemisterDao semisterDao) {
            this.semisterDao = semisterDao;
        }

        @Override
        protected Void doInBackground(Semister... semisters) {
            semisterDao.insertSemister(semisters[0]);
            return null;
        }
    }


}
