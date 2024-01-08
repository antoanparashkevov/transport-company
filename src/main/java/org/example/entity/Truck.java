package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="truck")
public class Truck extends Vehicle {

    @Column(name="capacity", nullable = false)
    private float capacity;
}
