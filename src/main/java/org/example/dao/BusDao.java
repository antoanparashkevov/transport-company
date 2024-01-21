package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Bus;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BusDao {

    //create
    public static void createBus(Bus bus) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(bus);

            transaction.commit();
        }
    }

    //read by id
    public static Bus getBusById(long id) {
        Bus bus;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            bus = session.get(Bus.class, id);

            transaction.commit();
        }
        return bus;
    }

    //read all
    public static List<Bus> getAllBusses() {
        List<Bus> busses;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            busses = session.createQuery("Select c from Bus c", Bus.class).getResultList();

            transaction.commit();
        }
        return busses;
    }

    //update
    public static void updateBus(Bus bus) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //saveOrUpdate executes either an INSERT query or an UPDATE query depending on whether the record with a given primary key exist or not
            session.saveOrUpdate(bus);

            transaction.commit();
        }
    }

    //delete
    public static void deleteBus(Bus bus) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(bus);

            transaction.commit();
        }
    }
}
