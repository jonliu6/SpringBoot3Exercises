package org.freecode.demo.springboot3mvccrud.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="t_registered_user")
public class RegisteredUser implements Serializable {

	public RegisteredUser() {}
	
	@NotNull(message = "cannot be empty")
	@Size(min = 1, message = "at least one character")
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "cannot be empty")
	@Size(min = 1, message = "at least one character")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message = "cannot be empty")
	@Min(value = 19, message = "must be greater and equal than 19")
	@Max(value=100, message = "must be less and equal than 100")
	/**
	 * to prevent primary type conversion error, use Integer instead of int to handle null values
	 */
	@Column(name = "Age")
	private Integer age;
	
	@Column(name = "occupation")
	private String occupation;
	
	@Column(name = "gender")
	private String gender;
	
	@NotNull(message = "is required")
	@Id
	@Column(name = "email")
	private String email;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{6}", message="only 6 characters or digits allowed")
	@Column(name = "postal_code")
	private String postalCode;

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
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RegisteredUser [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", occupation="
				+ occupation + ", gender=" + gender + ", email=" + email + ", postalCode=" + postalCode + "]";
	}
	
	
}
