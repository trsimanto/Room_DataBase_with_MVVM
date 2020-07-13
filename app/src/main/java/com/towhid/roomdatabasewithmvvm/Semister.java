package com.towhid.roomdatabasewithmvvm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Semister {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String semisterName;
    private double semiseterGPA;
    private double semisterCredit;

    public Semister() {
    }

    public Semister(String semisterName, double semiseterGPA, double semisterCredit) {
        this.semisterName = semisterName;
        this.semiseterGPA = semiseterGPA;
        this.semisterCredit = semisterCredit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemisterName() {
        return semisterName;
    }

    public void setSemisterName(String semisterName) {
        this.semisterName = semisterName;
    }

    public double getSemiseterGPA() {
        return semiseterGPA;
    }

    public void setSemiseterGPA(double semiseterGPA) {
        this.semiseterGPA = semiseterGPA;
    }

    public double getSemisterCredit() {
        return semisterCredit;
    }

    public void setSemisterCredit(double semisterCredit) {
        this.semisterCredit = semisterCredit;
    }
}
