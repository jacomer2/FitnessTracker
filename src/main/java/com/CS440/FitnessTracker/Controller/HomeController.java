package com.CS440.FitnessTracker.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CS440.FitnessTracker.DAO.ExerciseDAO;
import com.CS440.FitnessTracker.DAO.ExerciseEntryDAO;
import com.CS440.FitnessTracker.DAO.ExerciseEntryDAOImpl;
import com.CS440.FitnessTracker.Model.Activity;
import com.CS440.FitnessTracker.Model.Exercise;
import com.CS440.FitnessTracker.Services.ActivityLog;

@Controller
@RequestMapping(value = { "/" })
public class HomeController {

	@Autowired
    private ExerciseDAO exerciseDAO;

	
	@GetMapping
	public ModelAndView homeView()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("Login");

		System.out.println("inside home");


		return model;
	}

	@GetMapping("/loginLink")
	public ModelAndView loginView()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("Login");

		return model;
	}

	@PostMapping("/loginHandler")
	public ModelAndView loginHandler()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("Home");

		return model;
	}

	@GetMapping("/sandbox")
	public ModelAndView sandboxHandler()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("Sandbox");

		Map<String,String> map = new HashMap<>();

		List exercises = exerciseDAO.getExerciseByFilter(map);

		model.addObject("exercises", exercises);

		return model;
	}

		//mapping for activity log page
		@GetMapping("/activitylog")
		public ModelAndView activityView()
		{
			ModelAndView model = new ModelAndView();
			model.setViewName("ActivityLog");
	
			//pass table from Activity log java code to jsp page for display
			ActivityLog activities = new ActivityLog();
			 List<Activity> resultsTable = activities.getActivityLog();
			model.addObject("activities", resultsTable);
	
			return model;
		}


		@GetMapping("/createWorkout")
		public ModelAndView createWorkout()
		{
			ModelAndView model = new ModelAndView();
	
			model.setViewName("Search");
	
			return model;
		}

		@GetMapping("/class")
		public ModelAndView classHandler()
		{
			ModelAndView model = new ModelAndView();
	
			model.setViewName("Class");
	
			return model;
		}

		@PostMapping("/workoutSearch")
		public ModelAndView workoutSearch(@RequestParam String category, @RequestParam String muscle_group, @RequestParam String difficulty)
		{

			System.out.println(category + muscle_group + difficulty);
			

			ModelAndView model = new ModelAndView();
	
			model.setViewName("Search");

			Map<String,String> map = new HashMap<>();
			if (category != "")  {
				map.put("Category", category);
			}
			if (muscle_group != "") {
				map.put("Muscle Groups", muscle_group);
			}
			if (difficulty != "") {
				map.put("Difficulty", difficulty);
			}


			List exercises = exerciseDAO.getExerciseByFilter(map);
	
			model.addObject("exercises", exercises);
	
			return model;
		}

		@PostMapping("/inputWorkout")
		public ModelAndView inputWorkout(@RequestParam int exerciseID, @RequestParam int inputSets, @RequestParam int inputReps, @RequestParam int inputWeight)
		{
			ExerciseEntryDAO entryDAO = new ExerciseEntryDAOImpl();


			System.out.println(inputSets + inputReps + inputWeight);

			System.out.println(exerciseID);

			entryDAO.setEntry(exerciseID, inputSets, inputReps, inputWeight);
			

			ModelAndView model = new ModelAndView();
	
			model.setViewName("Search");
	
			return model;
		}
}
