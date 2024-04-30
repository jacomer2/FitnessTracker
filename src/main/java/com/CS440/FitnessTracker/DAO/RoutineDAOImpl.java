package com.CS440.FitnessTracker.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import javax.sql.DataSource;
import com.CS440.FitnessTracker.Database.DatabaseManager;
import com.CS440.FitnessTracker.Model.Routine;

public class RoutineDAOImpl implements RoutineDaoInterface {

    private DatabaseManager dbManager = new DatabaseManager();
    private DataSource dataSource = dbManager.connect();

    @Override
    public int create(Routine model) {

        int routineID = model.getRoutineID();
        Time startTime = model.getStartTime();
        Time endTime = model.getEndTime();
        try {

            // Connection connection = dataSource.getConnection(); //alternate datasource
            // connection
            Connection connection = dataSource.getConnection();

            String insertQuery = "INSERT INTO routine (routineID,startTime,endTime) VALUES (?, ?, ?)";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setInt(1, routineID);
            prepStatement.setTime(2, startTime);
            prepStatement.setTime(3, endTime);

            prepStatement.executeUpdate();

            connection.close();

            return 0; // success
        } catch (Exception e) {
            System.out.println(e);
            return 1; // fail
        }
    }

    @Override
    public Routine read(int routineID) {

        // validate parameter
        if (routineID < 0) {
            return null;
        }

        try {

            Connection connection = dataSource.getConnection();

            String insertQuery = "SELECT * FROM routine WHERE routineID = ?";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setInt(1, routineID);

            // execute
            ResultSet resultTable = prepStatement.executeQuery();

            // store values returned from db into user object
            while (resultTable.next()) {

                int id = resultTable.getInt(1);
                Time startTime = resultTable.getTime(2);
                Time endTime = resultTable.getTime(3);


                Routine retRoutine = new Routine(id, startTime, endTime);


                connection.close();
                return retRoutine; // success
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        // Routine nullRoutine = new Routine();
        // nullRoutine.setRoutineID(-1);
        // return nullRoutine; // fail
        return null;
    }

    @Override
    public int update(Routine routine) {

        // get attributes
        int routineID = routine.getRoutineID();
        Time startTime = routine.getStartTime();
        Time endTime = routine.getEndTime();

        try {

            Connection connection = dataSource.getConnection();

            String updateQuery = "UPDATE routine SET startTime = ?, endTime = ? WHERE routineID = ?";
            PreparedStatement prepStatement = connection.prepareStatement(updateQuery);
            prepStatement.setTime(1, startTime);
            prepStatement.setTime(2, endTime);
            prepStatement.setInt(3, routineID);
            prepStatement.executeUpdate();

            connection.close();

            return 0; // success
        } catch (Exception e) {
            System.out.println("ERROR UPDATING CLASS IN classDao.update()");
            System.out.println(e);
        }

        return 1; // fail
    }

    @Override
    public int delete(int routineID) {

        try {
            Connection connection = dataSource.getConnection();

            String deleteQuery = "DELETE FROM routine WHERE routineID = ?";

            PreparedStatement prepStatement = connection.prepareStatement(deleteQuery);
            prepStatement.setInt(1, routineID);

            prepStatement.executeUpdate();

            connection.close();
            return 0; // success
        } catch (Exception e) {
            System.out.println(e);
            return 1; // fail

        }

    }

    @Override
    public int duration(int routineID) {
        try {
            Connection connection = dataSource.getConnection();

            String funcQuery = "SELECT duration(?) as period";
            PreparedStatement prepStatement = connection.prepareStatement(funcQuery);
            prepStatement.setInt(1, routineID);
            
            prepStatement.close();
            connection.close();

            return 0; // success
        }
        catch(Exception e) {
            System.out.println(e);
        }

        return 1; //fail
    }

}
