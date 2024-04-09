package com.CS440.FitnessTracker.Model;

import java.time.LocalDate;

enum Classifications {
    YOGA,
    DANCE,
    CYCLING
}

public class Class {
    private int ClassID;
    private float Price;
    private Classifications Classification;
    private float Duration;
    private LocalDate Date;
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

    public Classifications getClassification() {
        return Classification;
    }

    public void setClassification(Classifications classification) {
        this.Classification = classification;
    }

    public float getDuration() {
        return Duration;
    }

    public void setDuration(float duration) {
        this.Duration = duration;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        this.Date = date;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }
}
