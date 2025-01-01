package org.freecode.demo.springboot3aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.freecode.demo.springboot3aop.model.Author;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
/**
 * smaller number (positive or non-positive) has higher priority for the Order
 */
public class AppLoggingAspect {

//	@Before("execution(public void executeDAOMethod())")
	/**
	 * Pointcut: method signature - public void executeDAOMethod()
	 * In this case, it matches all the methods with the same name; for particular one, just the full-qualified class name
	 * eg execution(public void org.freecode.demo.springboot3aop.dao.AppDAO.executeDAOMethod())
	 * Method name, return type can have wildcards
	 * eg execution(public * execute*())
	 * Pointcut Expression Language: execution(modifier-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern? )
	 * Param Pattern Wildcards
	 *   - (): match a method with no parameters
	 *   - (*): match a method with one parameter of any type
	 *   - (..): match a method with 0 or more parameters of any type
	 */
//	public void adviseBeforeMethodExecution() {
//		System.out.println("\n=====>>> Executing @Before advice on method execution.");
//	}
	
	// @Before("execution(public * org.freecode.demo.springboot3aop.dao.*.add*(..))")
	/**
	 * Note: use the full-qualified name for the Pointcut declaration if it is not in the same class
	 */
//	@Before("org.freecode.demo.springboot3aop.aspect.AppPointcutDeclatation.declarePointcutExpressionForAddMethods()")
	@Before("org.freecode.demo.springboot3aop.aspect.AppPointcutDeclatation.declarePointcutExpiressionForNonRetrievalMethods()")
	/**
	 * Use the Pointcut expression from a declaration above
	 */
	public void adviseBeforeNonRetrievalMethod() {
		System.out.println("=====>>> Logging @Before advice on any methods excluding the ones with the name starting with \"find\" or \"query\" and any return type.");
	}
	
	@AfterReturning( pointcut = "execution(* org.freecode.demo.springboot3aop.dao.UserDAOImpl.findAllAuthors(..))", 
			         returning = "result")
	/**
	 * 
	 * @param jp
	 * @param result - NOTE name match to "result" is required
	 */
	public void adviseAfterReturningFindAllAuthors(JoinPoint jp, List<Author> result) {
		System.out.println("=====>>> Logging @AfterReturning advice on findAllAccounts()");
		// update the result after returning
		for (Author usr : result) {
			if (usr != null) {
			    String upperLastName = usr.getLastName().toUpperCase();
			    usr.setLastName(upperLastName);
			}
		}
	}
	
	@AfterThrowing( pointcut = "execution(* org.freecode.demo.springboot3aop.dao.AppDAOImpl.findAllArticles(..))",
			throwing = "ex")
	/**
	 * 
	 * @param jp
	 * @param ex - NOTE: name match to "ex" is required
	 */
	public void adviseAfterThrowingFindAllArticles(JoinPoint jp, Throwable ex) {
		System.out.println("=====>>> Logging @AfterThrowing advice on findAllArticles()");
		System.out.println("    Exception caught: " + ex.getMessage());
	}
	
	@After("execution(* org.freecode.demo.springboot3aop.dao.AppDAOImpl.findAllArticles(..))")
	/**
	 * this advise applied regardless of the method call successful or failed, just like the finally block in the exception handling
	 * @param jp
	 */
	public void adviseAfterFinallyFindAllArticles(JoinPoint jp) {
		System.out.println("=====>>> Logging @After (finally) advice on findAllArticles()");
		Object[] mArgs = jp.getArgs();
		for (Object mArg : mArgs) {
			System.out.println("    " + mArg);
		}
	}
}
