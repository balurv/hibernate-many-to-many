package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			System.out.println("update all student last name from ramini to r (vice-versa)");
			session.createQuery("update Student set lastName='ramini'").executeUpdate();
			session.getTransaction().commit();

			// get new session.
			session = factory.getCurrentSession();

			// start a transaction
			session.beginTransaction();

			// get student id
			int studentId = 8;

			// get student from db using id

			Student student = session.get(Student.class, studentId);
			student.setLastName("koyi");

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
