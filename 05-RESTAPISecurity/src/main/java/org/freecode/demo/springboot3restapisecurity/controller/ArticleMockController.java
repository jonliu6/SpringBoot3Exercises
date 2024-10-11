package org.freecode.demo.springboot3restapisecurity.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.freecode.demo.springboot3restapisecurity.exception.ArticleAlreadyExistsException;
import org.freecode.demo.springboot3restapisecurity.exception.ArticleNotFoundException;
import org.freecode.demo.springboot3restapisecurity.model.Article;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/restmock")
public class ArticleMockController {
	
	private Map<String, Article> allArticles;
	
	@PostConstruct
	public void initializeArticles() {
		allArticles = new TreeMap<String, Article>();
		Article a1 = new Article("Spring Boot 3 Quick Start", "Java", "The 1st training session of Spring Boot 3");
		Article a2 = new Article("Visual C# 2008", "C#", "Book of C# programming");
		Article a3 = new Article("Git Common Commands", "Git", "Technical Notes of how to use basic Git commands");
		allArticles.put("Spring Boot 3 Quick Start", a1);
		allArticles.put("Visual C# 2008", a2);
		allArticles.put("Git Common Commands", a3);
	}

	@GetMapping("/articles")
	/**
	 * URL: http://<server>:<port>/restmock/articles
	 * @return
	 */
	public List<Article> findAll() {
		List<Article> articles = new ArrayList<Article>(allArticles.values());
		return articles;
	}
	
	@GetMapping("articles/{title}")
	/**
	 * URL: http://<server>:<port>/restmock/articles/Visual C%23 2008
	 * @param title
	 * @return
	 */
	public Article findByTitle(@PathVariable String title) {
		if (! allArticles.containsKey(title)) {
			throw new ArticleNotFoundException(title + " not found!");
		}
		return allArticles.get(title);
	}
	
	@PostMapping("/articles")
	/**
	 * URL: http://<server>:<port>/restmock/articles
	 * @param article
	 */
	public void createArticle(@RequestBody Article article) {
		if (allArticles.containsKey(article.getTitle())) {
			throw new ArticleAlreadyExistsException(article.getTitle() + " already exists!");
		}
		allArticles.put(article.getTitle(), article);
	}
	
	@PutMapping("/articles")
	/**
	 * URL: http://<server>:<port>/restmock/articles
	 * @param article
	 */
	public void updateArticle(@RequestBody Article article) {
		Article newArticle = allArticles.get(article.getTitle());
		if (newArticle == null) {
			throw new ArticleNotFoundException(article.getTitle() + " not found!");
		}
		newArticle.setCategory(article.getCategory());
		newArticle.setContent(article.getContent());
	}
	
	@DeleteMapping("/articles/{title}")
	/**
	 * URL: http://<server>:<port>/restmock/articles/Git%20Common%20Commands
	 * @param title
	 */
	public void deleteArticleByTitle(@PathVariable String title) {
		if (! allArticles.containsKey(title)) {
			throw new ArticleNotFoundException(title + " not found!");
		}
		allArticles.remove(title);
	}
	
	/**
	 * Exception Handlers
	 * To make other controllers use these exception handlers, put in separate ControllerAdvice class instead
	 */
//	@ExceptionHandler
//	public ResponseEntity<ArticleErrorResponse> handleExeption(ArticleNotFoundException ex) {
//		ArticleErrorResponse error = new ArticleErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
//	
//	@ExceptionHandler
//	public ResponseEntity<ArticleErrorResponse> handleException(ArticleAlreadyExistsException ex) {
//		ArticleErrorResponse error = new ArticleErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
//		return new ResponseEntity<ArticleErrorResponse>(error, HttpStatus.BAD_REQUEST);
//	}
}
