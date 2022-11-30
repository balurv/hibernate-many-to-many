package com.luv2code.hibernate.assinment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.assinment.entity.Employee;

public class CreateEmployeeDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("Creating the employees");
			
			Employee emp1 = new Employee("balaji", "ramini", "newgen");
			Employee emp2 = new Employee("ashwij", "a", "oracle");
			Employee emp3 = new Employee("mohan", "k p", "cerner");
			Employee emp4 = new Employee("Narendra","k", "IT Service & Solution..");
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			
			session.getTransaction().commit();
			System.out.println("Save successfull..!");

		}finally {
			factory.close();
		}
	}
}
