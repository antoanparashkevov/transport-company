package org.example.dto;

import org.example.entity.Company;

public class VehicleDto {

    private long id;

    private String registrationNumber;

    private String companyName;

    public VehicleDto(long id, String registrationNumber, String companyName) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.companyName = companyName;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "VehicleDto{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
