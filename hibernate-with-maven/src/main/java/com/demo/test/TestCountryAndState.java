package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.model.Country;
import com.demo.model.State;
import com.demo.util.HibernateUtil;

public class TestCountryAndState {
	
	public static void main(String[] args) {
		
		Country country = new Country("INDIA", "130000000");
		
		State state1 = new State("DELHI", "20000000");
		State state2 = new State("BIHAR", "80000000");
		
		country.getStates().add(state1);
		country.getStates().add(state2);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(country);
		transaction.commit();
		session.close();
		System.out.println("Country saved!!!");
	}
}
