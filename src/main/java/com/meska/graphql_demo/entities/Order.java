package com.meska.graphql_demo.entities;


import com.meska.graphql_demo.entities.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="ORDERS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    private String id;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false, updatable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "SALESPERSON_ID", nullable = false, updatable = false)
    private Salesperson salesperson;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
}
