package com.meska.graphql_demo.repo;

import com.meska.graphql_demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
