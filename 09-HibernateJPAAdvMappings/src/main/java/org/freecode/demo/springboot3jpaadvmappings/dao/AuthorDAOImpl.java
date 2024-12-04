package org.freecode.demo.springboot3jpaadvmappings.dao;

import org.freecode.demo.springboot3jpaadvmappings.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AuthorDAOImpl implements AuthorDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public AuthorDAOImpl(EntityManager em) {
		this.entityManager = em;
	}

	@Override
	@Transactional
	public void save(Author anAuthor) {
		entityManager.persist(anAuthor);
	}
	
	@Override
	public int findMaxAuthorId() {
		Object obj = entityManager.createQuery("SELECT MAX(id) FROM Author").getSingleResult();
		if (obj != null) {
			return Integer.parseInt(obj.toString());
		}
		return 0;
	}

	@Override
	public Author findById(int authorId) {
		return entityManager.find(Author.class, authorId);
	}

	@Override
	@Transactional
	public Author updateAuthor(Author anAuthor) {
		return entityManager.merge(anAuthor);
	}

	@Override
	@Transactional
	public Author deleteById(int authorId) {
		Author foundAuthor = findById(authorId);
		if (foundAuthor != null) {
		    entityManager.remove(foundAuthor);
		}
		
		return foundAuthor;
	}

}
