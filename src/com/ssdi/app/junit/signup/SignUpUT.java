package com.ssdi.app.junit.signup;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import com.ssdi.app.business.SignUp;
import com.ssdi.util.HibernateUtil;
public class SignUpUT {
	
	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	SignUp signUp = new SignUp();
	 @Test
	   public void testSignUp() throws Exception{
		 
		 when(request.getParameter("emailS")).thenReturn("email1@asd.com");
	     when(request.getParameter("encPwd2")).thenReturn("e10adc3949ba59abbe56e057f20f883e");
	     when(request.getParameter("DOB")).thenReturn("02/02/1990"); 
	     when(request.getParameter("actionName")).thenReturn("signup"); 
		 String pageName = signUp.businessMethod(request, session);
		 assertEquals("HomePage",pageName);
	   }
	 @Test
	   public void testCheckEmail() throws Exception{
		 
		 when(request.getParameter("emailS")).thenReturn("test");
	     when(request.getParameter("actionName")).thenReturn("checkEmail"); 
		 String pageName = signUp.businessMethod(request, session);
		 assertEquals("test",pageName);
	   }
	
}
