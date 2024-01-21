package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDao {

    //create
    public static void createClient(Client client) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(client);

            transaction.commit();
        }
    }

    //read by id
    public static Client getClientById(long id) {
        Client client;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            client = session.get(Client.class, id);

            transaction.commit();
        }
        return client;
    }

    //read all
    public static List<Client> getAllClients() {
        List<Client> clients;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            clients = session.createQuery("Select c from Client c", Client.class).getResultList();

            transaction.commit();
        }
        return clients;
    }

    //update
    public static void updateClient(Client client) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //saveOrUpdate executes either an INSERT query or an UPDATE query depending on whether the record with a given primary key exist or not
            session.saveOrUpdate(client);

            transaction.commit();
        }
    }

    //delete
    public static void deleteClient(Client client) {

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(client);

            transaction.commit();
        }
    }
}
