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

    //sum purchases profit
    public static Double sumPurchasesProfit(){
        Double profit;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            profit = session.createQuery("select sum(p.price) From org.example.entity.Purchase p", Double.class)
                    .getSingleResult();

            transaction.commit();
        }
        return profit;
    }

    //sum purchases orders
    public static Long sumPurchasesOrders() {
        Long newOrders;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            newOrders = session.createQuery("select count(p.id) From org.example.entity.Purchase p", Long.class)
                    .getSingleResult();

            transaction.commit();
        }
        return newOrders;
    }

    //order by destination
    public static List<Purchase> getNewOrdersByDestination(String arrivalPoint) {
        List<Purchase> purchases;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            purchases = session.createQuery("select p from org.example.entity.Purchase p" +
                    " where p.arrivalPlace = :arrivalPoint",
                    Purchase.class)
                    .setParameter("arrivalPoint", arrivalPoint)
                    .getResultList();

            transaction.commit();
        }
        return purchases;
    }
}
