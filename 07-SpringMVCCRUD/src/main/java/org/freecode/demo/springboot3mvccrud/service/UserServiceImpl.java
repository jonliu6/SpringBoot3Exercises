package org.freecode.demo.springboot3mvccrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.freecode.demo.springboot3mvccrud.dao.UserRepository;
import org.freecode.demo.springboot3mvccrud.model.RegisteredUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository repo) {
		userRepo = repo;
	}

	@Override
	public List<RegisteredUser> findAll() {
		return userRepo.findAll();
	}

	@Override
	/**
	 * JpaRepository findById(...) returns Optional type
	 */
	public RegisteredUser findById(String id) {
		Optional<RegisteredUser> user = userRepo.findById(id);
		RegisteredUser foundUser = null;
		if (user.isPresent()) {
			foundUser = user.get();
		}
		
		return foundUser;
	}

	@Override
	public RegisteredUser save(RegisteredUser aUser) {
		return userRepo.save(aUser);
	}
	
	@Override
	public void deleteById(String id) {
		userRepo.deleteById(id);
	}
}
