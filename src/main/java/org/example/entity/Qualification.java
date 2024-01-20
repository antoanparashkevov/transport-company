package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity//mandatory annotation to be able to connect this class with the corresponding table
@Table(
    name="qualification",
    uniqueConstraints = @UniqueConstraint(columnNames = {"type"})
)
public class Qualification {

    //these two constants should be static unless you want to be added as fields to the table
    private static final int MIN_TYPE_LENGTH = 3;
    private static final int MAX_TYPE_LENGTH = 10;

    @Id//This annotation tells that the field below should be the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    //Validation constraint annotation
    @Size(
        min = MIN_TYPE_LENGTH,
        max = MAX_TYPE_LENGTH,
        message = "The qualification type should be between " + MIN_TYPE_LENGTH + " and no longer than " + MAX_TYPE_LENGTH + " characters long!"
    )
    @Column(name = "type", nullable = false)
    private String type;

    //implement lazy loading when read a qualification
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Employee> employees;

    //default constructor
    public Qualification() {
    }

    //parametrized constructor
    public Qualification(String type, Set<Employee> employees) {
        this.type = type;
        this.employees = employees;
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

    //SETTERS END

    @Override
    public String toString() {
        return "Qualification{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
