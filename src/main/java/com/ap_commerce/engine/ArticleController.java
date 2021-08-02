package com.ap_commerce.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ap_commerce.engine.entities.Category;
import com.ap_commerce.engine.repositories.CategoryRepository;

@Controller
public class ArticleController {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/category")
	public String showByCategory(Model model, @RequestParam int category, @Autowired Category cat, RedirectAttributes redirectAttr) {
		List <Category> categories = categoryRepository.findAll();
		model.addAttribute("categories",categories);
		
		cat = categoryRepository.findById(category).get();
		model.addAttribute("articles", cat.getArticle());
		return "articles";
	}
	
	@GetMapping("/allCategory")
	public String showByAllCategory(Model model, @Autowired Category cat) {
		
		return ""; 
	}	
}
