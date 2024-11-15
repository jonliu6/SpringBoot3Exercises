package org.freecode.demo.springboot3mvccrud.service;

import java.util.List;

import org.freecode.demo.springboot3mvccrud.model.RegisteredUser;

public interface UserService {
	
	List<RegisteredUser> findAll();
	
	RegisteredUser findById(String id);
	
	RegisteredUser save(RegisteredUser aUser);
	
	void deleteById(String id);

}
