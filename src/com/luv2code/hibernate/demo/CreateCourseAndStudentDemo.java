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

public class CreateCourseAndStudentDemo {

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
			
//			create a course.
			Course course = new Course("ea");
			 
//			save the course.
			System.out.println("saving the course");
			session.save(course);
			
//			create the students
			Date date = new Date();
			Student balu = new Student("balaji", "ramini", "balurv1997@gmail.com");
			Student ashwij = new Student("ashwij", "a", "ashwij@gmail.com");
			Student chethan = new Student("chethan" ," n", "chethan@gmail.com");
			Student deepak = new Student("deepak", "k", "deepak@gmail.com");
			
//			add the students to the course
			course.addStudent(balu);
			course.addStudent(ashwij);
			course.addStudent(chethan);
			course.addStudent(deepak);
			
			
//			save the students
			System.out.println("\nsaving students");
			session.save(balu);
			session.save(ashwij);
			session.save(chethan);
			session.save(deepak);
			
			System.out.println("students are:\n"+course.getStudents());
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
