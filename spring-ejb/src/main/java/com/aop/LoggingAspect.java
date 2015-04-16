package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution( public * *(..) )")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logging!!!!");
	}
	
}
