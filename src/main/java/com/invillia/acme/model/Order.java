package com.invillia.acme.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private String address;

    private String number;

    private String neighborhood;

    private String city;

    private LocalDate  confirmationDate;

    private String status;

    @ManyToOne
    @JoinColumn(name="order_id_store", nullable=false)
    private Store store;

    @OneToMany(mappedBy = "order", targetEntity = OrderItem.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "order")
    private Payment payment;
}
