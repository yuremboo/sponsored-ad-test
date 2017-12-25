package com.sponsored.ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sponsored.ad.model.Product;
import com.sponsored.ad.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@RequestParam String category) {
		return ResponseEntity.ok(productService.getProductByCategory(category));
	}
}
