package org.freecode.demo.springboot3hibernate.dao;

import java.util.List;

import org.freecode.demo.springboot3hibernate.entity.Album;

public interface AlbumDAO {

	void save(Album anAlbum);
	
	Album findById(int albumId);
	
	List<Album> findAll();
	
	Album updateAnAlbum(Album album);
	
	int updateFormatOfAlbums(String newFormat);
	
	Album deleteById(int albumId);
	
	int deleteByName(String name);
}
