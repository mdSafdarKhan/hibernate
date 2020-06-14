package com.example.demo.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.example.demo.model.Country;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			// Properties
			Properties properties = new Properties();
			properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
			properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/spring-rest-hibernate");
			properties.setProperty(Environment.USER, "root");
			properties.setProperty(Environment.PASS, "Admin@123!");
			properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			properties.setProperty(Environment.POOL_SIZE, "10");
			properties.setProperty(Environment.SHOW_SQL, "true");
			properties.setProperty(Environment.HBM2DDL_AUTO, "update");

			// Configuration
			Configuration configuration = new Configuration();
			configuration.setProperties(properties);
			configuration.addAnnotatedClass(Country.class);

			// SessionFactory
			sessionFactory = configuration.buildSessionFactory(
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		}

		return sessionFactory;
	}
}
