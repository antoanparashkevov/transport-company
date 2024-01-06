package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    private float salary;

    @ManyToOne
    private Company company;

    @ManyToMany(mappedBy = "employees")//TODO: WHY?
    private Set<Qualification> qualifications;
}
