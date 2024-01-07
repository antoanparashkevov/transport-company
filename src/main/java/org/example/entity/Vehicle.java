package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    private String capacityUnit;

    private float capacity;

    @ManyToOne
    private Company company;

    //creating bidirectional relationship between vehicle and purchase
    @OneToMany(mappedBy = "vehicle")
    private List<Purchase> purchases;//telling that the relation between both tables is managed by the purchase table and the vehicle field
}
