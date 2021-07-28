package com.ap_commerce.engine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ap_commerce.engine.entities.Article;
import com.ap_commerce.engine.entities.Category;
import com.ap_commerce.engine.repositories.ArticleRepository;
import com.ap_commerce.engine.repositories.CategoryRepository;

@Controller
public class ArticleController {
	
	@Autowired
	private CategoryRepository categorieRepository;
	@Autowired
	private ArticleRepository articleRepository;
	
	
	@GetMapping("/category/{category}")
	public String showByCategory(Model model, @PathVariable String category, @Autowired Category cat) {
		cat.setName(category);
		
		return "articleTemplate";
	}
	
	@GetMapping("/allCategory")
	public String showByAllCategory(Model model, @Autowired Category cat) {
		
		return ""; 
	}

	@GetMapping("/addArticle")
		public String showFormArticle(Model model, @Autowired Article art) {
			List <Category> categories = categorieRepository.findAll();
			ArrayList <String> cats = new ArrayList<>();
			for (Category cat : categories) {
				cats.add(cat.getName());
			}
			model.addAttribute("categories",categories);
			return "addArticle";
		}
	
	@PostMapping("/addArticle")
	public String addNewArticle(@ModelAttribute Article art) {
		articleRepository.save(art);
		return "addArticle";
	}
	
	
	
	
}
