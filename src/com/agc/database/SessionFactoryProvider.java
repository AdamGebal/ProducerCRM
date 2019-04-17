package com.agc.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agc.entity.Producer;
import com.agc.entity.ProducerCode;

public class SessionFactoryProvider {
	
	private static final String CONFIGURATION_FILE = "database/hibernate.cfg.xml";
	private static SessionFactory SESSION_FACTORY;
	
	private SessionFactoryProvider() {}
	
	public static SessionFactory getInstance() {
		if(SESSION_FACTORY == null) {
			init();
		}
		return SESSION_FACTORY;
	}
	
	private static void init() {
		SESSION_FACTORY = new Configuration().configure(CONFIGURATION_FILE)
						   .addAnnotatedClass(Producer.class)
						   .addAnnotatedClass(ProducerCode.class)
						   .buildSessionFactory();
	}
	
	

}
