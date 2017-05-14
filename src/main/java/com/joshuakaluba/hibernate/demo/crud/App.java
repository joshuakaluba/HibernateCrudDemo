package com.joshuakaluba.hibernate.demo.crud;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {

	private static SessionFactory sessionFactory;
	private static Session session;

	public static void main(String[] args) {

		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		createPerson();
		
		Person person = getPerson();
		
		updatePerson(person.getId());
		
		deletePerson(person.getId());

		session.getTransaction().commit();
		session.close();

	}

	private static void createPerson() {

		Person person = new Person("Joe", 30);

		session.save(person);
		
		System.out.println(String.format("Person created : %s", person.toString()));

	}

	private static Person getPerson() {

		List<Person> people = session.createQuery("from Person").list();

		for (Person person : people) {
			System.out.println(person.toString());
		}
		
		//get the first person from the list
		return people.get(0);
	}

	private static void updatePerson(int personId) {
		
		Person person = (Person) session.get(Person.class, personId);
		person.setFirstName("Jane");
		person.setAge(21);

		session.update(person);
		
		System.out.println(String.format("Updated Person : %s", person.toString()));

	}

	private static void deletePerson(int personId) {

		Person person = (Person) session.get(Person.class, personId);

		session.delete(person);
		
		System.out.println("Person deleted");

	}

}
