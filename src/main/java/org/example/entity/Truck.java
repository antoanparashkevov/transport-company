package org.example.entity;

import jakarta.persistence.*;
import org.example.entity.enumeration.CapacityUnit;

@Entity
@Table(name="truck")
public class Truck extends Vehicle {

    @Enumerated(EnumType.STRING)
    @Column(name = "unit", nullable = false)
    private CapacityUnit unit;

    @Column(name="capacity", nullable = false)
    private float capacity;

    //default constructor
    public Truck() {}

    //parametrized constructor
    public Truck(String registrationNumber, Company company, CapacityUnit unit, float capacity) {
        super(registrationNumber, company);
        this.unit = unit;
        this.capacity = capacity;
    }

    //GETTERS START

    public CapacityUnit getUnit() {
        return unit;
    }

    public float getCapacity() {
        return capacity;
    }

    //GETTERS END

    //SETTERS START

    public void setUnit(CapacityUnit unit) {
        this.unit = unit;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "Truck{" +
                "unit=" + unit +
                ", capacity=" + capacity +
                "} " + super.toString();
    }
}
