package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity//mandatory annotation to be able to connect this class to the table
@Table(name = "company", uniqueConstraints = @UniqueConstraint(columnNames = {"company_name"}))//overwrite the auto generated table name
public class Company {

    //these two constants should be static unless you want to be added as fields to the table
    private static final int MIN_NAME = 3;
    private static final int MAX_NAME = 10;

    @Id//to tell that this should be the primary key, add this annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    @Size(
        min=MIN_NAME,
        max=MAX_NAME,
        message = "Company name should be between at least " + MIN_NAME + " and no longer than " + MAX_NAME + " characters long!"
    )
    @Column(name="company_name", nullable = false, unique = true)
    private String companyName;

    @PastOrPresent(message = "Foundation date cannot be in the future!")
    @Column(name="foundation_date", nullable = false)
    private LocalDate foundationDate;

    //creating bidirectional relationship between the employee and the company
    //the relation between both tables is managed by the employee table and the company field
    //implement lazy loading when read a company
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Client> clients;

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

    public Set<Client> getClients() {
        return clients;
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

    public void setClients(Set<Client> clients) {
        this.clients = clients;
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
