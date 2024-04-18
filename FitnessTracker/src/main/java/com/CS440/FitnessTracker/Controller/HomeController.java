package com.CS440.FitnessTracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/home")
    public String homePage() {
        return "Home"; // Assuming "Home.jsp" exists in the expected location
    }
}
