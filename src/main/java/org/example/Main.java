package org.example;

import org.example.configuration.SessionFactoryUtil;

import org.example.dao.*;
import org.example.entity.*;
import org.example.entity.enumeration.CapacityUnit;
import org.example.entity.enumeration.PurchaseUnitType;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        SessionFactoryUtil.getSessionFactory().openSession();

//        TODO: create mockGenerator for fake data (PRIORITY TASK)

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

//        System.out.println(CompanyDao.getCompanyVehiclesDTO(1));

//        System.out.println(CompanyDao.getCompanyByProfitDto(1));

        System.out.println(CompanyDao.getCompanyProfitBetweenDates(1, LocalDate.of(2024, 1, 20), LocalDate.of(2024, 1, 30)));

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
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the ClientDao class
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
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the EmployeeDao class
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

//        System.out.println(EmployeeDao.getEmployeeQualificationsDto(1));

//        System.out.println(EmployeeDao.getEmployeeProfit(1));

//        System.out.println(EmployeeDao.getEmployeeOrders(1));

//        System.out.println(EmployeeDao.getEmployeesBySalary(1400F));
        //EMPLOYEE END

        //PURCHASE START

//        Bus busForPurchase1 = BusDao.getBusById(7);
//        Bus busForPurchase2 = BusDao.getBusById(8);
//        Bus busForPurchase3 = BusDao.getBusById(9);

//        Truck truckForPurchase4 = TruckDao.getTruckById(2);
//        Truck truckForPurchase5 = TruckDao.getTruckById(3);
//        Truck truckForPurchase6 = TruckDao.getTruckById(4);

//        Company companyForPurchase1 = CompanyDao.getCompanyById(1);
//        Company companyForPurchase2 = CompanyDao.getCompanyById(2);
//        Company companyForPurchase3 = CompanyDao.getCompanyById(3);
//        Company companyForPurchase4 = CompanyDao.getCompanyById(4);
//        Company companyForPurchase5 = CompanyDao.getCompanyById(5);
//        Company companyForPurchase6 = CompanyDao.getCompanyById(5);

//        Qualification qualificationForPurchase1 = QualificationDao.getQualificationById(1);
//        Qualification qualificationForPurchase2 = QualificationDao.getQualificationById(2);
//        Qualification qualificationForPurchase3 = QualificationDao.getQualificationById(3);
//        Qualification qualificationForPurchase4 = QualificationDao.getQualificationById(4);
//        Qualification qualificationForPurchase5 = QualificationDao.getQualificationById(5);
//        Qualification qualificationForPurchase6 = QualificationDao.getQualificationById(1);

//        Employee employeeForPurchase1 = EmployeeDao.getEmployeeById(1);
//        Employee employeeForPurchase2 = EmployeeDao.getEmployeeById(2);
//        Employee employeeForPurchase3 = EmployeeDao.getEmployeeById(3);
//        Employee employeeForPurchase4 = EmployeeDao.getEmployeeById(4);
//        Employee employeeForPurchase5 = EmployeeDao.getEmployeeById(5);
//        Employee employeeForPurchase6 = EmployeeDao.getEmployeeById(5);

