package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("creating 3 student objects");
			Student student1 = new Student("balaji", "ramini", null, "balurv1997@gmail.com");
			Student student2 = new Student("mouli", "ramini", null, "moulirv1993@gmail.com");
			Student student3 = new Student("teju", "ramini", null, "tejurv1991@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving the student");
			session.save(student1);
			session.save(student2);
			session.save(student3);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
