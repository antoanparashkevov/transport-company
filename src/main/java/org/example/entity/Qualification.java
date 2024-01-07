package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="qualification")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    @ManyToMany
    private Set<Employee> employees;

    //default constructor
    public Qualification() {
    }

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
