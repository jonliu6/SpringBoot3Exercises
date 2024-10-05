package org.freecode.demo.springboot4restapis.dao;

import java.util.List;

import org.freecode.demo.springboot4restapis.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ArticleDAOImpl implements ArticleDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public ArticleDAOImpl(EntityManager em) {
		this.entityManager = em;
	}

	@Override
	public List<Article> findAll() {
		TypedQuery<Article> query = entityManager.createQuery("FROM Article", Article.class);
		return query.getResultList();
	}

	@Override
	public Article findById(int id) {
		
		return entityManager.find(Article.class, id);
	}

	@Override
	public Article save(Article article) {
		return entityManager.merge(article);	
	}

	@Override
	public void deleteById(int id) {
		Article foundArticle = entityManager.find(Article.class, id);
		entityManager.remove(foundArticle);
	}

}
