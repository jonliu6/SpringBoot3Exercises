package org.freecode.demo.springboot3aop.model;

public class Article {

	private int id;
	private String title;
	private String category;
	private String content;
	public Article() {}
	public Article(String title, String category, String content) {
		this.title = title;
		this.category = category;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", category=" + category + ", content=" + content + "]";
	}
}
