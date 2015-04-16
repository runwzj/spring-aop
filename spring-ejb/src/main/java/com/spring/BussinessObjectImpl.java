package com.spring;

import java.io.Serializable;

public class BussinessObjectImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	public String doBusiness(String param){
		
		return param+" world";
		
	}
	
}
