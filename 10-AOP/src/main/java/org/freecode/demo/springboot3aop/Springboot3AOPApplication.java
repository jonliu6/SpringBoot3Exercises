package org.freecode.demo.springboot3aop;

import org.freecode.demo.springboot3aop.dao.AppDAO;
import org.freecode.demo.springboot3aop.dao.UserDAO;
import org.freecode.demo.springboot3aop.model.Article;
import org.freecode.demo.springboot3aop.model.Author;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot3AOPApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3AOPApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDao, UserDAO usrDao) {
		return runner -> {
			demoBeforeAdvice(appDao);
			
			demoPointcutExpression(appDao, usrDao);
		};
	}
	
	private void demoBeforeAdvice(AppDAO dao) {
		dao.executeDAOMethod();
	}
	
	private void demoPointcutExpression(AppDAO appDao, UserDAO usrDao) {
		Author usr = new Author("John", "Smith");
		System.out.println(usrDao.addAuthor(usr));
		
		Article doc = new Article("Test Article #1", "Demo", "Blah blah blah...");
		appDao.addArticle(usr, doc);
		
	}
}
