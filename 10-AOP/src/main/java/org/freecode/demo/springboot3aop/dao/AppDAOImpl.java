package org.freecode.demo.springboot3aop.dao;

import org.freecode.demo.springboot3aop.model.Article;
import org.freecode.demo.springboot3aop.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

	@Override
	public void executeDAOMethod() {
		System.out.println("AppDAO: executeDAOMethod executed.");
	}

	@Override
	public void addArticle(Author author, Article article) {
		System.out.println("AppDAO: addArticle() added " + (article == null ? "NULL" : "\"" + article.getTitle() + "\"") + " by " + (author == null ? "NULL" : author.getFirstName() + " " + author.getLastName()));
	}
}
