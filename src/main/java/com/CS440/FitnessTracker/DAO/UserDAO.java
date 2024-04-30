package com.CS440.FitnessTracker.DAO;

import com.CS440.FitnessTracker.Model.User;

public interface UserDAO {

        /**
     * @brief retrieves the specified user from the database
     * @param email - email address used to find user in database
     * @return a user returned from database, stored as a User object
     */
    User getUser(String userName);

    /**
     * @brief deletes specified user from database
     * @param User to be deleted from database
     * */
    void deleteUser(User user);

    /**
     * @brief inserts user into database
     * @param user to be inserted in database
     */
    void insertUser(User user);
    
    /**
     * @brief updates user attributes in database
     * @param user that will have attributes updated
     * @param params the list of attributes to update
     */
    void updateUser(User user, String[] params);

    public void updateStats(User user, int height, float weight);
    
}
