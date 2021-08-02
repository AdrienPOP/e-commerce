package com.ap_commerce.engine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ap_commerce.engine.entities.Article;
import com.ap_commerce.engine.entities.Category;

@Controller
public class AdminPanelController {

		@GetMapping("/userAdmin")
		public String showPanel(@ModelAttribute Category category, @ModelAttribute Article article) {
			
			return "admin";
			
		}
}
