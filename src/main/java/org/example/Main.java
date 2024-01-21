package org.example;

import org.example.configuration.SessionFactoryUtil;

import org.example.dao.ClientDao;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDao;
import org.example.dao.QualificationDao;
import org.example.entity.*;

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

        //delete a client
//        Client clientToDelete = ClientDao.getClientById(6);
//        ClientDao.deleteClient(clientToDelete);

        //CLIENT END

        //EMPLOYEE START
//        Company companyToWork1 = CompanyDao.getCompanyById(1);
//        Company companyToWork2 = CompanyDao.getCompanyById(2);
//        Company companyToWork3 = CompanyDao.getCompanyById(3);
//        Company companyToWork4 = CompanyDao.getCompanyById(4);
//        Company companyToWork5 = CompanyDao.getCompanyById(5);

//        Employee employee1 = new Employee("Antoan", "Parashkevov", 1500.00F, companyToWork1);
//        Employee employee2 = new Employee("Ivan", "Ivanov", 1400.00F, companyToWork2);
//        Employee employee3 = new Employee("Petko", "Petkov", 1300.00F, companyToWork3);
//        Employee employee4 = new Employee("Svelozar", "Georgiev", 1200.00F, companyToWork4);
//        Employee employee5 = new Employee("Pavel", "Dragano", 1100.00F, companyToWork5);

        //create an employee
//        EmployeeDao.createEmployee(employee1);
//        EmployeeDao.createEmployee(employee2);
//        EmployeeDao.createEmployee(employee3);
//        EmployeeDao.createEmployee(employee4);
//        EmployeeDao.createEmployee(employee5);

        //read an employee (The ORM requires to have a default constructor inside the Company Entity
//        System.out.println(EmployeeDao.getEmployeeById(1));
//        System.out.println(EmployeeDao.getEmployeeById(2));
//        System.out.println(EmployeeDao.getEmployeeById(3));
//        System.out.println(EmployeeDao.getEmployeeById(4));
//        System.out.println(EmployeeDao.getEmployeeById(5));

        //read all employees
//        System.out.println(EmployeeDao.getAllEmployees());

        //update an employee
        //means we want to UPDATE the record with primary key (id) 1.
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the CompanyDao class
//        Company newCompanyToWork = CompanyDao.getCompanyById(2);
//        Employee newEmployee = new Employee();
//        newEmployee.setFirstName("AntoanNew");
//        newEmployee.setLastName("ParashkevovNew");
//        newEmployee.setSalary(1300F);
//        newEmployee.setCompany(newCompanyToWork);
//        newEmployee.setId(1);
//        EmployeeDao.updateEmployee(newEmployee);

        //delete an employee
//        Employee employeeToDelete = EmployeeDao.getEmployeeById(1);
//        EmployeeDao.deleteEmployee(employeeToDelete);

        //EMPLOYEE END

        //PURCHASE START
//        Vehicle vehicle1 =

//        Company companyForPurchase1 = CompanyDao.getCompanyById(1);
//        Company companyForPurchase2 = CompanyDao.getCompanyById(2);
//        Company companyForPurchase3 = CompanyDao.getCompanyById(3);
//        Company companyForPurchase4 = CompanyDao.getCompanyById(4);
//        Company companyForPurchase5 = CompanyDao.getCompanyById(5);

//        Purchase purchase1 = new Purchase(
//                LocalDate.of(2024, 1, 20),
//                LocalDate.of(2024, 1, 30),
//                "Pleven",
//                "Sofia",
//                1300F,
//
//        );
//        Purchase purchase2 = new Purchase("Ivan", "Ivanov", 1400.00F, companyToWork2);
//        Purchase purchase3 = new Purchase("Petko", "Petkov", 1300.00F, companyToWork3);
//        Purchase purchase4 = new Purchase("Svelozar", "Georgiev", 1200.00F, companyToWork4);
//        Purchase purchase5 = new Purchase("Pavel", "Dragano", 1100.00F, companyToWork5);

        //create an purchase
//        PurchaseDao.createPurchase(purchase1);
//        PurchaseDao.createPurchase(purchase2);
//        PurchaseDao.createPurchase(purchase3);
//        PurchaseDao.createPurchase(purchase4);
//        PurchaseDao.createPurchase(purchase5);

        //read an purchase (The ORM requires to have a default constructor inside the Company Entity
