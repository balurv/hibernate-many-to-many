package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
//			get the Students from db
			List<Student> studentList = session.createQuery("from Student").list();
			
//			delete the course
			int studentId = -1;
			
			for(Student student : studentList) {
				if(student.getFirstName().equals("ashwij")) {
					studentId = student.getId();
				}
			}
			if(studentId == -1) {
				System.out.println("Cannot Delete! Provided student NOT FOUND.");
				return;
			}
			
			Student ashwij = session.get(Student.class, studentId);
			
			System.out.println("Deleting student ashwij record");
			session.delete(ashwij);
//			commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
