package org.example.dto;

import java.time.LocalDate;

public class CompanyDto {

    private String companyName;

    private LocalDate foundationDate;

    public CompanyDto() {
    }

    public CompanyDto(String companyName, LocalDate foundationDate) {
        this.companyName = companyName;
        this.foundationDate = foundationDate;
    }

    //GETTERS START

    public String getCompanyName() {
        return companyName;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    //GETTERS END

    //SETTERS START

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "CompanyDto{" +
                "companyName='" + companyName + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
