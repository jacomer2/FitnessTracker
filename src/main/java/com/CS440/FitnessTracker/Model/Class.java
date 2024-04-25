package com.CS440.FitnessTracker.Model;

import java.sql.Date;
import java.sql.Time;


public class Class {
    private int ClassID;
    private float Price;
    private String Classification;
    private float Duration;
    private Date Date;  
    private Time Time;
    private int UserID;

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int classID) {
        this.ClassID = classID;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        this.Price = price;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String classification) {
        this.Classification = classification;
    }

    public float getDuration() {
        return Duration;
    }

    public void setDuration(float duration) {
        this.Duration = duration;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time time) {
        this.Time = time;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }
}
