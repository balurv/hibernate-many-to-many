package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForBalajiDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
//			get the student teju from db.
			Student balaji = session.get(Student.class, 1);
			
			System.out.println("balaji student details:\n"+balaji);
			System.out.println("balaji courses:\n"+balaji.getCourses());
			
//			create more courses
			Course rubix = new Course("rubix Cube - Learn to solve the 3X3 cube");
			Course atari2600 = new Course("Atari 2600 - Game Development!");
			
//			add student to courses
			rubix.addStudent(balaji);
			atari2600.addStudent(balaji);
			
//			save the courses
			session.save(rubix);
			session.save(atari2600);
			
			System.out.println("Balaji course\n"+balaji.getCourses());
//			commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
