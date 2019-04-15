package com.agc.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Transaction {
	
	public static void saveEntity(Object entity) {
		SessionFactory sessionFactory = SessionFactoryProvider.getInstance();
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(entity);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	public static List<? extends Object> getEntities(String name) {
		SessionFactory sessionFactory = SessionFactoryProvider.getInstance();
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		List<?> entitiesList = session.createQuery("from " + name).getResultList();
				
		session.close();
		
		return entitiesList;
	}

}
