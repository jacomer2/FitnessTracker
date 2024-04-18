package com.CS440.FitnessTracker.Controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {

	
	@GetMapping
	public ModelAndView homeView()
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("Home");

		System.out.println("inside home");


		return model;
	}
}
