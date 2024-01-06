package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Company {

    @Id//to tell that this should be the primary key, add this
    private long id;

    private String name;

}
