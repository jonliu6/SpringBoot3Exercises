package org.freecode.demo.springboot3aop.model;

public class Author {
	
	private int id;
	private String lastName;
	private String firstName;
	public Author() {}
	public Author(String given, String surname) {
		lastName = surname;
		firstName = given;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}
}
