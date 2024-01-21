package org.example;

import org.example.configuration.SessionFactoryUtil;

import org.example.dao.CompanyDao;
import org.example.entity.Client;
import org.example.entity.Company;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        SessionFactoryUtil.getSessionFactory().openSession();

//      Company company1 = new Company("Speedy", LocalDate.of(2023, 1, 5));
//      Company company2 = new Company("Econt", LocalDate.of(2022, 2, 10));
//      Company company3 = new Company("HBC", LocalDate.of(2021, 3, 15));
//      Company company4 = new Company("Evri", LocalDate.of(2020, 4, 20));
//      Company company5 = new Company("Royal", LocalDate.of(2019, 5, 25));

        //create a company
//      CompanyDao.createCompany(company1);
//      CompanyDao.createCompany(company2);
//      CompanyDao.createCompany(company3);
//      CompanyDao.createCompany(company4);
//      CompanyDao.createCompany(company5);

        //read a company (The ORM requires to have a default constructor inside the Company Entity
//      System.out.println(CompanyDao.getCompanyById(1));
//      System.out.println(CompanyDao.getCompanyById(2));
//      System.out.println(CompanyDao.getCompanyById(3));
//      System.out.println(CompanyDao.getCompanyById(4));
//      System.out.println(CompanyDao.getCompanyById(5));

        //read all companies
//      System.out.println(CompanyDao.getAllCompanies());

        //update a company
        //means we want to UPDATE the record with primary key (id) 1.
        // If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the CompanyDao class
//        Company companyToUpdate = new Company();
//        companyToUpdate.setId(1);
//        companyToUpdate.setCompanyName("newSAP");
//        companyToUpdate.setFoundationDate(LocalDate.of(2024,1, 1));
//        CompanyDao.updateCompany(companyToUpdate);

        //delete a company
//      CompanyDao.deleteCompany(company1);

//      System.out.println(CompanyDao.companyFindByCompanyName("VM"));//no result found for query
//      System.out.println(CompanyDao.companyFindByCompanyName("SAP"));

//      System.out.println(CompanyDao.companyFindByCompanyNameStartingWith("S"));

//      System.out.println(CompanyDao.getCompanyEmployees(1));

//      System.out.println(CompanyDao.getCompanyEmployeesDTO(1));

//        Client client = new Client("Antoan", "Parashkevov", "0877268727");
//        System.out.println(client);

    }
}