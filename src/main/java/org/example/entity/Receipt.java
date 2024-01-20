package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Purchase purchase;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)//not nullable
    private Client client;

    //default constructor
    public Receipt() {
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                '}';
    }
}
