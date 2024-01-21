package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {

    //create
    public static void createEmployee(Employee employee) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(employee);

            transaction.commit();
        }
    }

    //read by id
    public static Employee getEmployeeById(long id) {
        Employee employee;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            employee = session.get(Employee.class, id);

            transaction.commit();
        }
        return employee;
    }

    //read all
    public static List<Employee> getAllEmployees() {
        List<Employee> employees;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            employees = session.createQuery("Select c from Employee c", Employee.class).getResultList();

            transaction.commit();
        }
        return employees;
    }

    //update
    public static void updateEmployee(Employee employee) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //saveOrUpdate executes either an INSERT query or an UPDATE query depending on whether the record with a given primary key exist or not
            session.saveOrUpdate(employee);

            transaction.commit();
        }
    }

    //delete
    public static void deleteEmployee(Employee employee) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(employee);

            transaction.commit();
        }
    }
}