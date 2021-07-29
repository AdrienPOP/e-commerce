package com.ap_commerce.engine.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String description;

	@OneToMany(targetEntity=Article.class)
	@JoinColumn(name="category_id", referencedColumnName="id")
	private List<Article> article;
	
	
	public Category() {

	}

	public Category(String name, String description, ArrayList<Article> article) {
		this.name = name;
		this.description = description;
		this.article = article;
	}

	public int getId() {
		return id;
	}	

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(ArrayList<Article> article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", article=" + article + "]";
	}
	
	
	
	
	
	
}
