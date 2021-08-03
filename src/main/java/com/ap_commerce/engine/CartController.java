package com.ap_commerce.engine;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ap_commerce.engine.entities.Article;
import com.ap_commerce.engine.entities.Cart;
import com.ap_commerce.engine.repositories.ArticleRepository;


@Controller
public class CartController {
	
	@Autowired
	private ArticleRepository articleRepositoty;
	
	@GetMapping ("/Cart")
		public String showCart() {
		return "cart";
	}

}
