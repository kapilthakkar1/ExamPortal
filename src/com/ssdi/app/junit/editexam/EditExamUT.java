package com.ssdi.app.junit.editexam;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.junit.Test;

import com.ssdi.app.business.EditExam;
import com.ssdi.app.dao.EditExamDAO;
import com.ssdi.app.dao.EditExamDAOImpl;
import com.ssdi.tables.ExamDtls;
import com.ssdi.util.HibernateUtil;
public class EditExamUT {

	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	EditExam editExam = new EditExam();
	@Test
	public void testvViewExistExam() throws Exception{
		when(request.getParameter("actionName")).thenReturn("viewExistExam"); 
		when(request.getParameter("examId")).thenReturn("101");	 
		when(request.getParameter("examName")).thenReturn("Exam Test 2");
		when(request.getParameter("examDescription")).thenReturn("Teree");
		when(request.getParameter("cutoff")).thenReturn("80"); 
		when(request.getParameter("certificateName")).thenReturn("Certi 2"); 
		String pageName = editExam.businessMethod(request, session);
		assertEquals("editExam",pageName);	
	}

	@Test
	public void testUpdateExam() throws Exception{
		when(request.getParameter("actionName")).thenReturn("viewExistExam"); 
		when(request.getParameter("examId")).thenReturn("101");	 
		when(request.getParameter("examName")).thenReturn("Exam Test 2");
		when(request.getParameter("examDescription")).thenReturn("Teree");
		when(request.getParameter("cutoff")).thenReturn("80"); 
		when(request.getParameter("certificateName")).thenReturn("Certi 2"); 
		when(request.getParameter("noOfQues")).thenReturn("10"); 
		String pageName = editExam.businessMethod(request, session);
		assertEquals("editExam",pageName);	
	}

	@Test
	public void testViewExams() throws Exception{
		when(request.getParameter("actionName")).thenReturn("viewExams"); 
		when(request.getParameter("searchStr")).thenReturn("html"); 
		String pageName = editExam.businessMethod(request, session);
		assertEquals("examPageAdmin",pageName);	
	}

	@Test
	public void testEditExamDAO() throws Exception{
		ExamDtls ExamDtls = new ExamDtls();
		ExamDtls.setExamId(101);
		ExamDtls.setExamName("Test");
		ExamDtls.setExamDescr("Test D");
		ExamDtls.setcrtdate(new Date());
		ExamDtls.setcutoff(75);
		ExamDtls.setcertificateName("Test C");
		ExamDtls.setNoOfQuestion(5);
		EditExamDAO editExamDAO = new EditExamDAOImpl();
		ExamDtls = editExamDAO.editExam(ExamDtls, session);
		assertNotNull(ExamDtls);	
	}
	
	@Test
	public void testEditExamDAOFetch() throws Exception{
		EditExamDAO editExamDAO = new EditExamDAOImpl();
		ExamDtls  res = editExamDAO.fetchExam(101, session);
		assertNotNull(res);	
	}
}



