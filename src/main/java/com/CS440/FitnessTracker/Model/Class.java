package com.CS440.FitnessTracker.Model;



public class Class {


    private int ClassID;
    private float Price;
    private String Classification; //... YOGA, CARDIO, WEIGHTS, CYCLING, POOL...
    private float Duration;
    private int date; //has to be in yyyymmdd format
    private int time; //has to be in hhmm format
    private int UserID;

    /*
     * default constructor
     */
    public Class(){

    }

    public Class(int classID, float price, String classification, float duration, int date, int time, int userID) {
        this.ClassID = classID;
        this.Price = price;
        this.Classification = classification;
        this.Duration = duration;
        this.date = date;
        this.time = time;
        this.UserID = userID;
    }

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

    /*
     * receives date in yyyymmdd format
     */
    public int getDate() {
        return date;
    }

    /*
     * param date : yyyymmdd format
     */
    public void setDate(int date) {
        this.date = date;
    }
/*
     * receives time in hhmm format
     */
    public int getTime() {
        return this.time;
    }

    /*
     * param time : hhmm format
     */
    public void setTime(int time) {
        this.time = time;
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
