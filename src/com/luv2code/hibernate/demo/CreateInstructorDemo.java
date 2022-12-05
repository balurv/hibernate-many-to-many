package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			System.out.println("creating instrutor");

			Instructor instructor =new Instructor("balaji", "ramini", "balurv1997@gmail.com");
			
			System.out.println("creating instrutor detail");

			InstructorDetail instructorDetail = new InstructorDetail("www.balaji.com/youtube","Love to codde");
			
//			System.out.println("creating ");
			
			instructor.setInstructorDetail(instructorDetail);
			
			System.out.println("saving instrutor :\n"+instructor);

			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
