package com.CS440.FitnessTracker.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CS440.FitnessTracker.Database.DatabaseManager;
import com.CS440.FitnessTracker.Model.Entry;


@Component
public class ExerciseEntryDAOImpl implements ExerciseEntryDAO {

    private DatabaseManager dbManager = new DatabaseManager();
    private DataSource dataSource = dbManager.connect();

    @Override
    public List<Entry> getEntriesByUserID(int userID) {
        
        int entryID;
        int sets;
        int repetitions;
        float weight;
        Date date;
        Time time;
        int length;
        int exerciseID;
        int routineID;

        List<Entry> retrievedEntries = new ArrayList<>();


                // User object to later store user retrieved from db
                Entry retrievedEntry = null;

                try {
                    Connection connection = dataSource.getConnection();
        
                    String getQuery = "SELECT * FROM exercise_entry WHERE UserID = ?";
        
                    PreparedStatement prepStatement = connection.prepareStatement(getQuery);
                    prepStatement.setInt(1, userID);
        
                    ResultSet resultTable = prepStatement.executeQuery();
        
                    // store values returned from db into user object
                    while (resultTable.next()) {
        
                        entryID = resultTable.getInt(1);
                        sets = resultTable.getInt(2);
                        repetitions = resultTable.getInt(3);
                        weight = resultTable.getInt(4);
                        date = resultTable.getDate(5);
                        time = resultTable.getTime(6);
                        length = resultTable.getInt(7);
                        userID = resultTable.getInt(8);
                        exerciseID = resultTable.getInt(9);
                        routineID = resultTable.getInt(10);

        
                       retrievedEntry = new Entry(entryID, sets, repetitions, weight, date, time, length, userID, exerciseID, routineID);
                    
                       retrievedEntries.add(retrievedEntry);
                    
                    }
        
                    connection.close();

                    return retrievedEntries;
                }
                catch(Exception e)
                {
        
                    System.out.println(e);
                }
            
            return null;
    }

    @Override
    public void setEntry(int exerciseID, int sets, int reps, int weight) {
        
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        
        // params
        Date date = Date.valueOf(currentDate);
        Time time = Time.valueOf(currentTime);
        int length = 0;
        int userID = 1;
        int routineID = 1;

        try {
            System.out.println("****BEFORE CONNECTION****");

            Connection connection = dataSource.getConnection();
            System.out.println("****INSIDE INSERT****");


            String getQuery = "INSERT INTO exercise_entry (Sets, Repetitions, Weight, Date, Time, Length, UserID, ExerciseID, RoutineID) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStatement = connection.prepareStatement(getQuery);
            prepStatement.setInt(1, sets);
            prepStatement.setInt(2, reps);
            prepStatement.setInt(3, weight);
            prepStatement.setDate(4, date);
            prepStatement.setTime(5, time);
            prepStatement.setInt(6, length);
            prepStatement.setInt(7, userID);
            prepStatement.setInt(8, exerciseID);
            prepStatement.setInt(9, routineID);
            prepStatement.executeUpdate();

            connection.close();

            return;
        }
        catch(Exception e)
        {

            System.out.println(e);
        }
    
    return;





    }
        
}
