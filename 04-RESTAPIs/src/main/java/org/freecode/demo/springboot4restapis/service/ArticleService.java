package org.freecode.demo.springboot4restapis.service;

import java.util.List;

import org.freecode.demo.springboot4restapis.model.Article;

public interface ArticleService {

	List<Article> findAll();
    Article findById(int id);
    Article save(Article article);
	void deleteById(int id);
}
