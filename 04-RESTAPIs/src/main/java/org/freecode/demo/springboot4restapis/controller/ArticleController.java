package org.freecode.demo.springboot4restapis.controller;

import java.util.List;

import org.freecode.demo.springboot4restapis.exception.ArticleNotFoundException;
import org.freecode.demo.springboot4restapis.model.Article;
import org.freecode.demo.springboot4restapis.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ArticleController {

	private ArticleService articleService;
	
	@Autowired
	public ArticleController(ArticleService aService) {
		this.articleService = aService;
	}
	
	@GetMapping("/articles")
	/**
	 * URL: http://<server>:<port>/api/articles
	 * @return list of all articles
	 */
	public List<Article> findAll() {
		return articleService.findAll();
	}
	
	@GetMapping("articles/{articleId}")
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
