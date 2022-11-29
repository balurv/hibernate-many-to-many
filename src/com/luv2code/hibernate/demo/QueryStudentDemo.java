package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			//query student
			List<Student> studentList = session.createQuery("from Student").list();
			
			System.out.println("\ndisplaying all names!");
			//display student
			displayStudents(studentList);
			
			//query student first name = balaji
			System.out.println("\ndisplay student whoes first name is 'balaji'");
			studentList = session.createQuery("from Student where firstName = 'balaji'").getResultList();
			displayStudents(studentList);
			
			
			System.out.println("\ndisplay whoes email ends with @gmail.com");
			studentList = session.createQuery("from Student s where s.email like '%@gmail.com'").getResultList();
			displayStudents(studentList);
			
			System.out.println("\ndisplay all students whoes first name ends with 'u' letter");
			studentList = session.createQuery("from Student where firstName like '%u'").getResultList();
			displayStudents(studentList);
			
			System.out.println("\ndisplay all student whoes last name is not ramini");
			studentList = session.createQuery("from Student where lastName != 'ramini'").getResultList();
			displayStudents(studentList);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> studentList) {
		for(Student student : studentList) {
			System.out.println(student);
		}
	}

}
