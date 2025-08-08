package com.meska.graphql_demo.entities;


import com.meska.graphql_demo.entities.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ORDER_LINES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderLine {
    @Id
    @Column(name="ORDER_LINE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name="ORDER_ID", nullable = false, updatable = false)
    @ManyToOne
    private Order order;
    @OneToOne
    @JoinColumn(name="PRODUCT_ID", nullable = false, updatable = false)
    private Product product;
    @Column(name="QUANTITY")
    private int quantity;


}

