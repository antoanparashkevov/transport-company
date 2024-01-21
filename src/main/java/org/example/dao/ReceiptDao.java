package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Receipt;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReceiptDao {

    //create
    public static void createReceipt(Receipt receipt) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(receipt);

            transaction.commit();
        }
    }

    //read by id
    public static Receipt getReceiptById(long id) {
        Receipt receipt;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            receipt = session.get(Receipt.class, id);

            transaction.commit();
        }
        return receipt;
    }

    //read all
    public static List<Receipt> getAllReceipts() {
        List<Receipt> receipts;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            receipts = session.createQuery("Select c from Receipt c", Receipt.class).getResultList();

            transaction.commit();
        }
        return receipts;
    }

    //update
    public static void updateReceipt(Receipt receipt) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //saveOrUpdate executes either an INSERT query or an UPDATE query depending on whether the record with a given primary key exist or not
            session.saveOrUpdate(receipt);

            transaction.commit();
        }
    }

    //delete
    public static void deleteReceipt(Receipt receipt) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(receipt);

            transaction.commit();
        }
    }
}
