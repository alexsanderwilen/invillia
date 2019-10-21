package com.invillia.acme.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderitem_id")
    private Long id;

    private String description;

    private BigDecimal unitPrice;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="orderitem_id_order", nullable=false)
    private Order order;
}
