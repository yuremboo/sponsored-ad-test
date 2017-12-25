package com.sponsored.ad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sponsored.ad.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT o FROM Product o where o.category = ?1 and o.price = (select max(oo.price) from Product oo where oo.id = o.id)")
	Product getProductByCategory(String category);

}
