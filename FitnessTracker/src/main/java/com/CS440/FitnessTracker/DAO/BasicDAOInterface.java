package com.CS440.FitnessTracker.DAO;

import java.sql.SQLException;
import java.util.List;

public interface BasicDAOInterface<T>{

    //creates T
    int create(T t) throws SQLException;
    
    //prints and returns T info 
    T read(T t) throws SQLException;     
    
    List<T> readAll() throws SQLException;

    //updates T by id
    int update(T t) throws SQLException;

    //deletes T by ID
    void delete(T t) throws SQLException;
}