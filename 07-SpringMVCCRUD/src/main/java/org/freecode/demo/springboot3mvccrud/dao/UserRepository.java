package org.freecode.demo.springboot3mvccrud.dao;

import org.freecode.demo.springboot3mvccrud.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * by default, JpaRepository has the implementation for the following:
 * - findAll()
 * - findById(...)
 * - save(...)
 * - deleteById(...)
 * - ...
 */
public interface UserRepository extends JpaRepository<RegisteredUser, String>{

}
