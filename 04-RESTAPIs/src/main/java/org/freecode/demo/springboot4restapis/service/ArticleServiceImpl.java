package org.freecode.demo.springboot4restapis.service;

import java.util.List;

import org.freecode.demo.springboot4restapis.dao.ArticleDAO;
import org.freecode.demo.springboot4restapis.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDAO articleDAO;
	
	@Autowired
	public ArticleServiceImpl(ArticleDAO aDAO) {
		this.articleDAO = aDAO;
	}

	@Override
	public List<Article> findAll() {
		return articleDAO.findAll();
	}

	@Override
	public Article findById(int id) {
	    return articleDAO.findById(id);
	}

	@Override
	@Transactional
	public Article save(Article article) {
		return articleDAO.save(article);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		articleDAO.deleteById(id);
	}

}
