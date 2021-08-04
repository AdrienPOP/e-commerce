package com.ap_commerce.engine;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ap_commerce.engine.entities.Cart;
import com.ap_commerce.engine.entities.Category;
import com.ap_commerce.engine.repositories.CategoryRepository;

@Controller
public class CartController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/Cart")
	public String showCart(Model model, HttpSession session, @Autowired Cart cart) {
		List <Category> categories = categoryRepository.findAll();
		model.addAttribute("categories",categories);
		
		cart.setSession(session);
		model.addAttribute("articles", cart.getArticles());
		return "cart";
	}

}
