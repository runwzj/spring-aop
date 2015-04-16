package com.spring;

import javax.ejb.Remote;

@Remote
public interface ServiceTransactionRemote {

	public Object invokeRequired(Class<?> targetClass,Signature signature) throws Exception;
	
}
