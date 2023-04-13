package com.turbineapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.turbineapp.dto.TurbineDTO;
import com.turbineapp.service.TurbineService;

@Controller
@RequestMapping("/")
public class TurbineController {

	@Autowired
	public TurbineService turbineService;

	public TurbineController() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}

	public List<String> type = Arrays.asList("Impulse Turbine","Reaction Turbine","Pelton Turbine","Fransis Turbine","Kaplan Turbine");

	public List<String> country = Arrays.asList("India","California","New York","U S A");

	@GetMapping("/turbi")
	public String onTurbine(Model model) {
		System.out.println("Running onTurbine in GetMapping");
		model.addAttribute("type", type);
		model.addAttribute("country", country); 
		return "Register";	 
	} 

	@PostMapping("/turbi")
	public String onTurbine(TurbineDTO dto , Model model) {

		Set<ConstraintViolation<TurbineDTO>> constraintViolations = this.turbineService.saveAndValidate(dto);

		if(constraintViolations.isEmpty()) {
			System.out.println("Data Entered Sucessfully");
			System.out.println(dto);

			model.addAttribute("type", type);
			model.addAttribute("country",country);

			model.addAttribute("sv","Data Saved Sucessfully added");
			return "Register";
		}
		model.addAttribute("type", type);
		model.addAttribute("country", country);
		
		model.addAttribute("ConstraintViolations", constraintViolations);
		System.out.println(dto);
		
		System.err.println("violoations in controller");
		model.addAttribute("error", constraintViolations);
		
		return "Register";
	}

	@GetMapping("/searchbyid")
	public String onSearchById(@RequestParam int id , Model model) {

		System.out.println("Running on search for id..."+id);

		TurbineDTO dto = this.turbineService.findById(id);
		if(dto!=null) {
			model.addAttribute("dto", dto);
		}else {
			model.addAttribute("message", "Data Not Found");
		}
		return "SearchById"; 

	} 

	@GetMapping("/searchbycompany")
	public String onSearchByCompany(@RequestParam String companyName , Model model) {
		System.out.println("Running onSearchByCompany in controller "+companyName);
		List<TurbineDTO> list = this.turbineService.findByCompanyName(companyName);
		model.addAttribute("list", list); 
		return "SearchByCompany";	
	}

	@GetMapping("/update")
	public String onUpdate(@RequestParam int id , Model model) {

		System.out.println("Update By Id "+id);
		TurbineDTO dto = this.turbineService.findById(id);

		model.addAttribute("dto", dto);
		model.addAttribute("type", type);
		model.addAttribute("country", country);

		return "Update"; 

	}

	@PostMapping("update")
	public String onUpdate(TurbineDTO dto , Model model) {

		System.out.println("Running Update "+dto);

		Set<ConstraintViolation<TurbineDTO>> constraintViolations = this.turbineService.validateAndUpdate(dto);

		if (constraintViolations.size()>0) {

			model.addAttribute("err", constraintViolations);
		} else {

			model.addAttribute("updatemsg", "Turbine Update Sucessful");
		}
		model.addAttribute("dto", dto);
		model.addAttribute("type", type);
		model.addAttribute("country", country);
		model.addAttribute("updatemsg", "Turbine Update Sucessful");

		return "Update"; 
	}

	@GetMapping("/delete")
	public String onDelete(@RequestParam int id, Model model) {

		System.out.println("Running On Delete "+id);
		TurbineDTO dto = this.turbineService.deleteById(id);
		model.addAttribute("delete", dto);
		model.addAttribute("deletemsg", "Data Deleted Sucessful");
		return "SearchByCompany";
	}
}  
