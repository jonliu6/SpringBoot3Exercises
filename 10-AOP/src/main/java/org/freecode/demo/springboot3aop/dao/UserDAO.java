package org.freecode.demo.springboot3aop.dao;

import java.util.List;

import org.freecode.demo.springboot3aop.model.Author;

public interface UserDAO {
	
	String addAuthor(Author author);

	Author findAuthor(Author author);
	
	List<Author> findAllAuthors();
	
	void queryHeavyTransation();
}
