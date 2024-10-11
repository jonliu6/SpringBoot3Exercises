package org.freecode.demo.springboot3restapis.dao;

import java.util.List;

import org.freecode.demo.springboot3restapis.model.Article;

public interface ArticleDAO {
	
	List<Article> findAll();
	
	Article findById(int id);
	
	Article save(Article article);
	
	void deleteById(int id);

}
