package com.CS440.FitnessTracker.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.CS440.FitnessTracker.Model.Entry;

public class ExerciseEntryDAOImpl implements ExerciseEntryDAO {

    @Autowired
    private DataSource dataSource;

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

    public void setEntry(@RequestParam int exerciseID, @RequestParam int sets, @RequestParam int reps, @RequestParam int weight) {
        
        LocalDate currentDate = LocalDate.now();
        Date date = Date.valueOf(currentDate);


    }
        
}
