package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Qualification;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class QualificationDao {

    //create
    public static void createQualification(Qualification qualification) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(qualification);

            transaction.commit();
        }
    }

    //read by id
    public static Qualification getQualificationById(long id) {
        Qualification qualification;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            qualification = session.get(Qualification.class, id);

            transaction.commit();
        }
        return qualification;
    }

    //read all
    public static List<Qualification> getAllQualifications() {
        List<Qualification> qualifications;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            qualifications = session.createQuery("Select c from Qualification c", Qualification.class).getResultList();

            transaction.commit();
        }
        return qualifications;
    }

    //update
    public static void updateQualification(Qualification qualification) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //saveOrUpdate executes either an INSERT query or an UPDATE query depending on whether the record with a given primary key exist or not
            session.saveOrUpdate(qualification);

            transaction.commit();
        }
    }

    //delete
    public static void deleteQualification(Qualification qualification) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(qualification);

            transaction.commit();
        }
    }
}
