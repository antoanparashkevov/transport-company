package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.QualificationDto;
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

    //retrieves the employee's qualifications
    public static List<QualificationDto> getEmployeeQualificationsDto(long id) {
        List<QualificationDto> qualifications;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            qualifications = session.createQuery("select new org.example.dto.QualificationDto(q.id, q.type) from Qualification q"
                    + " join q.employees e "
                    + "where e.id = :id",
                    QualificationDto.class)
                    .setParameter("id", id)
                    .getResultList();

            transaction.commit();
        }
        return qualifications;
    }

    //retrieves the employee's profit
    public static Double getEmployeeProfit(long id ) {
        Double profit;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            profit = session.createQuery(" select sum(p.price) from Employee e" +
                    " join e.purchases p" +
                    " join p.receipts r" +
                    " where r.id is not null and e.id = :id",
                    Double.class)
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();
        }
        return profit;
    }

    //retrieves the number of orders of a specified employee's id
    public static Long getEmployeeOrders(long id) {
        Long numberOfOrders;
        //TODO: is it correct? Long?
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            numberOfOrders = session.createQuery("select count(p.id) from Employee e" +
                    " join e.purchases p" +
                    " where e.id = :id",
                    Long.class)
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();
        }
        return numberOfOrders;
    }

    //retrieves all employees that have the passed salary
    public static List<Employee> getEmployeesBySalary(float salary) {
        List<Employee> employees;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            employees = session.createQuery("select e from org.example.entity.Employee e"+
                    " where e.salary = :salary",
                    Employee.class)
                    .setParameter("salary", salary)
                    .getResultList();

            transaction.commit();
        }
        return employees;
    }
}
