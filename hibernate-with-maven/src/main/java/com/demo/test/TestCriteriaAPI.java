package com.demo.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.demo.model.Country;
import com.demo.util.HibernateUtil;

public class TestCriteriaAPI {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Country.class);
		List<Country> countries = criteria.list();
		System.out.println("total countries " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("countryName", "JAPAN"));
		countries = criteria.list();
		System.out.println("total countries JAPAN " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.ne("countryName", "JAPAN"));
		countries = criteria.list();
		System.out.println("total countries not JAPAN " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.like("countryName", "SING%", MatchMode.ANYWHERE));
		countries = criteria.list();
		System.out.println("total countries like SING " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.isNull("countryName"));
		countries = criteria.list();
		System.out.println("total countries countryName null " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.isNotNull("countryName"));
		countries = criteria.list();
		System.out.println("total countries countryName not null " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.isNotNull("countryName"));
		criteria.add(Restrictions.like("countryName", "SIN%"));
		countries = criteria.list();
		System.out.println("total countries countryName not null and like SING " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		Criterion countryNameIndia = Restrictions.eq("countryName", "INDIA");
		Criterion countryNameSingapore = Restrictions.eq("countryName", "SINGAPORE");
		LogicalExpression orExp = Restrictions.or(countryNameIndia, countryNameSingapore);
		criteria.add(orExp);
		countries = criteria.list();
		System.out.println("total countries countryNameIndia or countryNameSingapore " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		Criterion onlyIndia = Restrictions.eq("countryName", "INDIA");
		Criterion onlyJapan = Restrictions.eq("countryName", "JAPAN");
		Criterion onlySingapore = Restrictions.eq("countryName", "SINGAPORE");
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(onlyIndia);
		disjunction.add(onlyJapan);
		disjunction.add(onlySingapore);
		criteria.add(disjunction);
		countries = criteria.list();
		System.out.println("onlyIndia or onlyJapan or onlySingapore " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(5);
		countries = criteria.list();
		System.out.println("pagniation 0 to 5: " + countries.size());
		
		criteria = session.createCriteria(Country.class);
		criteria.addOrder(Order.asc("countryName"));
		countries = criteria.list();
		System.out.println("asc order countryName...");
		countries.stream().forEach(n -> System.out.println(n.getCountryName()));
		
		criteria = session.createCriteria(Country.class);
		Criteria languageCriteria = criteria.createCriteria("languages");
		countries = criteria.list();
		System.out.println("table joins: Country -> Language");
		countries.stream().forEach(n -> System.out.println(n.getLanguages()));
		
		criteria = session.createCriteria(Country.class);
		criteria.setProjection(Projections.rowCount());
		List<Long> rowCount = criteria.list();
		System.out.println("Projections, rowCount: " + rowCount);
		
		criteria = session.createCriteria(Country.class);
		criteria.setProjection(Projections.countDistinct("countryName"));
		List<Long> countDistinct = criteria.list();
		System.out.println("Projections, countDistinct: " + countDistinct);
		
		criteria = session.createCriteria(Country.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.rowCount());
		projectionList.add(Projections.countDistinct("countryName"));
		criteria.setProjection(projectionList);
		List<Object[]> multipleProjection = criteria.list();
		multipleProjection.stream().forEach(n -> System.out.println(n));
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Done!!");
	}

}
