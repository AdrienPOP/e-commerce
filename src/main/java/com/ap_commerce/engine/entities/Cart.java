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
	
	private double priceTotal;

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

		if (session.getAttribute("cart") == null) {
			this.setUserId(1);
			session.setAttribute("cart", this);
		}
		return (Cart) session.getAttribute("cart");
	}

	public void updateCart(Cart cart) {
		this.userId = cart.userId;
		this.articles = cart.articles;

	}

	public void addArticleInCard(int idArticle) {
		ArticleRepository articleRepository = this.articleRepositoty;
		Optional<Article> article = articleRepository.findById(idArticle);
		verifyIfArticleExist(article);
	}

	public void verifyIfArticleExist(Optional<Article> article) {
		if (this.articles.isEmpty()) {
			article.get().setQuantity(1);
			this.articles.add(article.get());
		} else {
			for (Article a : this.articles) {
				if (article.get().getId() == a.getId()) {
					a.setQuantity(a.getQuantity() + 1);
					return;
				} 
			}
			article.get().setQuantity(1);
			this.articles.add(article.get());
		}
	}
	
	public double calculateTotalPriceByArticle() {
		this.priceTotal = 0.0;
		for (Article a : this.articles) {
				this.priceTotal += a.getPrice() * a.getQuantity();
			} 
		return priceTotal;
	}
	
	
	public void modifyQuantityOnArticle(int idArticle, int quantity) {
		for (Article a : this.articles) {
			if (idArticle == a.getId())
				a.setQuantity(quantity);
		}
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
		this.calculateTotalPriceByArticle();
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

	public double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}

}
