package com.test;

import javax.ejb.EJB;

public class Helper {

	@EJB ServiceEjbRemote remote ;
	
	public void help(){
		System.out.println(remote);
	}
	
}
