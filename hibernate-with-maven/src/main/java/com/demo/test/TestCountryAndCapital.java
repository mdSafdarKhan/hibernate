package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.model.Capital;
import com.demo.model.Country;
import com.demo.util.HibernateUtil;

public class TestCountryAndCapital {

	public static void main(String[] args) {
		
		Country country = new Country("USA", "320000000");
		
		Capital capital = new Capital("WASHINGTON DC", "7600000");
		
		country.setCapital(capital);
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(country);
		tx.commit();
		session.close();
	}

}
