package org.freecode.demo.springboot3aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {

	@Before("execution(public void executeDAOMethod())")
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
	public void adviseBeforeMethodExecution() {
		System.out.println("\n=====>>> Executing @Before advice on method execution.");
	}
	
	@Pointcut("execution(public * org.freecode.demo.springboot3aop.dao.*.add*(..))")
	/**
	 * This is the Pointcut expression declaration when need to apply the same Pointcut expression to many places
	 * The above Pointcut expression in the declaration (declarePointcutExpression) applied before the call of:
	 * - any method in the package
	 * - and the method name starting with "add"
	 * - and the method has any parameters
	 * - and the method returns any type
	 */
	private void declarePointcutExpression() {}
	
	// @Before("execution(public * org.freecode.demo.springboot3aop.dao.*.add*(..))")
	@Before("declarePointcutExpression()")
	/**
	 * Use the Pointcut expression from a declaration above
	 */
	public void adviseBeforeAddMethod() {
		System.out.println("\n=====>>> Executing @Before advice on any method name starting with \"add\" and any return type.");
	}
}
