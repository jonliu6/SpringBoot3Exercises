package org.freecode.demo.springboot4restapis.model;

import java.io.Serializable;

public class Article implements Serializable {

	private String title;
	private String category;
	private String content;
	
	public Article() {
		
	}
	public Article(String aTitle, String aCategory, String aContent) {
		this.title = aTitle;
		this.category = aCategory;
		this.content = aContent;
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
	@Override
	public String toString() {
		return "Article [title=" + title + ", category=" + category + ", content=" + content + "]";
	}
}
