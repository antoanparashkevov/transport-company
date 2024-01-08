package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="registration_number", nullable = false)
    private String registrationNumber;

//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private Company company;

    //creating bidirectional relationship between vehicle and purchase
//    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
//    private List<Purchase> purchases;//telling that the relation between both tables is managed by the purchase table and the vehicle field

    //default constructor
    public Vehicle() {
    }

    //parametrized constructor
//    public Vehicle(Company company) {
//        this.company = company;
//        this.purchases = purchases;
//    }

    //GETTERS START

    public long getId() {
        return id;
    }

//    public Company getCompany() {
//        return company;
//    }
//
//    public List<Purchase> getPurchases() {
//        return purchases;
//    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

//    public void setCompany(Company company) {
//        this.company = company;
//    }
//
//    public void setPurchases(List<Purchase> purchases) {
//        this.purchases = purchases;
//    }

    //SETTERS END

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                '}';
    }
}
