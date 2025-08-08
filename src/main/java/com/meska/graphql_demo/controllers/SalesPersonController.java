package com.meska.graphql_demo.controllers;


import com.meska.graphql_demo.entities.Salesperson;
import com.meska.graphql_demo.repo.SalespersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SalesPersonController {

    private final SalespersonRepository salespersonRepository;



    @QueryMapping
    public Iterable<Salesperson> salespeople(){
        return this.salespersonRepository.findAll();
    }

    @QueryMapping
    public Salesperson salespersonById(@Argument Long id){
        return this.salespersonRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public Salesperson salespersonByEmail(@Argument String email){
        return this.salespersonRepository.findSalespersonByEmail(email);
    }
}
