package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Purchase;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PurchaseDao {

    //create
    public static void createPurchase(Purchase purchase) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(purchase);

            transaction.commit();
        }
    }

    //read by id
    public static Purchase getPurchaseById(long id) {
        Purchase purchase;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            purchase = session.get(Purchase.class, id);

            transaction.commit();
        }
        return purchase;
    }

    //read all
    public static List<Purchase> getAllPurchases() {
        List<Purchase> purchases;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            purchases = session.createQuery("Select c from Purchase c", Purchase.class).getResultList();

            transaction.commit();
        }
        return purchases;
    }

    //update
    public static void updatePurchase(Purchase purchase) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //saveOrUpdate executes either an INSERT query or an UPDATE query depending on whether the record with a given primary key exist or not
            session.saveOrUpdate(purchase);

            transaction.commit();
        }
    }

    //delete
    public static void deletePurchase(Purchase purchase) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(purchase);

            transaction.commit();
        }
    }
}
