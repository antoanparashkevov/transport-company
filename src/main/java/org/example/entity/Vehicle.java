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

    @ManyToOne(optional = false)
    private Company company;

    //creating bidirectional relationship between vehicle and purchase
    @OneToMany(mappedBy = "vehicle")
    private List<Purchase> purchases;//telling that the relation between both tables is managed by the purchase table and the vehicle field

    //default constructor
    public Vehicle() {
    }

    public Vehicle(String type, String capacityUnit, float capacity, Company company, List<Purchase> purchases) {
        this.type = type;
        this.capacityUnit = capacityUnit;
        this.capacity = capacity;
        this.company = company;
        this.purchases = purchases;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCapacityUnit() {
        return capacityUnit;
    }

    public float getCapacity() {
        return capacity;
    }

    public Company getCompany() {
        return company;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacityUnit(String capacityUnit) {
        this.capacityUnit = capacityUnit;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", capacityUnit='" + capacityUnit + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
