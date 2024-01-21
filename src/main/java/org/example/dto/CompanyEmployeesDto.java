package org.example.dto;

public class CompanyEmployeesDto {

    private long companyId;
    private String companyName;

    private long employeeId;
    private String employeeFirstName;
    private String employeeLastNameName;

    public CompanyEmployeesDto(long companyId, String companyName, long employeeId, String employeeFirstName, String employeeLastNameName) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastNameName = employeeLastNameName;
    }

    //GETTERS START

    public long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastNameName() {
        return employeeLastNameName;
    }

    //GETTERS END

    //SETTERS START

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public void setEmployeeLastNameName(String employeeLastNameName) {
        this.employeeLastNameName = employeeLastNameName;
    }

    //SETTERS END
}
