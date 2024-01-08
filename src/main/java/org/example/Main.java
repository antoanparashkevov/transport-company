package org.example;

import org.example.configuration.SessionFactoryUtil;

import org.example.dao.CompanyDao;
import org.example.entity.Company;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        SessionFactoryUtil.getSessionFactory().openSession();

//      Company company = new Company("SAP", LocalDate.of(2024, 1, 1));

        //create a company
//      CompanyDao.createCompany(company);

        //read a company (The ORM requires to have a default constructor inside the Company Entity
//      System.out.println(CompanyDao.getCompanyById(1));

        //read all companies
//      System.out.println(CompanyDao.getAllCompanies());

        //update a company
//      company.setId(1);//means we want to UPDATE the record with primary key (id) 1. If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the CompanyDao class
//      CompanyDao.updateCompany(company);

        //delete a company
//      CompanyDao.deleteCompany(company);


//      System.out.println(CompanyDao.companyFindByCompanyName("VM"));

//      System.out.println(CompanyDao.companyFindByCompanyNameStartingWith("S"));

//      System.out.println(CompanyDao.getCompanyEmployees(1));

//      System.out.println(CompanyDao.getCompanyEmployeesDTO(1));


    }
}