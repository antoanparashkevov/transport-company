package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="bus")
public class Bus extends Vehicle {

    @Column(name="seats", nullable = false)
    private int seats;

}
