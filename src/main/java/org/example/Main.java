package org.example;

import org.example.configuration.SessionFactoryUtil;

import org.example.dao.CompanyDao;
import org.example.entity.Company;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world");

        SessionFactoryUtil.getSessionFactory().openSession();

        Company company = new Company("SAP", LocalDate.of(2020, 3, 3));

//        CompanyDao.createCompany(company);//create

//        System.out.println(CompanyDao.getCompanyById(1));//read (The ORM requires to have a default constructor inside the Company Entity

        System.out.println(CompanyDao.getAllCompanies());
    }
}