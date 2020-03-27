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

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "size_id")
    private Size size;
}
