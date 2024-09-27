package org.freecode.demo.springboot3hibernate.dao;

import java.util.List;

import org.freecode.demo.springboot3hibernate.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
/**
 * NOTE: Transaction annotation is required when Executing an update/delete query
 */
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

	@Override
	public Album findById(int albumId) {
		return entityManager.find(Album.class, albumId);
	}

	@Override
	public List<Album> findAll() {
		TypedQuery<Album> query = entityManager.createQuery("FROM Album", Album.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Album updateAnAlbum(Album album) {
		return entityManager.merge(album);
	}

	@Override
	@Transactional
	public int updateFormatOfAlbums(String newFormat) {
		int updatedCount = entityManager.createQuery("UPDATE Album a SET a.format = :newFmt")
				.setParameter("newFmt", newFormat)
				.executeUpdate();
		return updatedCount;
	}

	@Override
	@Transactional
	/**
	 * Note: EntityManager.remove() only works on the entity within the same transaction, so find first before remove.
	 * @param album
	 */
	public Album deleteById(int albumId) {
		Album album = findById(albumId);
		if (album != null) {
		    entityManager.remove(album);
		}
		return album;
	}

	@Override
	@Transactional
	public int deleteByName(String name) {
		int deletedCount = entityManager.createQuery("DELETE FROM Album a WHERE a.name = :name")
				.setParameter("name", name)
				.executeUpdate();
		return deletedCount;
	}

	
}
