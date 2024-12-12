package org.freecode.demo.springboot3jpaadvmappings;

import org.freecode.demo.springboot3jpaadvmappings.dao.AppDAO;
import org.freecode.demo.springboot3jpaadvmappings.entity.Author;
import org.freecode.demo.springboot3jpaadvmappings.entity.AuthorContact;
import org.freecode.demo.springboot3jpaadvmappings.entity.Comment;
import org.freecode.demo.springboot3jpaadvmappings.entity.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot3JpaAdvMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3JpaAdvMappingsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO dao) {
		return runner -> {
			String msg = "";
			Author author = null;
			// OneToOne mapping demo
//			author = createAuthor(dao);
//			msg = "Author persisted: " + author;
//			System.out.println(msg);
//			
//			author = findAuthor(dao);
//			msg = "found: " + author;
//			System.out.println(msg);
//			
//			author = updateAuthor(dao, author);
//			msg = "Author updated to: " + author;
//			System.out.println(msg);
//			
//			// deleteAuthor(dao, author);
//			msg = "Author deleted!";			
//			System.out.println(msg);
			
			// OneToMany mapping demo
//			author = createAuthorWithPosts(dao);
//			msg = "created: " + author;
//			System.out.println(msg);
			
//			author = findAuthor(dao);
//			msg = "found: " + author;
//			System.out.println(msg);
//			// since One-to-Many defaults to LAZY loading, the author object will be populated with posts
//			System.out.println("Posts by the author: " + author.getPosts());
			
//			updatePost(dao);
//			System.out.println("a Post was updated.");
//			
//			author = findAuthorWithPosts(dao);
//			msg = "found: " + author;
//			System.out.println(msg + "\r\nPosts by the author: " + author.getPosts());

//			deleteAuthorFromPosts(dao);
//			System.out.println("Author deleted.");
//			
//			System.out.println(dao.deleteAllPostsWithoutAuthor() + " orphan posts deleted.");
			
//			createPostsWithComments(dao);
			
			Post post = findPostWithComments(dao);
			System.out.println("found: " + post + "\r\n" + (post == null ? " [no comments]" : "Comments: " + post.getComments()));
			
			dao.deletePostAndCommentsById(post.getId());
		};
	}
	
	private Post findPostWithComments(AppDAO dao) {
		int postId = 9;
		Post found = dao.findPostWithCommentsById(postId);
		
		return found;
	}
	
	private void createPostsWithComments(AppDAO dao) {
		Post post1 = new Post("Hibernate one-to-many demo 2", "demonstrate one-to-many relationship between Post and Comments");
		Post post2 = new Post("How to create tables in MySQL", "SQL scripts to create and drop tables in MySQL...");
		Comment comment1 = new Comment("good demo with Hibernate");
		Comment comment1a = new Comment("understand one-to-many easily");
		Comment comment2 = new Comment("MySQL DDL for beginners...");
		post1.addComment(comment1);
		post1.addComment(comment1a);
		post2.addComment(comment2);
		
		dao.update(post1);
		dao.update(post2);
	}
	
	private void deleteAuthorFromPosts(AppDAO dao) {
		int authorId = 8;
		dao.deleteAuthorFromPostsById(authorId);
	}
	
	private void updatePost(AppDAO dao) {
		int id = 3;
		
		Post found = dao.findPostById(id);
		if (found != null) {
			found.setTitle(found.getTitle() + " 2nd edition");
			dao.update(found);
		}
	}
	
	private Author findAuthorWithPosts(AppDAO dao) {
		int id = 8;
		return dao.findAuthorWithPostsById(id);
	}
	
	private Author createAuthorWithPosts(AppDAO dao) {
		Author author = new Author("Rose", "Mary", "F");
		AuthorContact contact = new AuthorContact("rose.mary@demo.freecode.org", "https://rosemary.demo.freecode.org");
		author.setAuthorContact(contact);
		Post post1 = new Post("Hibernate one-to-many demo", "Hibernate JPA implementation for the one-to-many entity relationship...");
		Post post2 = new Post("SpringBoot3 with JPA", "SpringBoot3 JPA repository examples...");
		author.addPost(post1);
		author.addPost(post2);
		dao.save(author);
		
		return author;
	}

	private Author createAuthor(AppDAO dao) {
		Author author = new Author("John", "Smith", "M");
		AuthorContact contact = new AuthorContact("johnsmith@demo.freecode.org", "https://johnsmith.demo.freecode.org");
		author.setAuthorContact(contact);
		dao.save(author);
		return author;
	}
	
	private Author findAuthor(AppDAO dao) {
		int maxAuthorId = dao.findMaxAuthorId();
		return dao.findById(maxAuthorId);
	}
	
	private Author updateAuthor(AppDAO dao, Author author) {
		AuthorContact contact = author.getAuthorContact();
		contact.setEmail("notreply@demo.freecode.org");
		author.setFirstName(author.getFirstName() + "2");
		return dao.updateAuthor(author);
	}
	
	private void deleteAuthor(AppDAO dao, Author author) {
		dao.deleteById(author.getId());
	}
}
