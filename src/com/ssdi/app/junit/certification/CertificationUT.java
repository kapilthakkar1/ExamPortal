package com.ssdi.app.junit.certification;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.Test;
import org.mockito.Mockito;

import com.ssdi.app.business.Certification;
import com.ssdi.tables.UserDtls;
import com.ssdi.util.HibernateUtil;

public class CertificationUT {

	HttpServletRequest request = mock(HttpServletRequest.class);
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	Certification c = new Certification();

	@Test
	public void testCertification() throws Exception {
		when(request.getParameter("actionName")).thenReturn("certification");
		when(request.getParameter("examId")).thenReturn("101");
		UserDtls userDtls = new UserDtls();
		userDtls.setUserId(1);
		HttpSession httpsession = mock(HttpSession.class);
		// when(request.getParameter("userDtls")).thenReturn(user);
		when(httpsession.getAttribute("userDtls")).thenReturn(userDtls);
		Mockito.when(request.getSession()).thenReturn(httpsession);
		String pageName = c.businessMethod(request, session);

		assertEquals("CertificationPage", pageName);
	}
}
