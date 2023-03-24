package com.aeroplaneapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class AeroplaneController {

	public AeroplaneController() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	
	private List<String> country = Arrays.asList("pakistan", "UK", "africa");
	
	@GetMapping("/create")
	public String onAeroplane(Model model) {
		
		
		System.out.println("running onAeroplane on GetMapping");
		model.addAttribute("country", country);
		
		return "Register";	
	}
	
	
	
	
	
}
