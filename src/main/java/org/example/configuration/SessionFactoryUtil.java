package org.example.configuration;

import org.example.entity.Company;
//import org.example.entity.CompanyEvent;
//import org.example.entity.Employee;
//import org.example.entity.IdentityCard;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Company.class);
//            configuration.addAnnotatedClass(Employee.class);
//            configuration.addAnnotatedClass(CompanyEvent.class);
//            configuration.addAnnotatedClass(IdentityCard.class);
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}
