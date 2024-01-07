package org.example.dao;

//DAO - Data Access object

//DAO layer
//there is no need to add any annotations since we get the session from the session configuration in order to communicate with the database

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDao {

    public static void createCompany(Company company) {

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(company);

            transaction.commit();
        }
    }

    public static Company getCompanyById(long id) {
        Company company;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            company = session.get(Company.class, id);

            transaction.commit();
        }
        return company;
    }

    public static List<Company> getAllCompanies() {
        List<Company> companies;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            companies = session.createQuery("Select c From Company c", Company.class).getResultList();

            transaction.commit();
        }

        return companies;
    }
}
