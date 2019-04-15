package com.agc.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Transaction {
	
	public static void saveEntity(Object entity) {
		SessionFactory sessionFactory = SessionFactoryProvider.getInstance();
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(entity);
		
		session.getTransaction().commit();
	}

}
