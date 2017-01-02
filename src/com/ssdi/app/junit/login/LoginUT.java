package com.ssdi.app.junit.login;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.Test;
import org.mockito.Mockito;

import com.ssdi.app.business.Login;
import com.ssdi.tables.UserDtls;
import com.ssdi.util.HibernateUtil;
public class LoginUT {
	
	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	Login login = new Login();
	 @Test
	   public void testLogin() throws Exception{
		 when(request.getParameter("actionName")).thenReturn("login");
	     when(request.getParameter("encPwd")).thenReturn("e10adc3949ba59abbe56e057f20f883e");
	     when(request.getParameter("email")).thenReturn("test"); 
	     HttpSession httpsession = mock(HttpSession.class);
	     Mockito.when(request.getSession()).thenReturn(httpsession);
	      //double appraisal= empBusinessLogic.calculateAppraisal(employee);
	     // assertEquals(500, appraisal, 0.0);
		 String pageName = login.businessMethod(request, session);
		 assertEquals("header",pageName);
	   }
	 @Test
	   public void testLoginFail() throws Exception{
		 when(request.getParameter("actionName")).thenReturn("login");
	     when(request.getParameter("encPwd")).thenReturn("e10adc3949ba59abbe56e057f20f883e");
	     when(request.getParameter("email")).thenReturn("test1232"); 
	     HttpSession httpsession = mock(HttpSession.class);
	     Mockito.when(request.getSession()).thenReturn(httpsession);
	      //double appraisal= empBusinessLogic.calculateAppraisal(employee);
	     // assertEquals(500, appraisal, 0.0);
		 String pageName = login.businessMethod(request, session);
		 assertEquals("HomePage",pageName);
	   }
	 
	 @Test
	   public void testLoginOut() throws Exception{
		 when(request.getParameter("actionName")).thenReturn("logout");
	     HttpSession httpsession = mock(HttpSession.class);
	     httpsession.setAttribute("userDtls", new UserDtls());
	     Mockito.when(request.getSession()).thenReturn(httpsession);
	      //double appraisal= empBusinessLogic.calculateAppraisal(employee);
	     // assertEquals(500, appraisal, 0.0);
		 String pageName = login.businessMethod(request, session);
		 assertEquals("HomePage",pageName);
	   }
	
}
