package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

@Entity//mandatory annotation to be able to connect this class with the corresponding table
@Table(name="purchase")//overwrite the auto generated table name
public class Purchase {

    //the constant should be static unless you want to be added as field to the table
    private static final float MIN_PRICE = 5.00F;

    @Id//This annotation tells that the field below should be the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment (AI) property
    private long id;

    //Validation constraint annotation
    @PastOrPresent(message = "Start date cannot be in the future!")//Validation constraint annotation
    @Column(name="start_time", nullable = false)
    private LocalDate startTime;

    @Column(name="end_time", nullable = false)
    private LocalDate endTime;

    @Column(name = "departure_place", nullable = false)
    private String departurePlace;

    @Column(name = "arrival_place", nullable = false)
    private String arrivalPlace;

    //Validation constraint annotation
    @Positive//not necessary since we already have a similar constraint named @DecimalMin but for demo purposes it's okay
    @DecimalMin(
        value = "5.00",
        message = "The price of the order has to be more than or equal to " + MIN_PRICE + " BGN"
    )
    @Column(name="price", nullable = false)
    private float price;

    //Validation constraint annotation
    @NotBlank(message = "The skill for the order cannot be blank!")
    @Column(name = "skill", nullable = false)
    private String skill;

    //TODO: vehicle relationship of type many to one
    // (one vehicle - many purchases, one purchase - one vehicle)
    //@ManyToOne(optional = false, fetch = FetchType.LAZY)
    //private Vehicle vehicle;

    //implement lazy loading when read a purchase
    @ManyToOne(optional = false, fetch = FetchType.LAZY)//make this field non-nullable
    private Company company;

    //implement lazy loading when read a purchase
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Client> clients;

    //implement lazy loading when read a purchase
    @OneToOne(mappedBy = "purchase", fetch = FetchType.LAZY)
    private Receipt receipt;

    //implement lazy loading when read a purchase
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Qualification qualification;

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

    public String getDeparturePlace() {
        return departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public float getPrice() {
        return price;
    }

    public String getSkill() {
        return skill;
    }

    public Company getCompany() {
        return company;
    }

    public List<Client> getClients() {
        return clients;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public Qualification getQualification() {
        return qualification;
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

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", start_time=" + startTime +
                ", end_time=" + endTime +
                ", departure_place='" + departurePlace + '\'' +
                ", arrival_place='" + arrivalPlace + '\'' +
                ", price=" + price +
                ", skill='" + skill + '\'' +
                '}';
    }
}
