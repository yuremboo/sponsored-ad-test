package com.sponsored.ad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sponsored.ad.model.Product;
import com.sponsored.ad.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductByCategory(String category) {
		return productRepository.getProductByCategory(category);
	}
}
