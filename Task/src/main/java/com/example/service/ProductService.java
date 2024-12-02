package com.example.service;

import org.springframework.data.domain.Page;

import com.example.model.Product;

import java.util.Optional;

public interface ProductService {

	Page<Product> getAllProducts(int page);

	Product createProduct(Product product);

	Optional<Product> getProductById(Long id);

	Product updateProduct(Long id, Product productDetails);

	void deleteProduct(Long id);
}
