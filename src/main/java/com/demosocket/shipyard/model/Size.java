package com.demosocket.shipyard.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "size")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_id")
    private int size_id;

//    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    @Column(name = "size")
    private String size;
}
