package com.ssdi.app.junit.searchExam;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.junit.Test;

import com.ssdi.app.business.ViewExams;
import com.ssdi.util.HibernateUtil;

public class SearchExamUT {
	HttpServletRequest request = mock(HttpServletRequest.class);
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	ViewExams exams = new ViewExams();

	@Test
	public void testSignUp() throws Exception {

		when(request.getParameter("actionName")).thenReturn("viewExams");
		when(request.getParameter("searchStr")).thenReturn("HTML");
		String pageName = exams.businessMethod(request, session);
		assertEquals("ExamsPage", pageName);
		System.out.println("Success");
	}

}
