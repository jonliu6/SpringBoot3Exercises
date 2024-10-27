package org.freecode.demo.springboot3mvc.model;

import java.io.Serializable;
import java.util.List;

public class RegisteredUser implements Serializable {

	public RegisteredUser() {}
	
	private String firstName;
	
	private String lastName;
	
	private String occupation;
	
	private String gender;
	
	private List<String> favoriteTopics;

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

	@Override
	public String toString() {
		return "RegisteredUser [firstName=" + firstName + ", lastName=" + lastName + ", occupation=" + occupation
				+ ", gender=" + gender + ", favoriteTopics=" + favoriteTopics + "]";
	}
}
