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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="t_post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	/**
	 * default fetch types:
	 * OneToOne: Eager
	 * OneToMany: LAZY
	 * ManyToOne: EAGER
	 * ManyToMany: LAZY
	 * cascade excluding REMOVE since author should not be removed when the posts are removed.
	 */
	@JoinColumn(name="authorid")
	private Author author;
	
	@OneToMany(mappedBy = "post",
			   cascade = {CascadeType.ALL})
	/**
	 * mappedBy is the post property in Comment
	 * cascade all transaction from Post to Comment
	 */
	private List<Comment> comments;
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		if (comments == null) {
			comments = new ArrayList<Comment>();
		}
		comments.add(comment);
		comment.setPost(this); // important to link postId to a comment
	}
		
	@Override
	public String toString() {
		return "Post [title=" + title + ", content=" + content + "]";
	}

	public Post() {};
	
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	};
}
