package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity//mandatory annotation to be able to connect this class to the table
@Table(name = "company")//overwrite the auto generated table name
public class Company {

    @Id//to tell that this should be the primary key, add this annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    private String companyName;

    private LocalDate foundationDate;

    //creating bidirectional relationship between employee and company
    @OneToMany(mappedBy = "company")//telling that the relation between both tables is managed by the employee table and the company field
    private Set<Employee> employees;

    @OneToMany(mappedBy = "company")
    private Set<Vehicle> vehicles;

    //default constructor
    public Company() {
    }

    public Company(String companyName, LocalDate foundationDate) {
        this.companyName = companyName;
        this.foundationDate = foundationDate;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
