package com.CS440.FitnessTracker.Model;

import java.sql.Date;
import java.sql.Time;

//class to hold each activity performed that will be displayed in the user's activity log
public class Activity {
private Time startTime;
private Time endTime;
private String title;
private int sets;
private int reps;
private float weight;
private Time totalTime;
private Date date;


//activity constructor 
public Activity(Date date, Time startTime, Time endTime, String title, int sets, int reps, float weight, Time totalTime){
this.date = date;
this.startTime =startTime;
this.endTime = endTime;
this.title = title;
this.sets = sets;
this.reps = reps;
this.weight = weight;
this.totalTime = totalTime;
}

//start time from routine
public Time getStartTime(){
    return startTime;
}

//end time from routine
public Time getEndTime(){
    return endTime;
}

//title from exercise
public String getTitle(){
    return title;
}

//sets from exercise entry
public int getSets(){
    return sets;
}

//reps from exercise entry
public int getRepetitions(){
    return reps;
}

//weight from exercise entry
public float getWeight(){
    return weight;
}

//total time from exercise entry
public Time getTime(){
    return totalTime;
}

//date from exercise entry
public Date getDate(){
    return date;
}

// public int getUser(){
// return userID;
// }

}
