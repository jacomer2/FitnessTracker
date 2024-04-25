package com.CS440.FitnessTracker.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClassDaoInterface extends BasicDAOInterface<com.CS440.FitnessTracker.Model.Class>{
    
    /*
     * need to implement read by :
     *                              date
     *                             classification
     *                           user id
     *                          class id
     *                         price
     *                       duration
     */

     //MEANT TO REPLACE ALL OF THE BELOW METHODS
    ArrayList<com.CS440.FitnessTracker.Model.Class> readByAttribute(String attribute_name, Object value) throws SQLException;
     //returns list of classes returned by searching by date
    ArrayList<com.CS440.FitnessTracker.Model.Class> readByDate(String date) throws SQLException;

    ArrayList<com.CS440.FitnessTracker.Model.Class> readByClassification(String classification) throws SQLException;

    ArrayList<com.CS440.FitnessTracker.Model.Class> readByUserID(int userID) throws SQLException;

    ArrayList<com.CS440.FitnessTracker.Model.Class> readByClassID(int classID) throws SQLException;

    ArrayList<com.CS440.FitnessTracker.Model.Class> readByPrice(float price) throws SQLException;

    ArrayList<com.CS440.FitnessTracker.Model.Class> readByDuration(float duration) throws SQLException;


}
