package org.freecode.demo.springboot3restapis.controller;

import java.util.List;
import java.util.Map;

import org.freecode.demo.springboot3restapis.exception.ArticleNotFoundException;
import org.freecode.demo.springboot3restapis.model.Article;
import org.freecode.demo.springboot3restapis.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api")
public class ArticleController {

	private ArticleService articleService;
	// used for HTTP PATCH - partial updates
	private ObjectMapper objectMapper;
	
	@Autowired
	public ArticleController(ArticleService aService, ObjectMapper objMapper) {
		this.articleService = aService;
		this.objectMapper = objMapper;
	}
	
	@GetMapping("/articles")
	/**
	 * URL: http://<server>:<port>/api/articles
	 * @return list of all articles
	 */
	public List<Article> findAll() {
		return articleService.findAll();
	}
	
	@GetMapping("/articles/{articleId}")
	/**
	 * URL: http://<server>:<port>/api/articles/{articleIds}
	 * @return an article if found; or, throw an exception
	 */
	public Article getArticleById(@PathVariable int articleId) {
		Article foundArticle = articleService.findById(articleId);
		if (foundArticle == null) {
			throw new ArticleNotFoundException("Article with ID=" + articleId + " was not found!");
		}
		return foundArticle;
	}
	
	/**
	 * to create a new article, set the id = 0
	 * URL: http://<server>:<port>/api/articles
	 * @param newArticle (JSON)
	 * @return the new article
	 */
	@PostMapping("/articles")
	public Article createArticle(@RequestBody Article newArticle) {
		newArticle.setId(0);
		return articleService.save(newArticle);
	}
	
	@PutMapping("/articles")
	/**
	 * if no article found with the given article ID, throw an exception; or updated article
	 * URL: http://<server>:<port>/api/articles
	 * @param article
	 * @return updated article
	 */
	public Article updateArticle(@RequestBody Article newArticle) {
		int articleId = newArticle.getId();
		Article foundArticle = articleService.findById(articleId);
		if (foundArticle == null) {
			throw new ArticleNotFoundException("Article with ID=" + articleId + " was not found!");
		}
		
		return articleService.save(newArticle);
	}
	
	/*
	 * add mapping for PATH /articles/{articleId} - patch article - partially update
	 */
	@PatchMapping("/articles/{articleId}")
	public Article patchArticle(@PathVariable int articleId, @RequestBody Map<String, Object> patchPayload) {
		Article tempArticle = articleService.findById(articleId);
		
		if (tempArticle == null) {
			throw new RuntimeException("Article " + articleId + " not found");
		}
		
		if (patchPayload.containsKey("id")) {
			throw new RuntimeException("Article id " + articleId + " not allowed in the request body");
		}
		
		Article patchedArticle = apply(patchPayload, tempArticle);
		
		Article savedArticle = articleService.save(patchedArticle);
		return savedArticle;
	}
	
	private Article apply(Map<String, Object> patchPayload, Article tempArticle) {
		// convert article object to a JSON object node
		ObjectNode articleNode = objectMapper.convertValue(tempArticle, ObjectNode.class);
		
		// convert the patchPayload to ObjectNode
		ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
		
		// merge the patch updates into the article node
		articleNode.setAll(patchNode);
		
		return objectMapper.convertValue(articleNode, Article.class);
	}

	@DeleteMapping("/articles/{articleId}")
	/**
	 * if no article found with the given ID, throw an exception; or delete the article with the given ID.
	 * URL: http://<server>:<port>/api/articles/{articleId}
	 * @param articleId
	 */
	public void deleteArticle(@PathVariable int articleId) {
		Article foundArticle = articleService.findById(articleId);
		if (foundArticle == null) {
			throw new ArticleNotFoundException("Article with ID=" + articleId + " was not found!");
		}
		articleService.deleteById(articleId);
	}
}
