package com.meska.graphql_demo.controllers;

import com.meska.graphql_demo.entities.Order;
import com.meska.graphql_demo.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;

    @QueryMapping
    public Iterable<Order> orders(){
        return this.orderRepository.findAll();
    }

    @QueryMapping
    public Order orderById(@Argument String id){
        return this.orderRepository.findById(id).orElseThrow();
    }
}

