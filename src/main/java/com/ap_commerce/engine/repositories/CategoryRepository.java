package com.ap_commerce.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap_commerce.engine.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
	