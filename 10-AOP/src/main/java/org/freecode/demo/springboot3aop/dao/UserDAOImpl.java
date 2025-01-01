package org.freecode.demo.springboot3aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.freecode.demo.springboot3aop.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	public String addAuthor(Author author) {
		if (author == null) {
			return "UserDAO: addAuthor() added NULL!";
		}
		
		return "UserDAO: addAuthor(): added " + author.getFirstName() + " " + author.getLastName();
	}

	@Override
	public Author findAuthor(Author author) {
		if (author == null) {
			System.out.println("UserDAO: queryAuthor() found nothing");
		}
		else {
			System.out.println("UserDAO: queryAuthor() found " + author );
		}
		return author;
	}

	@Override
	public List<Author> findAllAuthors() {
		List<Author> authors = new ArrayList<Author>();
		Author usr1 = new Author("Mary", "Rose");
		Author usr2 = new Author("Bravo", "Brown");
		Author usr3 = new Author("Charlie", "Green");
		
		authors.add(usr1);
		authors.add(usr2);
		authors.add(usr3);
		
		return authors;
	}

	@Override
	public void queryHeavyTransation() {
		System.out.println("UserDAO: queryHeavyTransation() starting the heavy transaction");
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException iex) {
			System.out.println("InterruptedException caught in queryHeavyTransation: " + iex.getMessage());
		}
		System.out.println("UserDAO: queryHeavyTransation() completed!");
	}
}
