package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.Set;

@Entity//mandatory annotation to be able to connect this class with the corresponding table
@Table(name="employee")//overwrite the auto generated table name
public class Employee {

    @Id//This annotation tells that the field below should be the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    @NotBlank(message = "You must provide your first name!")//Validation constraint annotation
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "You must provide your last name!")//Validation constraint annotation
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Positive(message = "The salary should be a positive number!")//Validation constraint annotation
    @Column(name = "salary", nullable = false)
    private float salary;

    //implement lazy loading when read an employee
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company;

    //implement lazy loading when read an employee
    @ManyToMany(mappedBy = "employees", fetch = FetchType.LAZY)
    private Set<Qualification> qualifications;

    //implement lazy loading when read an employee
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Purchase> purchases;

    //default constructor
    public Employee() {
    }

    //parametrized constructor
    public Employee(String firstName, String lastName, float salary, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.company = company;
    }


    //GETTERS START

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getSalary() {
        return salary;
    }

    public Company getCompany() {
        return company;
    }

    public Set<Qualification> getQualifications() {
        return qualifications;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setQualifications(Set<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
