package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity//mandatory annotation to be able to connect this class to the table
@Table(name = "company")//overwrite the auto generated table name
public class Company {

    @Id//to tell that this should be the primary key, add this annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    @Size(min=3, max=10)//makes the field not nullable
    @Column(name="company_name", nullable = false, unique = true)
    private String companyName;

    @Column(name="foundation_date", nullable = false)
    private LocalDate foundationDate;

    //creating bidirectional relationship between employee and company
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)//telling that the relation between both tables is managed by the employee table and the company field
    private Set<Employee> employees;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Client> clients;

    //creating bidirectional relationship between purchase and company
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)//telling that the relation between both tables is managed by the purchase table and the company field
    private List<Purchase> purchases;

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
