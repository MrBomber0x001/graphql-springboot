package com.meska.graphql_demo.repo;


import com.meska.graphql_demo.entities.Salesperson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalespersonRepository extends JpaRepository<Salesperson, Long> {

    Salesperson findSalespersonByEmail(String email);
}
