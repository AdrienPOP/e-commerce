package com.ap_commerce.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ap_commerce.engine.entities.Category;
import com.ap_commerce.engine.repositories.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categorieRepository;

		@GetMapping("/addCategory")
		public String showFormCategory(@ModelAttribute Category cat) {
			return "addCategory";
		}
		
		@PostMapping("/addCategory")
		public String addNewCategory(@ModelAttribute Category cat) {
			categorieRepository.save(cat);
			return "addCategory";
		}
}
	