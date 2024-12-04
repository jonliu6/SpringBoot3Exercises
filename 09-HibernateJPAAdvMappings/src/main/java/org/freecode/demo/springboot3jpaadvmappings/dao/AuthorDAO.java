package org.freecode.demo.springboot3jpaadvmappings.dao;

import org.freecode.demo.springboot3jpaadvmappings.entity.Author;

public interface AuthorDAO {

    void save(Author anAuthor);
    
    int findMaxAuthorId();
	
    Author findById(int authorId);
	
    Author updateAuthor (Author anAuthor);
	
    Author deleteById(int authorId);

}
