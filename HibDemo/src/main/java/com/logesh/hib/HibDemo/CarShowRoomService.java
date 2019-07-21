package com.logesh.hib.HibDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarShowRoomService {

	@Autowired
	private SessionFactory factory;

	public void getDtls() {
		System.out.println("here at car show room");
		Showroom showroom = new Showroom("Chennai");
		Car bmw = new Car("BMW");
		bmw.setShowroom(showroom);
		Car benz = new Car("benz");
		benz.setShowroom(showroom);
		List<Car> cars = new ArrayList<Car>();
		cars.add(bmw);
		cars.add(benz);
		showroom.setCars(cars);

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(benz);
		session.save(bmw);
		session.save(showroom);

		session.getTransaction().commit();
		System.out.println("session saved");
		// System.out.println("result : " + session.createQuery("from
		// Showroom").list());
		// System.out.println("carres : " + session.createQuery("from Car").list());
		List<Showroom> showrooms = session.createQuery("from Showroom").list();
		for (Showroom s : showrooms) {
			System.out.println(s.getId() + " " + s.getShowRoomLocation() + " ");
			for (Car e : s.getCars()) {
				System.out.println(e.getCarName() + " " + e.getCarName() + " " + e.getShowroom().getShowRoomLocation());
			}

		}

		Criteria criteria = session.createCriteria(Car.class);
		criteria.add(Restrictions.eq("carName", "benz"));
		Car car = (Car) criteria.uniqueResult();
		System.out.println(car.getShowroom().getId());

	}

}
