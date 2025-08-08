package com.meska.graphql_demo.controllers;


import com.meska.graphql_demo.entities.product.Product;
import com.meska.graphql_demo.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @QueryMapping
    public Iterable<Product> products() {
        return this.productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument String id) {
        return this.productRepository.findById(id).orElseThrow();
    }
}
