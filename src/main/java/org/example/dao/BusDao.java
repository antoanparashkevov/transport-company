package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Bus;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BusDao {

    public static void createBus(Bus bus) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession())
        {
            Transaction transaction = session.beginTransaction();

            session.save(bus);

            transaction.commit();
        }
    }
}
