package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity//mandatory annotation to be able to connect this class to the table
@Table(
    name = "company",//overwrite the auto generated table name
    uniqueConstraints = @UniqueConstraint(columnNames = {"company_name"})
)
public class Company {

    //these two constants should be static unless you want to be added as fields to the table
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;

    @Id//This annotation tells that the field below should be the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    //Validation annotation
    @Size(
        min=MIN_NAME_LENGTH,
        max=MAX_NAME_LENGTH,
        message = "Company name should be between " + MIN_NAME_LENGTH + " and no longer than " + MAX_NAME_LENGTH + " characters long!"
    )
    @Column(name="company_name", nullable = false)
    private String companyName;

    @PastOrPresent(message = "Foundation date cannot be in the future!")
    @Column(name="foundation_date", nullable = false)
    private LocalDate foundationDate;

    //creating bidirectional relationship between the employee and the company
    //the relation between both tables is managed by the employee table and the company field
    //implement lazy loading when read a company
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    //TODO: vehicles relationship of type one to many (one vehicle - one company, one company - many vehicles)
    //TODO: the foreign key should be located at the vehicle table and the company field.

    //the relation between both tables is managed by the purchase table and the company field
    //implement lazy loading when read a company
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Purchase> purchases;

    //default constructor
    public Company() {
    }

    //parametrized constructor
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
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

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
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