//        System.out.println(PurchaseDao.getPurchaseById(1));
//        System.out.println(PurchaseDao.getPurchaseById(2));
//        System.out.println(PurchaseDao.getPurchaseById(3));
//        System.out.println(PurchaseDao.getPurchaseById(4));
//        System.out.println(PurchaseDao.getPurchaseById(5));

        //read all purchases
//        System.out.println(PurchaseDao.getAllPurchases());

        //update an purchase
        //means we want to UPDATE the record with primary key (id) 1.
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the CompanyDao class
//        Company newCompanyToWork = CompanyDao.getCompanyById(2);
//        Purchase newPurchase = new Purchase();
//        newEmployee.setFirstName("AntoanNew");
//        newEmployee.setLastName("ParashkevovNew");
//        newEmployee.setSalary(1300F);
//        newEmployee.setCompany(newCompanyToWork);
//        newEmployee.setId(1);
//        PurchaseDao.updateEmployee(newEmployee);

        //delete an purchase
//        Purchase purchaseToDelete = PurchaseDao.getPurchaseById(1);
//        PurchaseDao.deleteEmployee(purchaseToDelete);

        //PURCHASE END

        //QUALIFICATION START

//        Qualification qualification1 = new Qualification("special_cargo");
//        Qualification qualification2 = new Qualification("dangerous_cargo");
//        Qualification qualification3 = new Qualification("passenger_transport");
//        Qualification qualification4 = new Qualification("heavy_cargo");
//        Qualification qualification5 = new Qualification("oversied_cargo");

        //create an qualification
//        QualificationDao.createQualification(qualification1);
//        QualificationDao.createQualification(qualification2);
//        QualificationDao.createQualification(qualification3);
//        QualificationDao.createQualification(qualification4);
//        QualificationDao.createQualification(qualification5);

        //read an qualification (The ORM requires to have a default constructor inside the Company Entity
//        System.out.println(QualificationDao.getQualificationById(1));
//        System.out.println(QualificationDao.getQualificationById(2));
//        System.out.println(QualificationDao.getQualificationById(3));
//        System.out.println(QualificationDao.getQualificationById(4));
//        System.out.println(QualificationDao.getQualificationById(5));

        //read all qualifications
//        System.out.println(QualificationDao.getAllQualifications());

        //update a qualification
        //means we want to UPDATE the record with primary key (id) 1.
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the CompanyDao class
//        Qualification newQualification = new Qualification();
//        newQualification.setType("special_cargo_new");
//        newQualification.setId(1);
//        QualificationDao.updateQualification(newQualification);

        //delete an qualification
//        Qualification qualificationToDelete = QualificationDao.getQualificationById(1);
//        QualificationDao.deleteQualification(qualificationToDelete);

        //QUALIFICATION END

        //RECEIPT START

//        Receipt receipt1 = new Receipt();
//        Receipt receipt2 = new Receipt();
//        Receipt receipt3 = new Receipt();
//        Receipt receipt4 = new Receipt();
//        Receipt receipt5 = new Receipt();

        //create an receipt
//        ReceiptDao.createReceipt(receipt1);
//        ReceiptDao.createReceipt(receipt2);
//        ReceiptDao.createReceipt(receipt3);
//        ReceiptDao.createReceipt(receipt4);
//        ReceiptDao.createReceipt(receipt5);

        //read a receipt (The ORM requires to have a default constructor inside the Company Entity
//        System.out.println(ReceiptDao.getReceiptById(1));
//        System.out.println(ReceiptDao.getReceiptById(2));
//        System.out.println(ReceiptDao.getReceiptById(3));
//        System.out.println(ReceiptDao.getReceiptById(4));
//        System.out.println(ReceiptDao.getReceiptById(5));

        //read all receipts
//        System.out.println(ReceiptDao.getAllReceipts());

        //update a receipt
        //means we want to UPDATE the record with primary key (id) 1.
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the CompanyDao class
//        Receipt newReceipt = new Receipt();
//        newReceipt.setClient();
//        newReceipt.setPurchase();
//        newReceipt.setId(1);
//        ReceiptDao.updateReceipt(newReceipt);

        //delete an receipt
//        Receipt receiptToDelete = ReceiptDao.getReceiptById(1);
//        ReceiptDao.deleteReceipt(receiptToDelete);

        //RECEIPT END

        //VEHICLE START

        //VEHICLE END
    }
}