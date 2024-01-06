package org.example.entity;

import jakarta.persistence.*;

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
}
