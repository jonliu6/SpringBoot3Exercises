package org.freecode.demo.springboot3restapisecurity.dao;

import org.freecode.demo.springboot3restapisecurity.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * by default, JpaRepository has the implementation for the following:
 * - findAll()
 * - findById(...)
 * - save(...)
 * - deleteById(...)
 * - ...
 */
public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
