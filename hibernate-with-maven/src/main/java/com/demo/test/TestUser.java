package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.model.User;
import com.demo.util.HibernateUtil;

public class TestUser {
	public static void main(String[] args) {

		User user = new User();
		user.setUserName("Safdar");
		user.setUserMessage("Java developer");
		
		User user2 = new User();
		user2.setUserName("Sam");
		user2.setUserMessage("Front end developer");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		session.save(user2);
		tx.commit();
		session.close();
		
		System.out.println("User saved to database!!!");
	}
}
