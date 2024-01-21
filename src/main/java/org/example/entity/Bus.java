package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="bus")
public class Bus extends Vehicle {

    @Column(name="seats", nullable = false)
    private int seats;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "seats=" + seats +
                "} " + super.toString();
    }
}
