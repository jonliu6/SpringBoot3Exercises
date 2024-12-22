package org.freecode.demo.springboot3jpaadvmappings.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="t_reference")
public class Reference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="referencetype")
	private String referenceType;
	
	@Column(name="reference")
	private String reference;
	
	/**
	 * do not set up cascade for removal because removing the reference should not remove the post(s)
	 * joinColumns are the foreign key(s) of the associate entity (referneceId of t_post_reference),
	 * and inverseJoinColumns are the other side foreign key(s) of the associate entity (postId of t_post_reference)
	 */
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="t_post_reference",
	           joinColumns = @JoinColumn(name="referenceid"),
	           inverseJoinColumns = @JoinColumn(name="postid")
	)
	private List<Post> posts;

	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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
	}

	@Override
	public String toString() {
		return "Reference [id=" + id + ", referenceType=" + referenceType + ", reference=" + reference;
	}

	public Reference() {}
	
	public Reference(String type, String reference) {
		this.referenceType = type;
		this.reference = reference;
	}
}
