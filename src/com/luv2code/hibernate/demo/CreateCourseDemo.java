package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCourseDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			System.out.println("creating a list of courses for an instructor");
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			Course english = new Course("English");
			
			Course math = new Course("Math");
			
			Course science = new Course("Science");
			
			instructor.add(science);
			instructor.add(math);
			instructor.add(english);
			
			session.save(english);
			session.save(math);
			session.save(science);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
