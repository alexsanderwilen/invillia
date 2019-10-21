package com.invillia.acme.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String name;

    private String address;

    private String number;

    private String neighborhood;

    private String city;

    @OneToMany(mappedBy = "store", targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;
}
