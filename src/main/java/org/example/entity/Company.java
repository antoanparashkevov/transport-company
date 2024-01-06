package org.example.entity;

import jakarta.validation.constraints.*;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

// POJO
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Company name cannot be blank!")
    @Size(max = 20, message = "Company name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Company name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @PastOrPresent(message = "Foundation date cannot be in the future!")
    @Column(name = "foundation_date")
    private LocalDate foundationDate;

    @Positive
    @DecimalMin(value = "5000.00", message = "Initial capital has to be more than or equal to 5000.00", inclusive = true)
    @DecimalMax(value = "10000.00", message = "Initial capital has to be less than or equal to 10000.00")
    @Digits(integer = 5, fraction = 2, message = "Initial capital has to be with 5 digits before and 2 digits after the decimal separator!")
    @Column(name = "init_capital", nullable = false)
    private BigDecimal initialCapital;

//    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
//    private Set<Employee> employees;

    public Company() {
    }

    public Company(String name, LocalDate foundationDate, BigDecimal initialCapital) {
        this.name = name;
        this.foundationDate = foundationDate;
        this.initialCapital = initialCapital;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public BigDecimal getInitialCapital() {
        return initialCapital;
    }

    public void setInitialCapital(BigDecimal initialCapital) {
        this.initialCapital = initialCapital;
    }

//    public Set<Employee> getEmployees() {
//        return employees;
//    }

//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundationDate=" + foundationDate +
                ", initialCapital=" + initialCapital +
                '}';
    }
}
