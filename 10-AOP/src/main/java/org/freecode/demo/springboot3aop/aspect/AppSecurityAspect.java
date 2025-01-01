package org.freecode.demo.springboot3aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-3)
public class AppSecurityAspect {

	@Before("org.freecode.demo.springboot3aop.aspect.AppPointcutDeclatation.declarePointcutExpiressionForNonRetrievalMethods()")
	/**
	 * Use the Pointcut expression from a declaration above
	 */
	public void adviseSecurityBeforeNonRetrievalMethod(JoinPoint jp) {
		System.out.println("=====>>> Security-checking @Before advice on any methods excluding the ones with the name starting with \"find\" or \"query\" and any return type.");
	    // method signature
		MethodSignature mSig = (MethodSignature) jp.getSignature();
		System.out.println("=====>>> Security-checking Method Signature: " + mSig);
		
		// method arguments
		System.out.println("=====>>> Security-checking Method Arguments:");
		Object[] mArgs = jp.getArgs();
		for (Object mArg : mArgs) {
			System.out.println("    " + mArg);
		}
	}
	
	@Around("execution(* org.freecode.demo.springboot3aop.dao.UserDAOImpl.queryHeavyTransation(..))")
	/**
	 * The advice applied before and after the method call, and it can be used to capture the method exception
	 * @param pjp
	 * @return result of the method call
	 * @throws Throwable
	 */
	public Object adviseSecurityAroundDoMethods(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		System.out.println("=====>>> Security-checking adviseSecurityAroundDoMethods() for method execution time elapse");
		long begin = System.currentTimeMillis();
		pjp.proceed(); // you can also handle exception of the method call here
		long end = System.currentTimeMillis();
		System.out.println("=====>>> Security-checking adviseSecurityAroundDoMethods() executed for " + (end-begin)/1000.0 + " ms");
		
		return result;
	}
}