//        Purchase purchase1 = new Purchase(
//            LocalDate.of(2024, 1, 20),
//            LocalDate.of(2024, 1, 30),
//            "Pleven",
//            "Sofia",
//            1300F,
//            PurchaseUnitType.PEOPLE,
//            20,
//            busForPurchase1,
//            companyForPurchase1,
//            qualificationForPurchase1,
//            employeeForPurchase1
//        );
//
//        Purchase purchase2 = new Purchase(
//            LocalDate.of(2024, 1, 20),
//            LocalDate.of(2024, 1, 30),
//            "Pleven",
//            "Sofia",
//            1300F,
//            PurchaseUnitType.PEOPLE,
//            20,
//            busForPurchase2,
//            companyForPurchase2,
//            qualificationForPurchase2,
//            employeeForPurchase2
//        );
//
//        Purchase purchase3 = new Purchase(
//            LocalDate.of(2024, 1, 20),
//            LocalDate.of(2024, 1, 30),
//            "Pleven",
//            "Sofia",
//            1300F,
//            PurchaseUnitType.PEOPLE,
//            20,
//            busForPurchase3,
//            companyForPurchase3,
//            qualificationForPurchase3,
//            employeeForPurchase3
//        );
//
//        Purchase purchase4 = new Purchase(
//            LocalDate.of(2024, 1, 20),
//            LocalDate.of(2024, 1, 30),
//            "Pleven",
//            "Sofia",
//            1300F,
//            PurchaseUnitType.KG,
//            20,
//            truckForPurchase4,
//            companyForPurchase4,
//            qualificationForPurchase4,
//            employeeForPurchase4
//        );
//
//        Purchase purchase5 = new Purchase(
//            LocalDate.of(2024, 1, 20),
//            LocalDate.of(2024, 1, 30),
//            "Pleven",
//            "Sofia",
//            1300F,
//            PurchaseUnitType.CM,
//            20,
//            truckForPurchase5,
//            companyForPurchase5,
//            qualificationForPurchase5,
//            employeeForPurchase5
//        );
//
//        Purchase purchase6 = new Purchase(
//            LocalDate.of(2024, 1, 20),
//            LocalDate.of(2024, 1, 30),
//            "Pleven",
//            "Sofia",
//            1300F,
//            PurchaseUnitType.POUND,
//            20,
//            truckForPurchase6,
//            companyForPurchase6,
//            qualificationForPurchase6,
//            employeeForPurchase6
//        );
//
//        create a purchase
//        PurchaseDao.createPurchase(purchase1);
//        PurchaseDao.createPurchase(purchase2);
//        PurchaseDao.createPurchase(purchase3);
//        PurchaseDao.createPurchase(purchase4);
//        PurchaseDao.createPurchase(purchase5);
//        PurchaseDao.createPurchase(purchase6);

        //read a purchase (The ORM requires to have a default constructor inside the Company Entity
//        System.out.println(PurchaseDao.getPurchaseById(1));
//        System.out.println(PurchaseDao.getPurchaseById(2));
//        System.out.println(PurchaseDao.getPurchaseById(3));
//        System.out.println(PurchaseDao.getPurchaseById(4));
//        System.out.println(PurchaseDao.getPurchaseById(5));
//        System.out.println(PurchaseDao.getPurchaseById(6));

        //read all purchases
//        System.out.println(PurchaseDao.getAllPurchases());

        //update a purchase
        //means we want to UPDATE the record with primary key (id) 1.
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the PurchaseDao class
//        Company newCompanyForPurchase = CompanyDao.getCompanyById(2);
//        Employee newEmployeeForPurchase = EmployeeDao.getEmployeeById(2);
//        Qualification newQualificationForPurchase = QualificationDao.getQualificationById(2);
//        Bus newBusForPurchase = BusDao.getBusById(8);
//        Purchase newPurchase = new Purchase(
//            LocalDate.of(2024, 1, 20),
//            LocalDate.of(2024, 1, 30),
//                "Varna",
//                "Sofia",
//                1600F,
//                PurchaseUnitType.PEOPLE,
//                50,
//                newBusForPurchase,
//                newCompanyForPurchase,
//                newQualificationForPurchase,
//                newEmployeeForPurchase
//        );
//        newPurchase.setId(1);
//        PurchaseDao.updatePurchase(newPurchase);

        //delete a purchase
//        Purchase purchaseToDelete = PurchaseDao.getPurchaseById(6);
//        PurchaseDao.deletePurchase(purchaseToDelete);

        //PURCHASE END

        //QUALIFICATION START

