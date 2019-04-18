package com.agc.web.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class CustomContextListener implements ServletContextListener {

	private final static Logger logger = Logger.getLogger(CustomContextListener.class); 
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while(drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			if(driver instanceof SQLServerDriver) {
				try {
					DriverManager.deregisterDriver(driver);
				} catch (SQLException e) {
					logger.info("Could not deregister driver:".concat(e.getMessage()));
				}
			}
		}

	}
}
