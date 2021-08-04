package com.ap_commerce.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap_commerce.engine.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
