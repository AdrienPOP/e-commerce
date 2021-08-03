package com.ap_commerce.engine.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap_commerce.engine.repositories.ArticleRepository;

@Service
public class Cart {

	private int userId;
	
	private int idArticle;
	
	@Autowired
	private List<Article> articles;
	
	@Autowired
	private ArticleRepository articleRepositoty;
	
	private HttpSession session;

	public Cart() {
		super();
		this.articles = new ArrayList<Article>();
	}
	
	public Cart updateSessionCart(HttpSession session) {
		
		if(session.getAttribute("cart") == null) {
			this.setUserId(1);
			session.setAttribute("cart", this);	
		}
		return (Cart)session.getAttribute("cart");
	}
	public void updateCart(Cart cart) {
		this.userId = cart.userId;
		this.articles = cart.articles;
		
	}
	
	public void addArticleInCard(int idArticle) {
		ArticleRepository articleRepository = this.articleRepositoty;
		Optional<Article> article = articleRepository.findById(idArticle);
		
		this.articles.add(article.get());
	}
	
	
	// Getters and Setters : 

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
		this.updateCart(updateSessionCart(this.session));
	}

	public ArticleRepository getArticleRepositoty() {
		return articleRepositoty;
	}

	public void setArticleRepositoty(ArticleRepository articleRepositoty) {
		this.articleRepositoty = articleRepositoty;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	@Override
	public String toString() {
		return "Cart [articles=" + articles + "]";
	}

	

	
	
	
	
	
	
	
}
