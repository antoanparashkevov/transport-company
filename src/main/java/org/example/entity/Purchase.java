package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate start_time;
    private LocalDate end_time;

    @Column(name = "arrival_place", nullable = false)
    private String arrivalPlace;

    @Column(name = "departure_place", nullable = false)
    private String departurePlace;

    private float price;

    @Column(name = "skill", nullable = false)
    private String skill;

    @ManyToMany
    private List<Client> clients;

    @OneToOne(mappedBy = "purchase")
    private Receipt receipt;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Vehicle vehicle;

    //default constructor
    public Purchase() {
    }

    public Purchase(LocalDate start_time, LocalDate end_time, String arrivalPlace, String departurePlace, float price, String skill, List<Client> clients) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.arrivalPlace = arrivalPlace;
        this.departurePlace = departurePlace;
        this.price = price;
        this.skill = skill;
        this.clients = clients;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public LocalDate getStart_time() {
        return start_time;
    }

    public LocalDate getEnd_time() {
        return end_time;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public float getPrice() {
        return price;
    }

    public String getSkill() {
        return skill;
    }

    public List<Client> getClients() {
        return clients;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setStart_time(LocalDate start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(LocalDate end_time) {
        this.end_time = end_time;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", arrival_place='" + arrivalPlace + '\'' +
                ", departure_place='" + departurePlace + '\'' +
                ", price=" + price +
                ", skill='" + skill + '\'' +
                '}';
    }
}
