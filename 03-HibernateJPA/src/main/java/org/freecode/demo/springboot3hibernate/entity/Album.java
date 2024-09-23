package org.freecode.demo.springboot3hibernate.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="t_album")
public class Album {
	
	/**
	 *  By default, Spring JPA auto-translate the Camel-case column names with the underscore-delimited names
	 *  For example, @Column(name="AlbumName") is auto-translated to "album_name".
	 *  If you want to keep your column names, use all in lower case
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="albumname")
	private String name;
	
	@Column(name="artist")
	private String artist;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="publishdate")
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	
	@Column(name="albumformat")
	private String format;
	
	public Album() {
		
	}

	public Album(String name, String artist, String genre, Date publishDate, String format) {
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.publishDate = publishDate;
		this.format = format;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", publishDate="
				+ publishDate + ", format=" + format + "]";
	}
}
