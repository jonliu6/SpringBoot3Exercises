package org.freecode.demo.springboot3aop.dao;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public Article queryArticle(Article article) {
		if (article == null) {
			System.out.println("AppDAO: queryArticle() found nothing");
		}
		else {
			System.out.println("AppDAO: queryArticle() found " + article );
		}
		return article;
	}

	@Override
	public List<Article> findAllArticles(boolean throwException) {
		List<Article> articles = new ArrayList<Article>();
		if (throwException) {
			throw new RuntimeException("!!!Exception thrown from findAllArticles()!!!");
		}
		
		Article doc1 = new Article("Test Document #2", "Home Improvement", "Too much work...");
		Article doc2 = new Article("Test Document #3", "Rock and Metal Music", "Ahhhh...");
		articles.add(doc1);
		articles.add(doc2);
		
		return articles;
	}
}
