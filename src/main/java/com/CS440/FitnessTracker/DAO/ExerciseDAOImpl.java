package com.CS440.FitnessTracker.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CS440.FitnessTracker.Model.Exercise;

@Component
public class ExerciseDAOImpl implements ExerciseDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Exercise> getExerciseByFilter(Map<String, String> filters) {

        int exerciseID;
        String title;
        String category;
        String description;
        String muscleGroup;
        String difficulty;

        List<Exercise> retrievedExercises = new ArrayList<>();

        PreparedStatement prepStatement;

        StringBuilder strBuild = new StringBuilder("SELECT * FROM exercise WHERE 1 = 1");

        for (int i = 0; i < filters.size(); i++) {
            strBuild.append(" AND replaceValue = ?");
        }
        strBuild.append(";");

        try {
            Connection connection = dataSource.getConnection();

            System.out.println("\n\n**** INSIDE TRY ****\n");


            String[] colValues = new String[filters.size()];

            int i = 0;

            for (Map.Entry<String, String> entry : filters.entrySet()) {
                
                String columnName = entry.getKey();
                if (!columnName.equals("ExerciseID") &&
                    !columnName.equals("Title") &&
                    !columnName.equals("Category") &&
                    !columnName.equals("Description") &&
                    !columnName.equals("Muscle Groups") &&
                    !columnName.equals("Difficulty")) {
                        System.out.println("INVALID COLUMN NAME"); // update?
                        System.out.println(columnName);
                        return null;
                }

                if (columnName.equals("Muscle Groups")) {
                    columnName = "`Muscle Groups`";
                }
                
                int replaceLength = 12;
                
                int index = strBuild.indexOf("replaceValue");

                strBuild.replace(index, index + replaceLength, columnName);

                colValues[i] = entry.getValue();
                i++; // Move to next pair
            }

            prepStatement = connection.prepareStatement(strBuild.toString());


            for (int j = 0; j < colValues.length; j++) {
                prepStatement.setString(j+1, colValues[j]);
            }

            System.out.println("prep statement");
            System.out.println(prepStatement);


            ResultSet resultTable = prepStatement.executeQuery();

            if (resultTable.next()) {
                exerciseID = resultTable.getInt(1);
                title = resultTable.getString(2);
                category = resultTable.getString(3);
                description = resultTable.getString(4);
                muscleGroup = resultTable.getString(5);
                difficulty = resultTable.getString(6);

                Exercise retExercise = new Exercise(exerciseID, title, category, description, muscleGroup, difficulty);


                System.out.println(retExercise.getTitle());
                retrievedExercises.add(retExercise);
            }

            System.out.println("\n\n**** BEFORE CLOSE ****\n");


            connection.close();

            return retrievedExercises;

        }
        catch(Exception e)
        {

            System.out.println(e);
        }



        System.out.println(strBuild.toString());


        return null;
    }
    
}
