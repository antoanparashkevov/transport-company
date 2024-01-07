package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "salary", nullable = false)
    private float salary;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company;

    @ManyToMany(mappedBy = "employees", fetch = FetchType.LAZY)//TODO: WHY?
    private Set<Qualification> qualifications;

    //default constructor
    public Employee() {
    }

    public Employee(String firstName, String lastName, float salary, Company company, Set<Qualification> qualifications) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.company = company;
        this.qualifications = qualifications;
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

    //SETTERS END

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", company=" + company +
                '}';
    }
}
