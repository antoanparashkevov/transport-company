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
}
