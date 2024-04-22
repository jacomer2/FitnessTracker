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
import org.springframework.web.servlet.ModelAndView;

import com.CS440.FitnessTracker.DAO.ExerciseDAO;
import com.CS440.FitnessTracker.Model.Exercise;

@Controller
@RequestMapping(value = { "/" })
public class HomeController {

	@Autowired
    private ExerciseDAO exerciseDAO;

	
	@GetMapping
	public ModelAndView homeView()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("Home");

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

}
