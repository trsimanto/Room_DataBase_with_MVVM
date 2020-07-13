package com.towhid.roomdatabasewithmvvm;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Semister.class}, version = 1, exportSchema = false)
public abstract class SemisterDatabase extends RoomDatabase {
    public abstract SemisterDao semisterDao();

    private static volatile SemisterDatabase semisterDatabase;

    static SemisterDatabase getDatabase(final Context context) {
        if (semisterDatabase == null) {
            synchronized (SemisterDatabase.class) {
                if (semisterDatabase == null) {
                    semisterDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            SemisterDatabase.class,
                            "semister_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return semisterDatabase;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(semisterDatabase).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final SemisterDao mDao;

        PopulateDbAsync(SemisterDatabase db) {
            mDao = db.semisterDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }
}

