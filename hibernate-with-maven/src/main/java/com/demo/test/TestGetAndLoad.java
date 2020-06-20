package com.demo.test;

import org.hibernate.Session;

import com.demo.model.Country;
import com.demo.util.HibernateUtil;

public class TestGetAndLoad {
	
	public static void main(String[] args) {
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Country country = new Country("INDIA", "130 Crore");
		Integer countryId = (Integer)session1.save(country);
		session1.getTransaction().commit();
		session1.close();
		
		System.out.println("countryId: " + countryId);
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		country = (Country)session2.get(Country.class, countryId);
		System.out.println("cName: " + country.getCountryName());
		System.out.println("cPop: " + country.getCountryPopuation());
		session2.getTransaction().commit();
		session2.close();
		
		Session session3 = HibernateUtil.getSessionFactory().openSession();
		session3.beginTransaction();
		country = (Country)session3.load(Country.class, countryId);
		System.out.println("cName3: " + country.getCountryName());
		System.out.println("cPop3: " + country.getCountryPopuation());
		session3.getTransaction().commit();
		session3.close();
	}
}
