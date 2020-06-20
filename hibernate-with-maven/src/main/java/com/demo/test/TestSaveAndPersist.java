package com.demo.test;

import org.hibernate.Session;

import com.demo.model.Country;
import com.demo.util.HibernateUtil;

public class TestSaveAndPersist {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Country country = new Country("INDIA", "130 Crore");
		Integer countryId = (Integer)session.save(country);	//It return id, which is useful.
		session.getTransaction().commit();
		session.close();
		
		System.out.println("cId: " + countryId);
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		Country country2 = new Country("SINGAPORE", "56 Lakhs");
		session2.persist(country2); //It returns nothing, not good.
		session2.getTransaction().commit();
		session2.close();
		
		//Since persist does not return anything, trying to get data manually.
		Session session3 = HibernateUtil.getSessionFactory().openSession();
		session3.beginTransaction();
		Country country3 = (Country)session3.get(Country.class, countryId + 1);
		session3.getTransaction().commit();
		session3.close();
		
		System.out.println("cName: " + country3.getCountryName());
		System.out.println("cP: " + country3.getCountryPopuation());
	}

}
