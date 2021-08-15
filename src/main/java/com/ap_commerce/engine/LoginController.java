package com.ap_commerce.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ap_commerce.engine.entities.Category;
import com.ap_commerce.engine.entities.User;
import com.ap_commerce.engine.repositories.CategoryRepository;

@Controller
public class LoginController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/login")
	public String showFormLogin(Model model, @ModelAttribute User user) {
		List <Category> categories = categoryRepository.findAll();
		model.addAttribute("categories",categories);
		return "login";
	}
	
	@GetMapping("/register")
	public String showFormRegister(Model model, @ModelAttribute User user) {
		List <Category> categories = categoryRepository.findAll();
		model.addAttribute("categories",categories);
		return "register";
	}

}
