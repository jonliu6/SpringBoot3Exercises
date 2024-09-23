package org.freecode.demo.springboot3hibernate.dao;

import org.freecode.demo.springboot3hibernate.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlbumDAOImpl implements AlbumDAO {
	
	// define entity manager
	private EntityManager entityManager;
	
	// inject entity manager using constructor
	@Autowired
	public AlbumDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// override interface methods

	@Override
	@Transactional
	public void save(Album anAlbum) {
		entityManager.persist(anAlbum);
	}

	
}
