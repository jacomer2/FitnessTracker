package com.CS440.FitnessTracker.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.CS440.FitnessTracker.Database.DatabaseManager;
import com.CS440.FitnessTracker.Model.Routine;

public class RoutineDAOImpl implements RoutineDaoInterface{

    @Override
    public int create(Routine model) {
        
    //    @Autowired
   //      private DataSource dataSource;
    
        int routineID = model.getRoutineID();
        Time startTime = model.getStartTime();
        Time endTime = model.getEndTime();
try { 

            // Connection connection = dataSource.getConnection();    //alternate datasource connection
            Connection connection = DatabaseManager.connection();

            String insertQuery = "INSERT INTO routine (routineID,startTime,endTime) VALUES (?, ?, ?)";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setInt(1, routineID);
            prepStatement.setTime(2,startTime);
            prepStatement.setTime(3,endTime);

            prepStatement.executeUpdate();

            connection.close();

            return 0; //success
        }
        catch(Exception e)
        {
            System.out.println(e);
            return 1; //fail
        }  
    }

    @Override
    public Routine read(int routineID) {
            //    @Autowired
   //      private DataSource dataSource;
     // Connection connection = dataSource.getConnection();    //alternate datasource connection
    
            //validate parameter
            if(routineID < 0)
            {
                return null;
            }

        try { 

            // Connection connection = dataSource.getConnection();    //alternate datasource connection
            Connection connection = DatabaseManager.connection();

            String insertQuery = "SELECT * FROM routine WHERE routineID = ?";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setInt(1, routineID);

             //execute
            ResultSet resultTable = prepStatement.executeQuery();

            // store values returned from db into user object
            while (resultTable.next()) {
                Routine retRoutine = new Routine();

                int id = resultTable.getInt(1);

                retRoutine.setRoutineID(id);
                retRoutine.setStartTime(resultTable.getTime(2));
                retRoutine.setEndTime(resultTable.getTime(3));
         
                connection.close();
                return retRoutine; //success
            }
        }
        catch(Exception e)
        {
            System.out.println(e);

            
        }  Routine nullRoutine = new Routine();
            nullRoutine.setRoutineID(-1);
        return nullRoutine; //fail

    }

    @Override
    public int update(Routine routine) {
            //    @Autowired
   //      private DataSource dataSource;
  
        //get attributes
        int routineID = routine.getRoutineID();
        Time startTime = routine.getStartTime();
        Time endTime = routine.getEndTime();

        try {
                
            Connection connection = DatabaseManager.connection();
//            Connection connection = dataSource.getConnection();  //alternate datasource connection

        String updateQuery = "UPDATE routine SET startTime = ?, endTime = ? WHERE routineID = ?";
        PreparedStatement prepStatement = connection.prepareStatement(updateQuery);
        prepStatement.setTime(1, startTime);
        prepStatement.setTime(2, endTime);
        prepStatement.setInt(3, routineID);
        prepStatement.executeUpdate();

        connection.close();

        return 0; //success
    }
    catch(Exception e)
    {
        System.out.println("ERROR UPDATING CLASS IN classDao.update()");
        System.out.println(e);
    }
    
    return 1; //fail
    }

    @Override
    public int delete(int routineID) {

            //    @Autowired
   //      private DataSource dataSource;
        
        try {
            Connection connection = DatabaseManager.connection();
//            Connection connection = dataSource.getConnection(); //alternate datasource connection

            String deleteQuery = "DELETE FROM routine WHERE routineID = ?";

            PreparedStatement prepStatement = connection.prepareStatement(deleteQuery);
            prepStatement.setInt(1, routineID);

            prepStatement.executeUpdate();

            connection.close();
            return 0; //success
        }
        catch(Exception e)
        {
            System.out.println(e);
            return 1; //fail

        }

    }
    
}
