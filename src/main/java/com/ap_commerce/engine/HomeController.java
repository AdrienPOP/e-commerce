package com.ap_commerce.engine;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@Autowired 
	private BeanFactory beanFactory;
	@Autowired
	private ApplicationContext applicationContext;

	@GetMapping("")
	public String showHome(Model model) {
		return "home";
	}
	
	
	
}
