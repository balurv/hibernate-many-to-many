package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorCourseDemo {

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
			
			int id = 10;
			
			Course course = session.get(Course.class, id);
			
			session.delete(course);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
