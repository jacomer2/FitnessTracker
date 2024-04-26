package com.CS440.FitnessTracker.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.CS440.FitnessTracker.Database.DatabaseManager;
import com.CS440.FitnessTracker.Model.Activity;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ActivityLog {

    private DatabaseManager dbManager = new DatabaseManager();
    private DataSource dataSource = dbManager.connect();


    public  List<Activity> getActivityLog(){
        List<Activity> activities = new ArrayList<>();
        try {

            System.out.println("Activity Log: before connection");

            Connection connection = dataSource.getConnection();

            System.out.println("Activity Log: past connection");

            PreparedStatement prepStatement = connection.prepareStatement("Select * FROM ActivityLog");

            ResultSet resSet = prepStatement.executeQuery();
            while(resSet.next()){
                Date date = resSet.getDate(1);
                Time startTime = resSet.getTime(2);
                Time endTime = resSet.getTime(3);
                String title = resSet.getString(4);
                int sets = resSet.getInt(5);
                int reps = resSet.getInt(6);
                float weight = resSet.getFloat(7);
                Time totalTime = resSet.getTime(8);
                Activity activity = new Activity(date,startTime,endTime,title,sets,reps,weight,totalTime);
                activities.add(activity);
            }
     
            return activities;
        }
        catch(Exception e)
        {
            System.out.println("activity log: "+ e);
        }
        return null;
    }

}

