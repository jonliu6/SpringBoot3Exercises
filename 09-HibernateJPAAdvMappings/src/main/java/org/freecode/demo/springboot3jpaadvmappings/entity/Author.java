package org.freecode.demo.springboot3jpaadvmappings.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="t_author")
public class Author {
	
	public Author() {
		
	}
	
	public Author(String firstName, String lastName, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "authorcontactid")
	private AuthorContact authorContact;
	
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public AuthorContact getAuthorContact() {
		return authorContact;
	}

	public void setAuthorContact(AuthorContact authorContact) {
		this.authorContact = authorContact;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + "]";
	}
}
