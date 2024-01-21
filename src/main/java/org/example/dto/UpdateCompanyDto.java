package org.example.dto;

//We describe only the fields that are required in order to update a company
public class UpdateCompanyDto {

    private String companyName;

    public UpdateCompanyDto(String companyName) {
        this.companyName = companyName;
    }
}
