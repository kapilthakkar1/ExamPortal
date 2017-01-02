package com.ssdi.util.junit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.Test;
import org.mockito.Mockito;

import com.ssdi.util.BusinessClassUtils;
import com.ssdi.util.HibernateUtil;
public class BusinessClassUtilsUT {
	
	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	BusinessClassUtils businessClassUtils = new BusinessClassUtils();
	@Test
	   public void testGetClassNameFromDB() throws Exception{
			 String result = businessClassUtils.getClassNameFromDB(session, "2");
			 assertEquals("com.ssdi.app.business.HomePage",result);
		 
	   }
	 @Test
	   public void testExecuteMethod() throws Exception{
		 
			 when(request.getParameter("actionName")).thenReturn("homePage");
		 String pageName = businessClassUtils.executeBusinessMethod( businessClassUtils.getClassNameFromDB(session, "2"), request, session);
		 assertEquals("HomePage",pageName);
	   }
	 
	
}
