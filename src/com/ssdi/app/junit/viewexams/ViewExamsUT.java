package com.ssdi.app.junit.viewexams;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.junit.Test;

import com.ssdi.app.business.ViewExams;
import com.ssdi.util.HibernateUtil;
public class ViewExamsUT {
	
	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	ViewExams signUp = new ViewExams();
	 @Test
	   public void testSignUp() throws Exception{
		 
	     when(request.getParameter("actionName")).thenReturn("exams"); 
		 String pageName = signUp.businessMethod(request, session);
		 assertEquals("ExamsPage",pageName);
	   }
	
	
}
