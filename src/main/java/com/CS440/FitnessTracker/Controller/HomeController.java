package com.CS440.FitnessTracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = { "/" })
public class HomeController {

	
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
	@GetMapping("/activitylog")
	public ModelAndView activityView()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("ActivityLog");

		return model;
	}

	@PostMapping("/activtyHandler")
	public ModelAndView activityHandler()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("ActivityLog");

		return model;
	}

}
