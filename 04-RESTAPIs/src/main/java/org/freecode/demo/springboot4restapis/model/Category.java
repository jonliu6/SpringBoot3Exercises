package org.freecode.demo.springboot4restapis.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="t_category")
public class Category implements Serializable {
	private int id;
	private String category;
	private int parentId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="category")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Column(name="parentid")
	/**
	 * NOTE: use all lower cases as column name to avoid "Unknown Column in field list" errors because he columns in MySQL are case-sensative
	 * However, in the JSON data, the property name should be matched between entity class and JSON object.
	 * @return
	 */
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Category [Id=" + id + ", category=" + category + ", parentId=" + parentId + "]";
	}
}
