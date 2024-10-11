package org.freecode.demo.springboot3restapis.service;

import java.util.List;
import java.util.Optional;

import org.freecode.demo.springboot3restapis.dao.ArticleRepository;
import org.freecode.demo.springboot3restapis.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
/**
 * There are 2 options to access the data: 1-custom DAO with JPQL; or 2-Data JPA Repository
 */
public class ArticleServiceImpl implements ArticleService {
	
	// option 1: custom DAO with JPQL
//	private ArticleDAO articleDAO;
	// option 2: data JPA
	private ArticleRepository articleRepo;
	
//	@Autowired
//	public ArticleServiceImpl(ArticleDAO aDAO) {
//		this.articleDAO = aDAO;
//	}
	
	@Autowired
	public ArticleServiceImpl(ArticleRepository aRepo) {
		this.articleRepo = aRepo;
	}

	@Override
	public List<Article> findAll() {
//		return articleDAO.findAll();
		return articleRepo.findAll();
	}

	@Override
	/**
	 * JpaRepository findById(...) returns Optional type
	 */
	public Article findById(int id) {
//	    return articleDAO.findById(id);
		Optional<Article> result = articleRepo.findById(id);
		Article foundArticle = null;
		if (result.isPresent()) {
			foundArticle = result.get();
		}
		
		return foundArticle;
	}

	@Override
	/*
	 * when using JpaRepository, need to do add @Transactional annotation to the update statements since the logic is inside JpaRepository
	 */
//	@Transactional
	public Article save(Article article) {
//		return articleDAO.save(article);
		return articleRepo.save(article);
	}

	@Override
//	@Transactional
	public void deleteById(int id) {
//		articleDAO.deleteById(id);
		articleRepo.deleteById(id);
		
	}

}
