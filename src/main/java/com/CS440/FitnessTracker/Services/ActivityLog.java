package com.CS440.FitnessTracker.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.CS440.FitnessTracker.Model.Activity;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ActivityLog {

    @Autowired
    private DataSource dataSource;


    public ResultSet getActivityLog(){

        PreparedStatement prepStatement;
        ResultSet resSet = null;
        Connection connection = null;
        List<Activity> activities = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            
            prepStatement = connection.prepareStatement("CREATE VIEW ActivityLog\n" + 
                    "AS SELECT Routine.StartTime as StartTime, Routine.EndTime as EndTime, Exercise.Title as Title, Exercise_Entry.Sets as Sets, Exercise_Entry.Repetitions as Repetitions, Exercise_Entry.Weight as Weight, Exercise_Entry.Date as Date, Exercise_Entry.Time as Time\n" + //
                    "   FROM Routine, Exercise, Exercise_Entry, User\n" + 
                    "   WHERE User.UserID = Exercise_Entry.UserID;");
            System.out.println("prepstmt:"+prepStatement);
            resSet = prepStatement.executeQuery();
            while(resSet.next()){
                String startTime = resSet.getString(1);
                String endTime = resSet.getString(2);
                String title = resSet.getString(3);
                int sets = resSet.getInt(4);
                int reps = resSet.getInt(5);
                float weight = resSet.getFloat(6);
                Date date = resSet.getDate(7);
                Time totalTime = resSet.getTime(8);
                Activity activity = new Activity(startTime,endTime,title,sets,reps,weight,date,totalTime);
                activities.add(activity);
            }
        }
        catch(Exception e)
        {
            System.out.println("activity log: "+ e);
        }
        return resSet;
    }

}