//        Qualification qualification1 = new Qualification("special_cargo");
//        Qualification qualification2 = new Qualification("dangerous_cargo");
//        Qualification qualification3 = new Qualification("passenger_transport");
//        Qualification qualification4 = new Qualification("heavy_cargo");
//        Qualification qualification5 = new Qualification("oversied_cargo");

        //create a qualification
//        QualificationDao.createQualification(qualification1);
//        QualificationDao.createQualification(qualification2);
//        QualificationDao.createQualification(qualification3);
//        QualificationDao.createQualification(qualification4);
//        QualificationDao.createQualification(qualification5);

        //read a qualification (The ORM requires to have a default constructor inside the Company Entity
//        System.out.println(QualificationDao.getQualificationById(1));
//        System.out.println(QualificationDao.getQualificationById(2));
//        System.out.println(QualificationDao.getQualificationById(3));
//        System.out.println(QualificationDao.getQualificationById(4));
//        System.out.println(QualificationDao.getQualificationById(5));

        //read all qualifications
//        System.out.println(QualificationDao.getAllQualifications());

        //update a qualification
        //means we want to UPDATE the record with primary key (id) 1.
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the QualificationDao class
//        Qualification newQualification = new Qualification();
//        newQualification.setType("special_cargo_new");
//        newQualification.setId(1);
//        QualificationDao.updateQualification(newQualification);

        //delete an qualification
//        Qualification qualificationToDelete = QualificationDao.getQualificationById(1);
//        QualificationDao.deleteQualification(qualificationToDelete);

        //QUALIFICATION END

        //RECEIPT START
//        Client clientForReceipt1 = ClientDao.getClientById(1);
//        Client clientForReceipt2 = ClientDao.getClientById(2);
//        Client clientForReceipt3 = ClientDao.getClientById(3);
//        Client clientForReceipt4 = ClientDao.getClientById(4);
//        Client clientForReceipt5 = ClientDao.getClientById(5);

//        Purchase purchaseForReceipt1 = PurchaseDao.getPurchaseById(1);
//        Purchase purchaseForReceipt2 = PurchaseDao.getPurchaseById(2);
//        Purchase purchaseForReceipt3 = PurchaseDao.getPurchaseById(3);
//        Purchase purchaseForReceipt4 = PurchaseDao.getPurchaseById(4);
//        Purchase purchaseForReceipt5 = PurchaseDao.getPurchaseById(5);

//        Receipt receipt1 = new Receipt(clientForReceipt1, purchaseForReceipt1);
//        Receipt receipt2 = new Receipt(clientForReceipt2, purchaseForReceipt2);
//        Receipt receipt3 = new Receipt(clientForReceipt3, purchaseForReceipt3);
//        Receipt receipt4 = new Receipt(clientForReceipt4, purchaseForReceipt4);
//        Receipt receipt5 = new Receipt(clientForReceipt5, purchaseForReceipt5);

        //create a receipt
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
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the ReceiptsDao class
//        Client newClientForReceipt = ClientDao.getClientById(3);
//        Purchase newPurchaseForReceipt = PurchaseDao.getPurchaseById(3);
//        Receipt newReceipt = new Receipt();
//        newReceipt.setClient(newClientForReceipt);
//        newReceipt.setPurchase(newPurchaseForReceipt);
//        newReceipt.setId(2);
//        ReceiptDao.updateReceipt(newReceipt);

        //delete an receipt
//        Receipt receiptToDelete = ReceiptDao.getReceiptById(1);
//        ReceiptDao.deleteReceipt(receiptToDelete);

        //RECEIPT END

        //BUS START

//        Company companyForBus1 = CompanyDao.getCompanyById(1);
//        Company companyForBus2 = CompanyDao.getCompanyById(2);
//        Company companyForBus3 = CompanyDao.getCompanyById(3);
//        Company companyForBus4 = CompanyDao.getCompanyById(4);
//        Company companyForBus5 = CompanyDao.getCompanyById(5);

