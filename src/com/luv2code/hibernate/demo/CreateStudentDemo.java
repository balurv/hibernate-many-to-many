package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.DateUtils;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("creating an student objext");
			String theDateOfBirthStr = "31/12/1998";
			 
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
 
			Student student = new Student("dhananjay", "koyi", theDateOfBirth, "dhanubalu90@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving the student");
			session.save(student);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
