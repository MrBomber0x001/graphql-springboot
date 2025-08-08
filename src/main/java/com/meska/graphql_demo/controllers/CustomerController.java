package com.meska.graphql_demo.controllers;

import com.meska.graphql_demo.entities.customer.Customer;
import com.meska.graphql_demo.entities.customer.CustomerInput;
import com.meska.graphql_demo.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;

    @QueryMapping
    public Iterable<Customer> customers(){
        return customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument Long id){
        return customerRepository.findById(id)
                .orElseThrow();
    }

    @QueryMapping
    public Customer customerByEmail(@Argument String email){
        return customerRepository.findCustomerByEmail(email);
    }

    @MutationMapping
    public Customer addCustomer(@Argument(name = "input") CustomerInput customerInput){
        return customerRepository.save(customerInput.getCustomerEntity());
    }
}
