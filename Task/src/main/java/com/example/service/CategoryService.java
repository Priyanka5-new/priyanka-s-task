package com.example.service;

import org.springframework.data.domain.Page;

import com.example.model.Category;

import java.util.Optional;

public interface CategoryService {
	
	Page<Category> getAllCategories(int page);

	Category createCategory(Category category);

	Optional<Category> getCategoryById(Long id);

	Category updateCategory(Long id, Category categoryDetails);

	void deleteCategory(Long id);
}
