package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Truck;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TruckDao {

    //create
    public static void createTruck(Truck truck) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(truck);

            transaction.commit();
        }
    }

    //read by id
    public static Truck getTruckById(long id) {
        Truck truck;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            truck = session.get(Truck.class, id);

            transaction.commit();
        }
        return truck;
    }

    //read all
    public static List<Truck> getAllTrucks() {
        List<Truck> truckses;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            truckses = session.createQuery("Select c from Truck c", Truck.class).getResultList();

            transaction.commit();
        }
        return truckses;
    }

    //update
    public static void updateTruck(Truck truck) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //saveOrUpdate executes either an INSERT query or an UPDATE query depending on whether the record with a given primary key exist or not
            session.saveOrUpdate(truck);

            transaction.commit();
        }
    }

    //delete
    public static void deleteTruck(Truck truck) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(truck);

            transaction.commit();
        }
    }
}
