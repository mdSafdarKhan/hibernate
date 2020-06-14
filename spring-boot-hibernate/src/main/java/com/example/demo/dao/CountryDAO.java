package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Country;
import com.example.demo.util.HibernateUtil;

@Repository
public class CountryDAO {

	public List<Country> getAllCountries() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Country> countryList = session.createQuery("from Country").list();
		session.getTransaction().commit();
		session.close();
		return countryList;
	}

	public Country getCountry(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Country country = (Country) session.get(Country.class, new Integer(id));
		session.getTransaction().commit();
		session.close();
		return country;
	}

	public Country addCountry(Country country) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(country);
		session.getTransaction().commit();
		session.close();
		return country;
	}

	public void updateCountry(Country country) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(country);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteCountry(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Country p = (Country) session.get(Country.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		session.getTransaction().commit();
		session.close();
	}
}
