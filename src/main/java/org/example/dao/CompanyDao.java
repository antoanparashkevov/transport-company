package org.example.dao;

//DAO - Data Access object

//DAO layer
//there is no need to add any annotations since we get the session from the session configuration in order to communicate with the database

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.EmployeeDto;
import org.example.entity.Company;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

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

    public static List<EmployeeDto> getCompanyEmployeesDTO(long id) {
        List<EmployeeDto> employees;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

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

}
