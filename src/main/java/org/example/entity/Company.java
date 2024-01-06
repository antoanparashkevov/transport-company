package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity//mandatory annotation
@Table(name = "company")//overwrite the auto generated table name
public class Company {

    @Id//to tell that this should be the primary key, add this annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    private String companyName;

    private LocalDate foundationDate;

    //creating bidirectional relationship between employee and company
    @OneToMany(mappedBy = "company")//telling that the relation between both tables is managed by the employee table and the company field
    private Set<Employee> employees;


}
