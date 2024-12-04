package org.freecode.demo.springboot3jpaadvmappings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="t_author_contact")
public class AuthorContact {
	
	public AuthorContact() {
		
	}
	
	public AuthorContact(String email, String website) {
		this.email = email;
		this.website = website;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="website")
	private String website;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "AuthorContact [id=" + id + ", email=" + email + ", website=" + website + "]";
	}
}
