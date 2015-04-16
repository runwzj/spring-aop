package com.test;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class Service2Ejb
 */
@Stateless
@LocalBean
@Default //如果有掛@LocalBean 那就需要@Default才可以 @Inject方式注入預設的 否則Container會搞不清是要注入LocalBean還是Service2Ejb代理物件
public class Service2Ejb implements Service2EjbRemote,Service2EjbLocal {

	@PersistenceContext EntityManager em ;
	
    public Service2Ejb() {
        
    }


	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void functionLocal() {
		System.out.println("Service2 Ejb Local is called");
		Customer c = em.find(Customer.class, "1");
		c.setBirthday(new Date());
		em.merge(c);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void functionRemote() {
		System.out.println("Service2 Ejb Remote is called");
		Customer c = em.find(Customer.class, "1");
		c.setAddress("HishChung");
		em.merge(c);
	}

}
