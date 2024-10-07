package org.freecode.demo.springboot4restapis.controller;

import org.freecode.demo.springboot4restapis.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "groups")
/**
 * with Spring Data REST, the following URLs will be available generally using the plural of the entity name.
 * DAO, Services, RestController not required
 * However, you can specify in the path variable above
 * By default, the following URLs are available. NOTE: the context path is defined in application.properties
 *   - get all categories, http://<server>:<port>/datarest/groups (GET)
 *   - get a category, http://<server>:<port>/datarest/groups/1 (GET)
 *   - create a category, http://<server>:<port>/datarest/groups (POST)
 *   - update a category, http://<server>:<port>/datarest/groups/1 (PUT)
 *   - delete a category, http://<server>:<port>/datarest/groups/1 (DELETE)
 * You can also specify the pagination and sorting in the URLs. eg:
 *   - http://<server>:<port>/datarest/groups?page=0&sort=category,desc
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
