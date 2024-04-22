package com.CS440.FitnessTracker.Model;

import java.sql.Date;
import java.sql.Time;


public class Activity {
//need to change and set constructor. 
private String startTime;
private String endTime;
private String title;
private int sets;
private int reps;
private float weight;
private Time time;
private Date date;



public Activity(String startTime, String endTime, String title, int sets, int reps, float weight, Date date, Time time){
this.startTime =startTime;
this.endTime = endTime;
this.title = title;
this.sets = sets;
this.reps = reps;
this.weight = weight;
this.time = time;
this.date = date;
this.weight = weight;

}
public String getStartTime(){
    return startTime;
}
public String getEndTime(){
    return endTime;
}

public String getTitle(){
    return title;
}

public int getSets(){
    return sets;
}

public int getRepetitions(){
    return reps;
}

public float getWeight(){
    return weight;
}

public Time getTime(){
    return time;
}

// public int getUser(){
// return userID;
// }

}
