package org.example.dto;

import java.time.LocalDate;

//We describe only the fields that are required in order to create a company
public class CreateCompanyDto {

    private String companyName;

    private LocalDate foundationDate;

    //parametrized constructor
    public CreateCompanyDto(String companyName, LocalDate foundationDate) {
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
        return "CreateCompanyDto{" +
                "companyName='" + companyName + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
