package com.spring;

import lombok.Data;

import com.test.ServiceEjbRemote;

@Data
public class SpringInjectEjb {

	private ServiceEjbRemote remote ;
	
	public void test(String param){
		System.out.println(param);
		System.out.println(remote);
	}
	
}
