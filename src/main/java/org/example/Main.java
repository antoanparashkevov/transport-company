package org.example;

import org.example.configuration.SessionFactoryUtil;

import org.example.dao.ClientDao;
import org.example.dao.CompanyDao;
import org.example.entity.Client;
import org.example.entity.Company;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        SessionFactoryUtil.getSessionFactory().openSession();

        //COMPANY START

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
//      Company newCompany = new Company();
//      newCompany.setId(1);
//      newCompany.setCompanyName("newSAP");
//      newCompany.setFoundationDate(LocalDate.of(2024,1, 1));
//      CompanyDao.updateCompany(newCompany);

        //delete a company
//      Company companyToDelete = CompanyDao.getCompanyById(5);
//      CompanyDao.deleteCompany(companyToDelete);

//      System.out.println(CompanyDao.companyFindByCompanyName("VM"));//no result found for query
//      System.out.println(CompanyDao.companyFindByCompanyName("SAP"));

//      System.out.println(CompanyDao.companyFindByCompanyNameStartingWith("S"));

//      System.out.println(CompanyDao.getCompanyEmployees(1));

//      System.out.println(CompanyDao.getCompanyEmployeesDTO(1));

        //COMPANY END

        //CLIENT START

//        Client client1 = new Client("Antoan", "Parashkevov", "0877268726");
//        Client client2 = new Client("Ivan", "Ivanov", "0877268725");
//        Client client3 = new Client("Petko", "Petkov", "0877268724");
//        Client client4 = new Client("Svetlozar", "Georgiev", "0877268723");
//        Client client5 = new Client("Pavel", "Draganov", "0877268722");

        //create a client
//        ClientDao.createClient(client1);
//        ClientDao.createClient(client2);
//        ClientDao.createClient(client3);
//        ClientDao.createClient(client4);
//        ClientDao.createClient(client5);

        //read a client (The ORM requires to have a default constructor inside the Company Entity
//        System.out.println(ClientDao.getClientById(1));
//        System.out.println(ClientDao.getClientById(2));
//        System.out.println(ClientDao.getClientById(3));
//        System.out.println(ClientDao.getClientById(4));
//        System.out.println(ClientDao.getClientById(5));

        //read all clients
//        System.out.println(ClientDao.getAllClients());

        //update a client
        //means we want to UPDATE the record with primary key (id) 1.
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the CompanyDao class
//          Client newClient = new Client();
//          newClient.setFirstName("AntoanNew");
//          newClient.setLastName("ParashkevovNew");
//          newClient.setPhoneNumber("0877268727");
//          newClient.setId(1);
//          ClientDao.updateClient(newClient);
        //CLIENT END

        //delete a client
//        Client clientToDelete = ClientDao.getClientById(6);
//        ClientDao.deleteClient(clientToDelete);
    }
}