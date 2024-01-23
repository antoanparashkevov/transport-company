package org.example.dao;

//DAO - Data Access object

//DAO layer
//there is no need to add any annotations since we get the session from the session configuration in order to communicate with the database

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.CompanyDto;
import org.example.dto.CompanyProfitDto;
import org.example.dto.EmployeeDto;
import org.example.dto.VehicleDto;
import org.example.entity.Company;

import org.example.entity.Employee;
import org.example.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class CompanyDao {

    //create
    public static void createCompany(Company company) {

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(company);

            transaction.commit();
        }
    }

    //read by id
    public static Company getCompanyById(long id) {
        Company company;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            company = session.get(Company.class, id);

            transaction.commit();
        }
        return company;
    }

    //read all
    public static List<Company> getAllCompanies() {
        List<Company> companies;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            companies = session.createQuery("Select c From Company c", Company.class).getResultList();

            transaction.commit();
        }

        return companies;
    }

    //update
    public static void updateCompany(Company company) {

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //saveOrUpdate executes either an INSERT query or an UPDATE query depending on whether the record with a given primary key exist or not
            session.saveOrUpdate(company);

            transaction.commit();
        }
    }

    //delete
    public static void deleteCompany(Company company) {

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(company);

            transaction.commit();
        }
    }

    //criteria builder abstraction START

    public static Company companyFindByCompanyName(String companyName) {

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {

            //create a criteria builder
            CriteriaBuilder cb = session.getCriteriaBuilder();

            //create a criteria query using the criteria builder
            CriteriaQuery<Company> cq = cb.createQuery(Company.class);

            //create a root pointing to the entity that we want to perform the criteria query
            Root<Company> root = cq.from(Company.class);

            //perform the query using the criteria query we've created above
            cq.select(root).where(cb.equal(root.get("companyName"), companyName));

            //create another query using the already created one
            Query<Company> query = session.createQuery(cq);

            //get the results from the newest query
            Company company = query.getSingleResult();

            //return the results
            return company;

        }
    }

    public static Company companyFindByCompanyNameStartingWith(String companyName) {

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {

            //  can be accomplished by this
//            StringBuilder queryString = new StringBuilder("select c from Company c" +
//                    " where c.companyName like concat(:companyName, '%')");
            //create a criteria builder
            CriteriaBuilder cb = session.getCriteriaBuilder();

            //create a criteria query using the criteria builder
            CriteriaQuery<Company> cq = cb.createQuery(Company.class);

            //create a root pointing to the entity that we want to perform the criteria query
            Root<Company> root = cq.from(Company.class);

            //perform the query using the criteria query we've created above
            cq.select(root).where(cb.like(root.get("companyName"), companyName));

            //create another query using the already created one
            Query<Company> query = session.createQuery(cq);

            //get the results from the newest query
            Company company = query.getSingleResult();

            //return the results
            return company;

        }
    }

    //criteria builder abstraction END

    //join fetch methodology for fetching all employees from a given company id criteria
    public static Set<Employee> getCompanyEmployees(long id) {
        Company company;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //HQL - Hibernate Query Language
            company = session.createQuery(
                            "select c from Company c" +
                                    " join fetch c.employees" +
                                    " where c.id = :id",
                            Company.class
                    )
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();

        }

        return company.getEmployees();//will call the Employee toString()
    }

    //retrieves a list of employees of a specified company id
    public static List<EmployeeDto> getCompanyEmployeesDTO(long id) {
        List<EmployeeDto> employees;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //HQL - Hibernate Query Language
            employees = session.createQuery(
                            "select new org.example.dto.EmployeeDto(e.id, e.firstName, e.lastName, e.salary) from Employee e" +
                                    " join e.company c" +
                                    " where c.id = :id",
                            EmployeeDto.class
                    )
                    .setParameter("id", id)
                    .getResultList();

            transaction.commit();

        }

        return employees;//will call the EmployeeDTO toString()
    }

    //retrieves a list of vehicles of a specified company id
    public static List<VehicleDto> getCompanyVehiclesDTO(long id) {
        List<VehicleDto> vehicles;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //HQL - Hibernate Query Language
            vehicles = session.createQuery(
                "select new org.example.dto.VehicleDto(v.id, v.registrationNumber, c.companyName) from Vehicle v" +
                        " join v.company c" +
                        " where c.id = :id",
                VehicleDto.class)
                .setParameter("id", id)
                .getResultList();

            transaction.commit();
        }
        return vehicles;
    }

    //retrieves the profit of a specified company id
    public static Double getCompanyByProfitDto(long id) {
        Double profits;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            profits = session.createQuery(" select sum(p.price) from Company c" +
                " join c.purchases p" +
                " join p.receipts r" +
                " where r.id is not null and c.id = :id" +
                " group by c.id, c.companyName",
                Double.class
            )
            .setParameter("id", id)
            .getSingleResult();

            transaction.commit();
        }
        return profits;
    }

    //gives the profit of company with id in time period
    public static Double getCompanyProfitBetweenDates(long id, LocalDate startTime, LocalDate endTime) {
        Double profit;//Double class acts as a wrapper for double type

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            profit = session.createQuery(" select sum(p.price) from Company c" +
                                    " join c.purchases p " +
                                    " join p.receipts r" +
                                    " where r.id is not null and c.id = :id" +
                                    " and p.startTime >= :startTime" +
                                    " and p.endTime <= :endTime",
                            Double.class)
                    .setParameter("id", id)
                    .setParameter("startTime", startTime)
                    .setParameter("endTime", endTime)
                    .getSingleResult();
            transaction.commit();
        }
        return profit;
    }

    //filters companies by companyName
    public static List<Company> filterByName(String companyName, String sort) {
        List<Company> companies;
        //TODO: enum

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            //StringBuilder acts as a wrapper -> String

            StringBuilder queryString = new StringBuilder("select c from Company c" +
                    " where c.companyName like concat('%', :companyName, '%')");

            if (sort != null) {

                queryString.append(" order by companyName ").append(sort);
            }

            companies = session.createQuery(queryString.toString(), Company.class)
                    .setParameter("companyName", companyName)
                    .getResultList();
            transaction.commit();
        }

        return companies;
    }

    //13 000 -> List<CompanyDto> === 13 000
    public static List<CompanyProfitDto> filterByProfit(Float profit, String operator, String sort) {
        List<CompanyProfitDto> companies;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            if( sort == null || !sort.equals("desc") && !sort.equals("asc") ) {
                sort = "asc";
            }

            //sum() - aggregate function
            companies = session.createQuery("select new org.example.dto.CompanyProfitDto(c.id, c.companyName, sum(p.price)) from Company c" +
                    " join c.purchases p" +
                    " join p.receipts r" +
                    " group by c.id" +
                    " having sum(p.price) " + operator + " " + profit.toString() +
                    " order by sum(p.price) " + sort,
                    CompanyProfitDto.class)
                    .getResultList();

            transaction.commit();
        }

        return companies;
    }
}
