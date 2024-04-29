package com.CS440.FitnessTracker.Controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CS440.FitnessTracker.DAO.ClassDaoInterface;
import com.CS440.FitnessTracker.DAO.ExerciseDAO;
import com.CS440.FitnessTracker.DAO.ExerciseEntryDAO;
import com.CS440.FitnessTracker.DAO.ExerciseEntryDAOImpl;
import com.CS440.FitnessTracker.DAO.UserDAO;
import com.CS440.FitnessTracker.Model.Activity;
import com.CS440.FitnessTracker.Model.Exercise;
import com.CS440.FitnessTracker.Model.User;
import com.CS440.FitnessTracker.Services.ActivityLog;

@Controller
@RequestMapping(value = { "/" })
public class HomeController {

	@Autowired
    private ExerciseDAO exerciseDAO;

	@Autowired 
	private ClassDaoInterface classDAO;

	@Autowired
	private UserDAO userDao;

	private User user;

	
	@GetMapping
	public ModelAndView homeView()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("Login");

		// System.out.println("inside home");


		return model;
	}


	@GetMapping("/homeLink")
	public ModelAndView homeLink()
	{
		ModelAndView model = new ModelAndView();

		int height = user.getHeight();
		float weight = user.getWeight();
		float bmi = user.getBMI();
		String bmi_class = user.getBMI_Class();

		// add email to welcome page
		model.addObject("username", user.getUsername());
		model.addObject("height", height);
		model.addObject("weight", weight);
		model.addObject("bmi", bmi);
		model.addObject("bmi_class", bmi_class);


		model.setViewName("Home");

		return model;
	}
	

	@GetMapping("/loginLink")
	public ModelAndView loginView()
	{
		ModelAndView model = new ModelAndView();
		String auth = "auth";
		User user = new User();
		model.setViewName("Login");
		model.addObject(auth, user.isUserLoggedIn());		//is this how we can access a variable to check if user is authenticated?
		
															//would i have to call dao.read(user) here to authenticate
															// before sending mapping to Home page?

		return model;
	}

	@PostMapping("/Home")
	public ModelAndView loginHandler(@RequestParam String username, @RequestParam String password)
	{

		if (user == null) {
			user = userDao.getUser(username);
		}

		ModelAndView model = new ModelAndView();



		if (user != null && user.getHashedPassword().equals(password)) {
			int height = user.getHeight();
			float weight = user.getWeight();
			float bmi = user.getBMI();
			String bmi_class = user.getBMI_Class();

			// add email to welcome page
			model.addObject("username", username);
			model.addObject("height", height);
			model.addObject("weight", weight);
			model.addObject("bmi", bmi);
			model.addObject("bmi_class", bmi_class);


			model.setViewName("Home");

		} else {

			model.addObject("error", "Invalid login credentials");
			model.setViewName("Login"); // Redirect back to login page if user is not valid
		}

		return model;
	}

	@PostMapping("/Register")
	public ModelAndView register(@RequestParam String username, @RequestParam String password)
	{

		if (user == null) {
			//create user
			User user = new User(username,password);
			userDao.insertUser(user);
			System.out.println("User created: " + user.getUsername() + " " + user.getHashedPassword());
			System.out.println("User ID: " + userDao.getUser(username));
		}

			ModelAndView model = new ModelAndView();
	
			model.setViewName("Login");

		return model;
	}

	@GetMapping("/Register")
	public ModelAndView registerView()
	{
		ModelAndView model = new ModelAndView();
		
		model.setViewName("Register");
		return model;
	}


	@GetMapping("/sandbox")
	public ModelAndView sandboxHandler()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("Sandbox");

		Map<String,String> map = new HashMap<>();

		List<Exercise> exercises = exerciseDAO.getExerciseByFilter(map);

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
		public ModelAndView classHandler() throws SQLException
		{
			ModelAndView model = new ModelAndView();

			List<com.CS440.FitnessTracker.Model.Class> classes = classDAO.readAll();

			System.out.println(classes.toString());

			model.addObject("classes", classes);

	
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


			List<Exercise> exercises = exerciseDAO.getExerciseByFilter(map);
	
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

		//mapping for activity log page
		@GetMapping("/About")
		public ModelAndView exerciseView()
		{
			ModelAndView model = new ModelAndView();
			model.setViewName("About");
	
			//pass table from Activity log java code to jsp page for display
			List<Exercise> exercise_list = exerciseDAO.getExerciseByIndex();

		model.addObject("exercise_list", exercise_list);
			return model;
		}
}
