package org.freecode.demo.springboot3jpaadvmappings;

import org.freecode.demo.springboot3jpaadvmappings.dao.AuthorDAO;
import org.freecode.demo.springboot3jpaadvmappings.entity.Author;
import org.freecode.demo.springboot3jpaadvmappings.entity.AuthorContact;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot3jpaadvmappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3jpaadvmappingsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AuthorDAO dao) {
		return runner -> {
			String msg = "";
			Author author = null;
			author = createAuthor(dao);
			msg = "Author persisted: " + author;
			System.out.println(msg);
			
			author = findAuthor(dao);
			msg = "found: " + author;
			System.out.println(msg);
			
			author = updateAuthor(dao, author);
			msg = "Author updated to: " + author;
			System.out.println(msg);
			
			// deleteAuthor(dao, author);
			msg = "Author deleted!";			
			System.out.println(msg);
		};
	}

	private Author createAuthor(AuthorDAO dao) {
		Author author = new Author("John", "Smith", "M");
		AuthorContact contact = new AuthorContact("johnsmith@demo.freecode.org", "https://johnsmith.demo.freecode.org");
		author.setAuthorContact(contact);
		dao.save(author);
		return author;
	}
	
	private Author findAuthor(AuthorDAO dao) {
		int maxAuthorId = dao.findMaxAuthorId();
		return dao.findById(maxAuthorId);
	}
	
	private Author updateAuthor(AuthorDAO dao, Author author) {
		AuthorContact contact = author.getAuthorContact();
		contact.setEmail("notreply@demo.freecode.org");
		author.setFirstName(author.getFirstName() + "2");
		return dao.updateAuthor(author);
	}
	
	private void deleteAuthor(AuthorDAO dao, Author author) {
		dao.deleteById(author.getId());
	}
}
