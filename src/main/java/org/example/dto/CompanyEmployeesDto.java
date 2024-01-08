package org.example.dto;

public class CompanyEmployeesDto {

    private long companyId;
    private String companyName;

    private long employeeId;
    private String employeeName;

    public CompanyEmployeesDto(long companyId, String companyName, long employeeId, String employeeName) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
