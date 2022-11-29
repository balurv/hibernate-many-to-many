package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("creating an student objext");
			Student student = new Student("Srinivas", "ramini", "srinivasrk91@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			//find out the student's id : primary key
			int studentId = student.getId();
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student seenu = session.get(Student.class, studentId);
			System.out.println(seenu);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
