package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class UpdateInstructorDemo {

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
			
			int id = 1;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("updating instructor: "+instructor);
			
//			Instructor instructor = instructorDetail.getInstructor();
//			System.out.println(Instructor);
			InstructorDetail instructorDetail = new InstructorDetail("www.balajirv.in", "palying guitar");
			
			instructor.setInstructorDetail(instructorDetail);
			
			System.out.println("instructor is:" + instructorDetail.getInstructor());
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
