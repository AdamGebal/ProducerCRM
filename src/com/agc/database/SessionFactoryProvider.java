package com.agc.database;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agc.entity.Producer;

public class SessionFactoryProvider {
	
	private static final String CONFIGURATION_FILE_PATH = "config/database/hibernate.cfg.xml";
	private static SessionFactory SESSION_FACTORY;
	
	private SessionFactoryProvider() {}
	
	public static SessionFactory getSessionFactory() {
		if(SESSION_FACTORY == null) {
			init();
		}
		return SESSION_FACTORY;
	}
	
	private static void init() {
		File configurationFile = new File(CONFIGURATION_FILE_PATH);
		SESSION_FACTORY = new Configuration().configure(configurationFile)
						   .addAnnotatedClass(Producer.class)
						   .buildSessionFactory();
	}
	
	

}