package org.freecode.demo.springboot3jpaadvmappings.dao;

import java.util.List;

import org.freecode.demo.springboot3jpaadvmappings.entity.Author;
import org.freecode.demo.springboot3jpaadvmappings.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager em) {
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

	@Override
	public Author findAuthorWithPostsById(int authorId) {
		TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a JOIN FETCH a.posts WHERE a.id = :authorId", Author.class);
		query.setParameter("authorId", authorId);
		
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public void update(Post aPost) {
		if (findPostById(aPost.getId()) == null) {
			entityManager.persist(aPost);
		}
		else {
		    entityManager.merge(aPost);
		}
	}

	@Override
	public Post findPostById(int id) {
		return entityManager.find(Post.class, id);
	}

	@Override
	@Transactional
	public void deleteAuthorFromPostsById(int id) {
		Author found = findById(id);
		if (found != null) {
			List<Post> posts = found.getPosts();
			if (posts != null) {
				// because of the One-to-Many mapping between Author and Posts, need to remove the author from the posts first before deleting the author.
				for (Post aPost : posts) {
					if (aPost != null) {
						aPost.setAuthor(null);
					}
				}
			}
			entityManager.remove(found);
		}
	}

	@Override
	public Post findPostWithCommentsById(int postId) {
		TypedQuery<Post> query = entityManager.createQuery("FROM Post p JOIN FETCH p.comments WHERE p.id = :pid", Post.class);
		query.setParameter("pid", postId);
		
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public void deletePostAndCommentsById(int postId) {
		Post found = findPostById(postId);
		if (found != null) {
			entityManager.remove(found);
		}
		
	}

	@Override
	public void deletePostById(int id) {
		Post found = findPostById(id);
		if (found != null) {
		    entityManager.remove(found);	
		}		
	}

	@Override
	@Transactional
	public int deleteAllPostsWithoutAuthor() {
		int deletedCount = entityManager.createQuery("DELETE FROM Post p").executeUpdate();
		return deletedCount;
	}

}
