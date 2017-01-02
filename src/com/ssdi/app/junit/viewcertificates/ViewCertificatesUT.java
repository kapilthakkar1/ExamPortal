package com.ssdi.app.junit.viewcertificates;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.Test;
import org.mockito.Mockito;

import com.ssdi.app.business.ViewCertificates;
import com.ssdi.app.dao.ViewCertificatesDAO;
import com.ssdi.app.dao.ViewCertificatesDAOImpl;
import com.ssdi.tables.UserDtls;
import com.ssdi.util.HibernateUtil;

public class ViewCertificatesUT {
	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	ViewCertificates viewCertificates = new ViewCertificates();
	 @Test
	   public void testViewCertificates() throws Exception{
		 when(request.getParameter("actionName")).thenReturn("exams");
		 when(request.getParameter("examId")).thenReturn("101");
		 HttpSession httpsession = mock(HttpSession.class);
		 UserDtls userDtls = new UserDtls();
		 userDtls.setUserId(1);
		when(httpsession.getAttribute("userDtls")).thenReturn(userDtls);
	    Mockito.when(request.getSession()).thenReturn(httpsession);
	    String pageName = viewCertificates.businessMethod(request, session);
		assertEquals("certificatesPage",pageName);
		 
	 }
	 @Test
		public void testViewCertificatesDAO() throws Exception{
		 ViewCertificatesDAO ViewCertificatesDAO = new ViewCertificatesDAOImpl();
			List res = ViewCertificatesDAO.getCertificates(session,1);
			assertTrue(!res.isEmpty());

		}
}

