package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity//mandatory annotation to be able to connect this class with the corresponding table
@Table(name="client")//overwrite the auto generated table name
public class Client {

    @Id//This annotation tells that the field below should be the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    @NotBlank(message = "You must provide your first name!")//Validation constraint annotation
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "You must provide your last name!")//Validation constraint annotation
    @Column(name = "last_name", nullable = false)
    private String lastName;

    //implement lazy loading when read a client
    @ManyToMany(mappedBy = "clients", fetch = FetchType.LAZY)
    private Set<Company> companies;

    //implement lazy loading when read a client
    @ManyToMany(mappedBy = "clients", fetch = FetchType.LAZY)
    private Set<Purchase> purchases;

    //creating bidirectional relationship between the client and the receipt
    //the relation between both tables is managed by the receipt table and the client field
    //implement lazy loading when read a client
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Receipt> receipts;

    //default constructor
    public Client() {
    }

    //parametrized constructor
    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public Set<Receipt> getReceipts() {
        return receipts;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void setReceipts(Set<Receipt> receipts) {
        this.receipts = receipts;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
