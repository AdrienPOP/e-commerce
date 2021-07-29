package com.ap_commerce.engine;


import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ap_commerce.engine.entities.Category;
import com.ap_commerce.engine.repositories.CategoryRepository;

@Controller
public class HomeController {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping(path={"", "/home"})
	public String showHome(Model model) {
		List <Category> categories = categoryRepository.findAll();
		model.addAttribute("categories",categories);
		return "home";
	}
	@GetMapping("/login")
	public String showFormLogin(Model model) {
		List <Category> categories = categoryRepository.findAll();
		model.addAttribute("categories",categories);
		return "login";
	}
	
	
	
}
