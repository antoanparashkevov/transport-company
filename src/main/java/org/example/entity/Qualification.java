package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name="qualification", uniqueConstraints = @UniqueConstraint(columnNames = {"type"}))
public class Qualification {

    private static final int MAX_TYPE_LENGTH = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = MAX_TYPE_LENGTH, message = "The qualification type should be not longer than " + MAX_TYPE_LENGTH + " characters!")
    @Column(name = "type", nullable = false)
    private String type;

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

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
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
