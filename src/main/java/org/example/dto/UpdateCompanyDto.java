package org.example.dto;

//We describe only the fields that are required in order to update a company
public class UpdateCompanyDto {

    private String companyName;

    //parametrized constructor
    public UpdateCompanyDto(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "UpdateCompanyDto{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
