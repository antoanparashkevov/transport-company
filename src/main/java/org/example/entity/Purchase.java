package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="purchase")
public class Purchase {

    private static final float MIN_PRICE = 5.00F;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PastOrPresent(message = "Start date cannot be in the future!")
    @Column(name="start_time", nullable = false)
    private LocalDate startTime;

    @Column(name="end_time", nullable = false)
    private LocalDate endTime;

    @Column(name = "arrival_place", nullable = false)
    private String arrivalPlace;

    @Column(name = "departure_place", nullable = false)
    private String departurePlace;

    @Positive//not necessary since we already have a similar constraint named @DecimalMin but for demo purposes it's okay
    @DecimalMin(
        value = "5.00",
        message = "The price of the order has to be more than or equal to " + MIN_PRICE + " BGN"
    )
    @Column(name="price", nullable = false)
    private float price;

    @NotBlank(message = "The skill for the order cannot be blank!")
    @Column(name = "skill", nullable = false)
    private String skill;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Client> clients;

    @OneToOne(mappedBy = "purchase", fetch = FetchType.LAZY)
    private Receipt receipt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)//make this field non-nullable
    private Company company;

    //default constructor
    public Purchase() {
    }

    //parametrized constructor
    public Purchase(LocalDate startTime, LocalDate endTime, String arrivalPlace, String departurePlace, float price, String skill, List<Client> clients) {
        this.startTime = startTime;
        this.endTime = endTime;
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
        return startTime;
    }

    public LocalDate getEnd_time() {
        return endTime;
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

    public void setStart_time(LocalDate startTime) {
        this.startTime = startTime;
    }

    public void setEnd_time(LocalDate endTime) {
        this.endTime = endTime;
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
                ", start_time=" + startTime +
                ", end_time=" + endTime +
                ", arrival_place='" + arrivalPlace + '\'' +
                ", departure_place='" + departurePlace + '\'' +
                ", price=" + price +
                ", skill='" + skill + '\'' +
                '}';
    }
}
