package com.joshuakaluba.hibernate.demo.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Person {

	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private int age;

	public Person() {

	};

	public Person(int id, String firstName, int age) {
		this.id = id;
		this.firstName = firstName;
		this.age = age;
	}

	public Person(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
	}

	public int getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return (String.format("Id: %d - Name: %s - Age: %d", this.getId(), this.getFirstName(), this.getAge()));
	}

}
