package org.freecode.demo.springboot3hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="t_genre")
public class Genre {

	@Id
	@Column(name="genrename")
	private String name;

	public Genre() {
		
	}
	
	public Genre(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Genre [name=" + name + "]";
	}
}
