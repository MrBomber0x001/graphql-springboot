package com.meska.graphql_demo.repo;

import com.meska.graphql_demo.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
