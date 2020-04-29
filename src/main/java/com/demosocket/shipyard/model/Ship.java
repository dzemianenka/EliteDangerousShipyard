package com.demosocket.shipyard.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "shipyard")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ship_id")
    private int id;

    @Column(name = "ship_model")
    private String shipModel;

    @Column(name = "cost")
    private int cost;

    @Column(name = "manufacturer")
    @Enumerated(value = EnumType.STRING)
    private Manufacturer manufacturer;

    @Column(name = "size")
    @Enumerated(value = EnumType.STRING)
    private Size size;
}
