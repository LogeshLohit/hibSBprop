package com.logesh.hib.HibDemo;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class StudentService {

	@Autowired
	private SessionFactory sessionFactory;

//	private SessionFactory sessionFactory;
//
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	@Resource(name = "sessionFactory")
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	public void findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(new Student("Logesh"));
		System.out.println("saved");
		System.out.println("All studs : " + session.createQuery("from Student s").list());

		session.getTransaction().commit();
	}
}
