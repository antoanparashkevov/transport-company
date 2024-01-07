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

    private String arrival_place;
    private String departure_place;

    private float price;

    private String type;

    private String weight;

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

    public Purchase(LocalDate start_time, LocalDate end_time, String arrival_place, String departure_place, float price, String type, String weight, String skill, List<Client> clients) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.arrival_place = arrival_place;
        this.departure_place = departure_place;
        this.price = price;
        this.type = type;
        this.weight = weight;
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

    public String getArrival_place() {
        return arrival_place;
    }

    public String getDeparture_place() {
        return departure_place;
    }

    public float getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getWeight() {
        return weight;
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

    public void setArrival_place(String arrival_place) {
        this.arrival_place = arrival_place;
    }

    public void setDeparture_place(String departure_place) {
        this.departure_place = departure_place;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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
                ", arrival_place='" + arrival_place + '\'' +
                ", departure_place='" + departure_place + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", weight='" + weight + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
