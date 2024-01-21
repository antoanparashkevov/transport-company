package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity//mandatory annotation to be able to connect this class with the corresponding table
@Table(
    name="qualification",
    uniqueConstraints = @UniqueConstraint(columnNames = {"type"})
)
public class Qualification {

    @Id//This annotation tells that the field below should be the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    //Validation constraint annotation
    @NotBlank(message = "You must provide a qualification type!")
    @Column(name = "type", nullable = false)
    private String type;

    //implement lazy loading when read a qualification
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Employee> employees;

    @OneToMany(mappedBy = "qualification", fetch = FetchType.LAZY)
    private Set<Purchase> purchases;

    //default constructor
    public Qualification() {
    }

    //parametrized constructor
    public Qualification(String type) {
        this.type = type;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
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

    public void setType(String type) {
        this.type = type;
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
        return "Qualification{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
