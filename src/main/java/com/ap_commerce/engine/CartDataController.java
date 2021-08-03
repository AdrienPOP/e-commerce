package com.ap_commerce.engine;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ap_commerce.engine.entities.Article;
import com.ap_commerce.engine.entities.Cart;
import com.ap_commerce.engine.repositories.ArticleRepository;


@RestController
public class CartDataController {
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/addArticleOnCart")
	public @ResponseBody Article addArticleOnCart(@RequestParam int idArticle, @Autowired Cart cart,
			HttpSession session) {
		cart.setSession(session);
		cart.setArticleRepositoty(articleRepository);
		cart.addArticleInCard(idArticle);
		Optional<Article> art = articleRepository.findById(idArticle);
		Article article = art.get();
		article.setCategory(null);
		return article;
	}
}
