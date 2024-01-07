package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate start_time;
    private LocalDate end_time;

    private String arrival_place;
    private String departure_place;

    private float price;

    private String type;

    private String weight;

    private String skill;

}
