package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			int id = 2;
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("Deleting instructorDetails: "+instructorDetail);
			
//			Instructor instructor = instructorDetail.getInstructor();
//			System.out.println(Instructor);
			
			System.out.println("instructor is:" + instructorDetail.getInstructor());
			
			session.delete(instructorDetail);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
