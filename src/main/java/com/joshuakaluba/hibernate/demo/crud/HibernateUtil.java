package com.joshuakaluba.hibernate.demo.crud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
public class HibernateUtil {
     
    public static final SessionFactory sessionFactory;
    public static final ServiceRegistry serviceRegistry;
     
    static {
        Configuration conf = new Configuration();
        conf.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        try {
            sessionFactory = conf.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }       
    }
     
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}