package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			//begin transaction
			session.beginTransaction();
			
			System.out.println("Getting a student from db");
//			Student student = session.get(Student.class, 9);
			
//			System.out.println("deleting student "+student);
//			session.delete(student);
//			
			System.out.println("Deleting student id: 7");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> studentList) {
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

}
