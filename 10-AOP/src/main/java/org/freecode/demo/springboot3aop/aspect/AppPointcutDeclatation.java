package org.freecode.demo.springboot3aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
/**
 * Note: if this class only contains @Pointcut without any advices, @Aspect is optional
 */
public class AppPointcutDeclatation {

	@Pointcut("execution(public * org.freecode.demo.springboot3aop.dao.*.add*(..))")
	/**
	 * This is the Pointcut expression declaration when need to apply the same Pointcut expression to many places
	 * The above Pointcut expression in the declaration (declarePointcutExpressionForAddMethods) applied before the call of:
	 * - any method in the package
	 * - and the method name starting with "add"
	 * - and the method has any parameters
	 * - and the method returns any type
	 */
	public void declarePointcutExpressionForAddMethods() {}
	
	@Pointcut("execution(public * org.freecode.demo.springboot3aop.dao.*.*(..))")
	public void declarePointcutExpressionForAll() {}
	
	@Pointcut("execution(public * org.freecode.demo.springboot3aop.dao.*.query*(..))")
	public void declarePointcutExpressionForQueryMethods() {}
	
	@Pointcut("execution(public * org.freecode.demo.springboot3aop.dao.*.find*(..))")
	public void declarePointcutExpressionForFindMethods() {}
	
	@Pointcut("declarePointcutExpressionForAll() && !(declarePointcutExpressionForQueryMethods() || declarePointcutExpressionForFindMethods())")
	public void declarePointcutExpiressionForNonRetrievalMethods() {}
}
