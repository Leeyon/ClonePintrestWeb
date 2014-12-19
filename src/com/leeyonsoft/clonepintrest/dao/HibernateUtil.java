package com.leeyonsoft.clonepintrest.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	//In local ,we support singleton session factory
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static final String _cfgFilePath="/com/leeyonsoft/clonepintrest/dao/hibernate.cfg.xml";
	

	private static SessionFactory buildSessionFactory() {

		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration()
					.configure(_cfgFilePath);
			
			ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().
					applySettings(configuration.getProperties()).build();  

			return configuration.buildSessionFactory(serviceRegistry);  

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
