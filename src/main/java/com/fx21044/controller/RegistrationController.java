package com.fx21044.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fx21044.dto.UserDTO;
import com.fx21044.model.User;
import com.fx21044.service.CompanyService;
import com.fx21044.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	// form đăng ký
	@GetMapping("/showRegistrationForm")
	public String showLoginPage(Model theModel) {		
		UserDTO user = new UserDTO();
		
		theModel.addAttribute("user",user);
		theModel.addAttribute("companies",companyService.getCompanies());
		return "registration-form";
	}
	
	//đăng ký
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@RequestBody @Valid @ModelAttribute("user") UserDTO userDTO,
										 BindingResult theBindingResult,
										 Model theModel,
										 @RequestParam("roleId")int roleId,
										 @RequestParam(value = "companyId", defaultValue = "-1") int companyId,
										 @RequestParam(value = "companyName", defaultValue = "") String companyName) {
		
		String userName = userDTO.getUserName();
		System.out.println("Processing registration form for: " + userName);
		System.out.println(userDTO.getPassword() + " " + userDTO.getEmail());
		
		if(theBindingResult.hasErrors()) {
			List<ObjectError> errors = theBindingResult.getAllErrors();
		    for (ObjectError error : errors) {
		        System.out.println(error.getDefaultMessage());
		    }
			theModel.addAttribute("registrationError", "Error");
			theModel.addAttribute("companies", companyService.getCompanies());
			return "registration-form";	
		}
		
		User existed = userService.findUserByUserName(userName);
		if(existed != null) {
			theModel.addAttribute("registrationError", "User name already exists.");
			System.out.println("User name already exists.");
			return showLoginPage(theModel);
		}
		
		if(companyId == -1 && roleId != 1) {
			companyId = companyService.addNewCompany(companyName);
		}
		
		userService.saveUser(userDTO, roleId, companyId);
		
		return "registration-confirm";	
	}
}
