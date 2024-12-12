package org.freecode.demo.springboot3jpaadvmappings.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	/**
	 * instead of CascadeType.ALL, we can list out the specific ones and prevent the cascading to the related records. 
	 * Note: need to un-associate the related properties.
	 * eg cascade = (CascadeType.PERSIST, Cascade.MERGE, Cascade.REFRESH, Cascade.DETACH)
	 */
	private AuthorContact authorContact;
	
	@OneToMany(mappedBy = "author",
			   cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	/**
	 * mappedBy is the author property in Post
	 * disable cascade during removal
	 */
	private List<Post> posts;
	
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
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public void addPost(Post aPost) {
		if (posts == null) {
			posts = new ArrayList<Post>();
		}
		
		posts.add(aPost);
		aPost.setAuthor(this); // important to link authorId to a post
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + "]" + "\n" +
	           "Posts: " + posts;
	}
}
