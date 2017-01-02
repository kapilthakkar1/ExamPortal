package com.ssdi.app.junit.homepage;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.junit.Test;

import com.ssdi.app.business.HomePage;
import com.ssdi.util.HibernateUtil;
public class HomePageUT {
	
	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	HomePage homePage = new HomePage();
	 @Test
	   public void testHomePage() throws Exception{
		 
		 when(request.getParameter("actionName")).thenReturn("homePage");
		 String pageName = homePage.businessMethod(request, session);
		 assertEquals("HomePage",pageName);
	   }
	
	
}
