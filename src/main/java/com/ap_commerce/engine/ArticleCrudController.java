package com.ap_commerce.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ap_commerce.engine.entities.Article;
import com.ap_commerce.engine.entities.Category;
import com.ap_commerce.engine.repositories.ArticleRepository;
import com.ap_commerce.engine.repositories.CategoryRepository;

@Controller
public class ArticleCrudController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/addArticle")
	public String showFormArticle(Model model, @Autowired Article art) {
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "addArticle";
	}

	@PostMapping("/addArticle")
	public String addNewArticle(@ModelAttribute Article art) {
		articleRepository.save(art);
		return "redirect:/addArticle";
	}

	@PostMapping("/searchArticle")
	public String searchArticle(@ModelAttribute Article art) {
		return "home";
	}
}
