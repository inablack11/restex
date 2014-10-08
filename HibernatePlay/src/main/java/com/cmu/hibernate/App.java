package com.cmu.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.cmu.hibernate.model.TestT1;
import com.cmu.hibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		TestT1 user = new TestT1();
 
		user.setUserId(100);
		user.setUsername("u1");
		user.setCreatedBy("s1");
		user.setCreatedDate(new Date());
 
		session.save(user);
		session.getTransaction().commit();
	}
}
