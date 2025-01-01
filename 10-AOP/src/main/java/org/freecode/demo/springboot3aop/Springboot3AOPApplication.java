package org.freecode.demo.springboot3aop;

import java.util.List;

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
//			demoBeforeAdvice(appDao);
//			
//			demoBeforePointcutExpression(appDao, usrDao);
//			
//			demoAfterReturningAdvice(usrDao);
			
//			demoAfterThrowingAdvice(appDao);
			
			demoAroundAdvice(usrDao);
		};
	}
	
	private void demoAroundAdvice(UserDAO dao) {
		System.out.println("Main: demoAroundAdvice() executing");
		dao.queryHeavyTransation();		
		System.out.println("Main: demoAroundAdvice() finished");
	}
	
	private void demoAfterThrowingAdvice(AppDAO dao) {
		try {
			dao.findAllArticles(true);
		}
		catch (Exception ex) {
			System.out.println("Main: exception caught: " + ex.getMessage());
		}
	}
	
	private void demoBeforeAdvice(AppDAO dao) {
		dao.executeDAOMethod();
	}
	
	private void demoBeforePointcutExpression(AppDAO appDao, UserDAO usrDao) {
		Author usr = new Author("John", "Smith");
		System.out.println(usrDao.addAuthor(usr));
		
		usrDao.findAuthor(usr); // no @Before advice triggered
		
		Article doc = new Article("Test Article #1", "Demo", "Blah blah blah...");
		appDao.addArticle(usr, doc);
		
		appDao.queryArticle(doc); // no @Before advice triggered
		
	}
	
	private void demoAfterReturningAdvice(UserDAO usrDao) {
		List<Author> users = usrDao.findAllAuthors(); // post-process during @AfterReturning changes the last name of authors to upper case
		
		System.out.println("Main.demoAfterReturningAdvice(): all authors: " + users);
	}
}
