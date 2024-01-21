package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="truck")
public class Truck extends Vehicle {

    @Column(name="capacity", nullable = false)
    private float capacity;

    //default constructor
    public Truck() {}

    //parametrized constructor
    public Truck(String registrationNumber, Company company, float capacity) {
        super(registrationNumber, company);
        this.capacity = capacity;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                "} " + super.toString();
    }
}
