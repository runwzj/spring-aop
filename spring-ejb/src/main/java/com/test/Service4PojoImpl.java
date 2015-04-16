package com.test;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

public class Service4PojoImpl {

	@Produces @Alternative
	public Service4Pojo produceService4Factory1(){
		return new Service4Pojo(){
			@Override
			public void function() {
				System.out.println("produce By produceService4Factory1");
			}
		} ;
	}
	
	@Produces @Default
	public Service4Pojo produceService4Factory2(){
		return new Service4Pojo(){
			@Override
			public void function() {
				System.out.println("produce By produceService4Factory2");
			}
		} ;
	}
	
}
