package org.example.entity;

import jakarta.persistence.*;

@Entity//mandatory annotation to be able to connect this class with the corresponding table
@Table(name="receipt")//overwrite the auto generated table name
public class Receipt {

    @Id//This annotation tells that the field below should be the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    //implement lazy loading when read a company
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    //implement lazy loading when read a company
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Purchase purchase;

    //default constructor
    public Receipt() {
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                '}';
    }
}
