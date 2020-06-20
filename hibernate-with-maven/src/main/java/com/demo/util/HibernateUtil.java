package com.demo.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.demo.model.Capital;
import com.demo.model.Country;
import com.demo.model.Language;
import com.demo.model.State;
import com.demo.model.User;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			// Populate required properties
			Properties properties = new Properties();
			properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
			properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
			properties.setProperty(Environment.USER, "root");
			properties.setProperty(Environment.PASS, "Admin@123!");
			properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			properties.setProperty(Environment.POOL_SIZE, "1");
			properties.setProperty(Environment.SHOW_SQL, "true");
			properties.setProperty(Environment.HBM2DDL_AUTO, "update");

			// Add persistent class into configuration
			Configuration configuration = new Configuration();
			configuration.setProperties(properties);
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Country.class);
			configuration.addAnnotatedClass(State.class);
			configuration.addAnnotatedClass(Capital.class);
			configuration.addAnnotatedClass(Language.class);

			// Create a session factory

			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
