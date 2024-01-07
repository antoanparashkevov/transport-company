package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Purchase purchase;

    @OneToOne
    private Client client;

    public Receipt() {
    }

    public Receipt(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                '}';
    }
}
