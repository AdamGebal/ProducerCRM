package com.agc.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.agc.entity.iface.IHavingPublicID;

public class Transaction {
	
	private final static Logger logger = Logger.getLogger(Transaction.class); 
	
	public static void saveEntity(Object entity) {
		SessionFactory sessionFactory = SessionFactoryProvider.getInstance();
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		try {
			session.save(entity);
			session.getTransaction().commit();
		} catch(Exception e){
			logger.error(e.getMessage() + " | " + entity.toString());
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
	}
	
	public static void saveEntities(List<Object> entities) {
		SessionFactory sessionFactory = SessionFactoryProvider.getInstance();
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		try {
			for(Object entity : entities) {
				session.save(entity);
			}
			session.getTransaction().commit();
		} catch(Exception e){
			logger.error(e.getMessage() + " | " + entities.toString());
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}
	
	public static <T> List<T> getEntities(String name, Class<T> resultType) {
		SessionFactory sessionFactory = SessionFactoryProvider.getInstance();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		List<T> entitiesList;
		try {
			entitiesList = session.createQuery("from " + name, resultType).getResultList();
		} catch(Exception e){
			throw new RuntimeException(e);
		} finally {
			session.close();
		}		
		session.close();
		
		return entitiesList;
	}
	
	public static <T> T getSingleEntity(String name, Map<String,String> searchCriteria, Class<T> resultType) {
		SessionFactory sessionFactory = SessionFactoryProvider.getInstance();
		Session session = sessionFactory.getCurrentSession();
		StringBuilder searchCriteriaStringBuilder = new StringBuilder();
		searchCriteria.forEach( (k,v) -> { searchCriteriaStringBuilder.append(k)
																		.append(" = '")
																		.append(v)
																		.append("' and "); });
		
		String searchCriteriaString = searchCriteriaStringBuilder
										.substring(0, searchCriteriaStringBuilder.lastIndexOf("and"));
		session.beginTransaction();
		T entity = null;
		try {
			entity = (T) session.createQuery("from " + name + " where " + searchCriteriaString, resultType).getSingleResult();
		} catch(Exception e){
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		
		return entity;
	}
	
	public static Map<String, String> createANDSearchCriteriaMap(String... criteria){
		if(criteria.length % 2 !=0) {
			throw new RuntimeException("Unequal number of criteria and parameters");
		}
		Map<String, String> searchCriteriaMap = new HashMap<>();
		for(int i = 0; i < criteria.length; i+=2) {
			searchCriteriaMap.put(criteria[i], criteria[i+1]);
		}
		
		return searchCriteriaMap;
		
	}
	
	public static <T extends IHavingPublicID> T getEntityBasedOnPublicID(Class<T> entityType, String publicID) {		
		return getSingleEntity( entityType.getName(), 
									createANDSearchCriteriaMap("publicid", publicID), 
									entityType);		
	}

}
