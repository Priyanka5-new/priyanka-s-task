package com.example.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
		return categoryRepository.findAll(PageRequest.of(page, 10));
	}

	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
		Category category = categoryRepository.findById(id).orElse(null);
		if (category != null) {
			category.setName(categoryDetails.getName());
			return categoryRepository.save(category);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryRepository.deleteById(id);
	}
}
