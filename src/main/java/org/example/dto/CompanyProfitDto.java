package org.example.dto;

public class CompanyProfitDto {

    private long id;

    private String companyName;

    private double companyProfit;

    public CompanyProfitDto() {
    }

    public CompanyProfitDto(long id, String companyName, double companyProfit) {
        this.id = id;
        this.companyName = companyName;
        this.companyProfit = companyProfit;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getCompanyProfit() {
        return companyProfit;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyProfit(double companyProfit) {
        this.companyProfit = companyProfit;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "CompanyProfitDto{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyProfit=" + companyProfit +
                '}';
    }
}
