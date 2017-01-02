package com.ssdi.app.junit.createexam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import com.ssdi.app.business.CreateExam1;
import com.ssdi.app.dao.CreateExamDAO;
import com.ssdi.app.dao.CreateExamDAOImpl;
import com.ssdi.app.dao.EditExamDAO;
import com.ssdi.app.dao.EditExamDAOImpl;
import com.ssdi.tables.ExamDtls;
import com.ssdi.util.HibernateUtil;
public class CreateExamUT {
	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	CreateExam1 create = new CreateExam1();
	
	@Test
	   public void testCreateExam1() throws Exception{
		 when(request.getParameter("examName")).thenReturn("Exam Test 2");
	     when(request.getParameter("examDescription")).thenReturn("Teree");
	     when(request.getParameter("cutoff")).thenReturn("80"); 
	     when(request.getParameter("certificateName")).thenReturn("Certi 2"); 
	     when(request.getParameter("actionName")).thenReturn("displayExam"); 
		 String pageName = create.businessMethod(request, session);
		 assertEquals("CreateExamPage",pageName);
	   }
	
	@Test
	public void testCreateExamDAO() throws Exception{
		CreateExamDAO createExamDAO = new CreateExamDAOImpl();
		ExamDtls ExamDtls = new ExamDtls();
		ExamDtls.setExamId(1010);
		ExamDtls.setExamName("Test");
		ExamDtls.setExamDescr("Test D");
		ExamDtls.setcrtdate(new Date());
		ExamDtls.setcutoff(75);
		ExamDtls.setcertificateName("Test C");
		ExamDtls.setNoOfQuestion(5);
		ExamDtls = createExamDAO.createexam( ExamDtls, session);
		assertNotNull(ExamDtls);	
	}
}



	


