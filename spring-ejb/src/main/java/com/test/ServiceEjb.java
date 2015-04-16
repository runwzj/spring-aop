package com.test;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import lombok.Data;

import com.test.ReNameService5.Impl;

/**
 * Session Bean implementation class ServiceEjb
 */
@Stateless(name="jndi.serviceEjb")
@PersistenceUnit(unitName="jndi.test", name="jndi.test")
@Data
public class ServiceEjb implements ServiceEjbRemote {

	@PersistenceContext EntityManager em ;
  
	@EJB Service2EjbLocal service2local1; //Proxy for view class: com.test.Service2EjbLocal of EJB: Service2Ejb
	
	@EJB Service2EjbRemote service2remote1; //Proxy for remote EJB StatelessEJBLocator{appName='spring-ear', moduleName='spring-web', distinctName='', beanName='Service2Ejb', view='interface com.test.Service2EjbRemote'}
	
	@Inject Service2EjbLocal service2local2; //Proxy for view class: com.test.Service2EjbLocal of EJB: Service2Ejb
	
	//遠端物件不可以透過 @Inject，一定要透過 @EJB
	//@Inject Service2EjbRemote service2remote2;
	
	@Inject Service3Pojo service3 ;
	
	@Inject Service4Pojo service4 ;
	
	@Inject @ReNameService5(Impl.Impl1) Service5Pojo service5_1 ; //透過 @ReNameService5 來識別要注入的對象是誰
	
	@Inject @ReNameService5(Impl.Impl2) Service5Pojo service5_2 ;
	
	//沒指名就給default
	@Inject Service5Pojo service5_3 ;
	
	
	
    public ServiceEjb() {
    	
    }


	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void function1() {

		Customer c = em.find(Customer.class, "1");
        System.out.println("Service Ejb is called");
        System.out.println(c) ;
        c.setName("Roy");
        em.merge(c);
       
        System.out.println(service2local1);
        service2local1.functionLocal();
        System.out.println(service2remote1);
        
        System.out.println(service2local2);
        service2local2.functionLocal();
        //System.out.println(service2remote2);
        
        System.out.println(service3);
        
        System.out.println(service4);
        service4.function();
        
        System.out.println(service5_1);
        
        System.out.println(service5_2);
        
        System.out.println(service5_3);
        
	}

}
