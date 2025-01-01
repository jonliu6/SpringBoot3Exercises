package org.freecode.demo.springboot3aop.dao;

import java.util.List;

import org.freecode.demo.springboot3aop.model.Article;
import org.freecode.demo.springboot3aop.model.Author;

public interface AppDAO {

	void executeDAOMethod();
	
	void addArticle(Author author, Article article);
	
	Article queryArticle(Article article);
	
	List<Article> findAllArticles(boolean throwException);
}
