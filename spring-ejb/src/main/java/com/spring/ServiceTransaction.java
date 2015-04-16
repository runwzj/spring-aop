package com.spring;

import java.lang.reflect.Method;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Session Bean implementation class ServiceTransaction
 */
@SuppressWarnings({"static-access"}) 
@Stateless
@LocalBean
public class ServiceTransaction implements ServiceTransactionRemote {

    /**
     * Default constructor. 
     */
    public ServiceTransaction() {
        
    }

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object invokeRequired(Class<?> targetClass,Signature signature) throws Exception{

		String methodName = signature.getMethodName() ;
		Object[] args = signature.unzipArgs() ;
		Class<?>[] argTypes = signature.extractArgTypes(args);
		
		System.out.println("代理執行方法:"+methodName);
		System.out.println("代理執行參數:"+args);
		
		Method method = targetClass.getMethod(methodName, argTypes);
		return method.invoke(targetClass.newInstance(), args);
		
	}

}
