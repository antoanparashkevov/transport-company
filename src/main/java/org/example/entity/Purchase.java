package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.example.entity.enumeration.PurchaseUnitType;

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
        value = "1.60",//EXAMPLES: Bus - 1.6BGN TICKET PRICE, Truck - 10BGN TOTAL
        message = "The price of the order has to be more than or equal to " + MIN_PRICE + " BGN"
    )
    @Column(name="price", nullable = false)
    private float price;

    //TODO: if unitType === PurchaseUnitType.people, therefore unitValue should be integer, not a floating point number
    @Enumerated(EnumType.STRING)
    @Column(name = "unit_type", nullable = false)
    private PurchaseUnitType unitType;

    //TODO: if there is a Bus as a vehicle, the unitValue should be less than or equal to the Bus seats
    @Column(name = "unit_value", nullable = false)
    private float unitValue;

    //implement lazy loading when read a purchase
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehicle vehicle;

    //implement lazy loading when read a purchase
    @ManyToOne(optional = false, fetch = FetchType.LAZY)//make this field non-nullable
    private Company company;

    //implement lazy loading when read a purchase
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Client> clients;

    //implement lazy loading when read a purchase
    @OneToOne(mappedBy = "purchase", fetch = FetchType.LAZY)
    private Receipt receipt;//5 * 1.6BGN

    //implement lazy loading when read a purchase
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Qualification qualification;

    //implement lazy loading when read a purchase
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    //default constructor
    public Purchase() {
    }

    //parametrized constructor
    public Purchase(LocalDate startTime, LocalDate endTime, String departurePlace, String arrivalPlace, float price, PurchaseUnitType unitType, float unitValue, Vehicle vehicle, Company company, Qualification qualification, Employee employee) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.price = price;
        this.unitType = unitType;
        this.unitValue = unitValue;
        this.vehicle = vehicle;
        this.company = company;
        this.qualification = qualification;
        this.employee = employee;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
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

    public PurchaseUnitType getUnitType() {
        return unitType;
    }

    public float getUnitValue() {
        return unitValue;
    }

    public Vehicle getVehicle() {
        return vehicle;
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

    public Employee getEmployee() {
        return employee;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDate endTime) {
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

    public void setUnitType(PurchaseUnitType unitType) {
        this.unitType = unitType;
    }

    public void setUnitValue(float unitValue) {
        this.unitValue = unitValue;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
                '}';
    }
}
