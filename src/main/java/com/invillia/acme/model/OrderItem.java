package com.invillia.acme.model;

import lombok.Data;

import javax.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderitem_id_item", referencedColumnName = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name="orderitem_id_order", nullable=false)
    private Order order;
}
