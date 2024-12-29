package org.freecode.demo.springboot3aop.dao;

import org.freecode.demo.springboot3aop.model.Article;
import org.freecode.demo.springboot3aop.model.Author;

public interface AppDAO {

	void executeDAOMethod();
	
	void addArticle(Author author, Article article);
}
