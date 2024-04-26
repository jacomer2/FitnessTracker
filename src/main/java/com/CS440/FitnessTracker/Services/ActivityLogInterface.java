package com.CS440.FitnessTracker.Services;

import java.util.List;

import com.CS440.FitnessTracker.Model.Activity;



public interface ActivityLogInterface {

     /**
      * function that calls the activity log view from db
      * @return List to display
      */
        public  List<Activity> getActivityLog();

    
}
