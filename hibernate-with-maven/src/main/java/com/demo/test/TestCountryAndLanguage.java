package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.model.Country;
import com.demo.model.Language;
import com.demo.util.HibernateUtil;

public class TestCountryAndLanguage {

	public static void main(String[] args) {
		
		Country object = new Country("JAPAN", "8000000");
		
		Language language = new Language("JAPANESE");
		
		object.getLanguages().add(language);
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(object);
		
		tx.commit();
		session.close();
	}
}
