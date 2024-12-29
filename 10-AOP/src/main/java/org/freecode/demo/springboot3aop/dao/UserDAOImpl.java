package org.freecode.demo.springboot3aop.dao;

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
}
