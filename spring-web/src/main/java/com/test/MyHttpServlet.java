package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.BussinessObjectImpl;


@WebServlet(value="/hello",
initParams = {
   @WebInitParam(name="foo", value="Hello "),
   @WebInitParam(name="bar", value=" World!")
})
public class MyHttpServlet extends GenericServlet  {
	
	private static final long serialVersionUID = 1L;
	@EJB ServiceEjbRemote remote ;
	
	static ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml") ;
	
	public void service(ServletRequest req, ServletResponse res)
			throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		out.println(getInitParameter("foo"));
		out.println(getInitParameter("bar")) ;

		
		BussinessObjectImpl bo = (BussinessObjectImpl) ctx.getBean("businessObj");
		System.out.println("從Context取得BO:"+bo);
		String ret = bo.doBusiness("hello") ;
		out.println(ret);
		
		remote.function1();

		System.out.println("done") ;

	}

	
}
