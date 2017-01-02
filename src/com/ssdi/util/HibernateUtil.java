package com.ssdi.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	public HibernateUtil()
	{
		SessionFactory sessionFactoryObj = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		sessionFactory = sessionFactoryObj;
	}

	private static SessionFactory sessionFactory;

	public static void initializeSessionFactory(){
		try {
			SessionFactory sessionFactoryObj = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			sessionFactory = sessionFactoryObj;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}
}