package org.example.dto;

import java.time.LocalDate;

//We describe only the fields that are required in order to create a company
public class CreateCompanyDto {

    private String companyName;

    private LocalDate foundationDate;

    public CreateCompanyDto(String companyName, LocalDate foundationDate) {
        this.companyName = companyName;
        this.foundationDate = foundationDate;
    }
}
