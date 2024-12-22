package org.freecode.demo.springboot3jpaadvmappings.dao;

import org.freecode.demo.springboot3jpaadvmappings.entity.Author;
import org.freecode.demo.springboot3jpaadvmappings.entity.Post;
import org.freecode.demo.springboot3jpaadvmappings.entity.Reference;

public interface AppDAO {

    void save(Author anAuthor);
    
    int findMaxAuthorId();
	
    Author findById(int authorId);
	
    Author updateAuthor (Author anAuthor);
	
    Author deleteById(int authorId);
    
    Author findAuthorWithPostsById(int authorId);
    
    Post findPostById(int id);
    
    void update(Post aPost);
    
    void deletePostById(int id);
    
    int deleteAllPostsWithoutAuthor();
    
    void deleteAuthorFromPostsById(int id);

    Post findPostWithCommentsById(int postId);
    void deletePostAndCommentsById(int postId);
    
    Post findPostWithReferencesById(int postId);
    
    Reference findReferenceById(int refId);
    public Reference findReferenceAndPostsById(int refId);
    
    void deleteReferenceById(int refId);
}
