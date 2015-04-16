package com.aop;

import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import com.spring.ServiceTransactionRemote;
import com.spring.Signature;

@Aspect
@Data
public class TransactionAspect {

	private ServiceTransactionRemote ejb ;
	
	@Around("execution( * com.spring.BussinessObjectImpl.*(..) )")
	public Object transactionAOP(ProceedingJoinPoint joinPoint) throws Throwable {
	 
			System.out.println("幫你附加交易功能!!!!");
			System.out.println("準備好EJB:"+ejb);
			Class<?> clazz = joinPoint.getSignature().getDeclaringType() ;
			String methodName = joinPoint.getSignature().getName();
			Object[] args = joinPoint.getArgs() ;
			Object target = joinPoint.getTarget() ;

			System.out.println("對象物件:"+target);
			System.out.println("對象方法:"+methodName);
			System.out.println("對象參數:"+args);

			Signature signature = new Signature(methodName,args);
			return ejb.invokeRequired(clazz, signature);

	 
	   }
	
}
