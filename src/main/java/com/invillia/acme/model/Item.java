package com.invillia.acme.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String description;

    private BigDecimal unitPrice;

    @OneToOne(mappedBy = "item")
    private OrderItem orderItem;
}