//        Bus bus1 = new Bus("RA6246VV", companyForBus1, 10);
//        Bus bus2 = new Bus("SV6246VK", companyForBus2, 20);
//        Bus bus3 = new Bus("WA6246VL", companyForBus3, 30);
//        Bus bus4 = new Bus("PW6246VA", companyForBus4, 40);
//        Bus bus5 = new Bus("OW6246WA", companyForBus5, 50);

        //create a bus
//        BusDao.createBus(bus1);
//        BusDao.createBus(bus2);
//        BusDao.createBus(bus3);
//        BusDao.createBus(bus4);
//        BusDao.createBus(bus5);

        //read a bus (The ORM requires to have a default constructor inside the Company Entity
//        System.out.println(BusDao.getBusById(7));
//        System.out.println(BusDao.getBusById(8));
//        System.out.println(BusDao.getBusById(9));
//        System.out.println(BusDao.getBusById(10));
//        System.out.println(BusDao.getBusById(11));

        //read all buses
//        System.out.println(BusDao.getAllBuses());

        //update a bus
        //means we want to UPDATE the record with primary key (id) 1.
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the BusDao class
//        Company newCompany = CompanyDao.getCompanyById(1);
//        Bus newBus = new Bus();
//        newBus.setSeats(15);
//        newBus.setRegistrationNumber("RA6246VV");
//        newBus.setCompany(newCompany);
//        newBus.setId(7);
//        BusDao.updateBus(newBus);

        //delete a bus
//        Bus busToDelete = BusDao.getBusById(11);
//        BusDao.deleteBus(busToDelete);

        //BUS END

        //TRUCK START

//        Company companyForTruck1 = CompanyDao.getCompanyById(1);
//        Company companyForTruck2 = CompanyDao.getCompanyById(2);
//        Company companyForTruck3 = CompanyDao.getCompanyById(3);
//        Company companyForTruck4 = CompanyDao.getCompanyById(4);
//        Company companyForTruck5 = CompanyDao.getCompanyById(5);

//        Truck truck1 = new Truck("RA6246KS", companyForTruck1, CapacityUnit.KG, 10);
//        Truck truck2 = new Truck("SV6246KS", companyForTruck2, CapacityUnit.ML, 20);
//        Truck truck3 = new Truck("WA6246KS", companyForTruck3, CapacityUnit.INCH, 30);
//        Truck truck4 = new Truck("PW6246KS", companyForTruck4, CapacityUnit.POUND, 40);
//        Truck truck5 = new Truck("OW6246KS", companyForTruck5, CapacityUnit.L, 50);

        //create a truck
//        TruckDao.createTruck(truck1);
//        TruckDao.createTruck(truck2);
//        TruckDao.createTruck(truck3);
//        TruckDao.createTruck(truck4);
//        TruckDao.createTruck(truck5);

        //read a truck (The ORM requires to have a default constructor inside the Company Entity
//        System.out.println(TruckDao.getTruckById(1));
//        System.out.println(TruckDao.getTruckById(2));
//        System.out.println(TruckDao.getTruckById(3));
//        System.out.println(TruckDao.getTruckById(4));
//        System.out.println(TruckDao.getTruckById(5));

        //read all trucks
//        System.out.println(TruckDao.getAllTrucks());

        //update a truck
        //means we want to UPDATE the record with primary key (id) 1.
        //If we omit to set the id, we will perform an INSERT query since we're using saveOrUpdate() session method inside the TruckDao class
//        Company newCompany = CompanyDao.getCompanyById(1);
//        Truck newTruck = new Truck();
//        newTruck.setUnit(CapacityUnit.L);
//        newTruck.setCapacity(10);
//        newTruck.setRegistrationNumber("RA6246KS");
//        newTruck.setCompany(newCompany);
//        newTruck.setId(1);
//        TruckDao.updateTruck(newTruck);

        //delete an truck
//        Truck truckToDelete = TruckDao.getTruckById(1);
//        TruckDao.deleteTruck(truckToDelete);

        //TRUCK END
    }
}