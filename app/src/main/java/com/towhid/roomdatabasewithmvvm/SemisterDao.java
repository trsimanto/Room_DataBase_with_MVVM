package com.towhid.roomdatabasewithmvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SemisterDao {

    @Insert
    void insertSemister(Semister semister);

    @Update
    void updateSemister(Semister semister);

    @Delete
    void deleteSemister(Semister semister);

    @Query("Select * From Semister Order By semisterName")
    LiveData<List<Semister>> getAllSemister();

    @Query("Delete From Semister")
    void deleteAll();

}
