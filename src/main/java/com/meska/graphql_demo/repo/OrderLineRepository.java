package com.meska.graphql_demo.repo;

import com.meska.graphql_demo.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}

