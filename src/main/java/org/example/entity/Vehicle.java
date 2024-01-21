package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity()//mandatory annotation to be able to connect this class with the corresponding table
@Table(
    name = "vehicle",//overwrite the auto generated table name
    uniqueConstraints = @UniqueConstraint(columnNames = {"registration_number"})
)
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //In Java, you need to escape the backslash with \. Therefore, we use \\ to represent a single backslash
    @Pattern(regexp = "^[A-Z]{2}\\d{4}[A-Z]{2}$", message = "You need to provide a valid registration number in this format: EN6246KS")//Validation constraint annotation
    @Column(name="registration_number", nullable = false)
    private String registrationNumber;

    //implement lazy loading when read a vehicle
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company;

    //creating bidirectional relationship between the purchase and the vehicle
    //the relation between both tables is managed by the purchase table and the vehicle field
    //implement lazy loading when read a vehicle
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Purchase> purchases;//telling that the relation between both tables is managed by the purchase table and the vehicle field

    //default constructor
    public Vehicle() {
    }

    //parametrized constructor
    public Vehicle(String registrationNumber, Company company) {
        this.registrationNumber = registrationNumber;
        this.company = company;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
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

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
