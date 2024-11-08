package org.freecode.demo.springboot3mvc.model;

import java.io.Serializable;
import java.util.List;

import org.freecode.demo.springboot3mvc.validation.EmailFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisteredUser implements Serializable {

	public RegisteredUser() {}
	
	@NotNull(message = "cannot be empty")
	@Size(min = 1, message = "at least one character")
	private String firstName;
	
	@NotNull(message = "cannot be empty")
	@Size(min = 1, message = "at least one character")
	private String lastName;
	
	@NotNull(message = "cannot be empty")
	@Min(value = 19, message = "must be greater and equal than 19")
	@Max(value=100, message = "must be less and equal than 100")
	/**
	 * to prevent primary type conversion error, use Integer instead of int to handle null values
	 */
	private Integer age;
	
	private String occupation;
	
	private String gender;
	
	private List<String> favoriteTopics;
	
	@EmailFormat(value = "@gmail.com", message = "must end with @gmail.com")
	private String email;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{6}", message="only 6 characters or digits allowed")
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

	public List<String> getFavoriteTopics() {
		return favoriteTopics;
	}

	public void setFavoriteTopics(List<String> favoriteTopics) {
		this.favoriteTopics = favoriteTopics;
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
		return "RegisteredUser [firstName=" + firstName + ", lastName=" + lastName + ", occupation=" + occupation
				+ ", gender=" + gender + ", favoriteTopics=" + favoriteTopics + "]";
	}
}
