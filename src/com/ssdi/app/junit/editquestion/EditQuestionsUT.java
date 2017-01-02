package com.ssdi.app.junit.editquestion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.junit.Test;

import com.ssdi.app.business.ViewEditQuestions;
import com.ssdi.app.dao.ViewEditQuestionDAO;
import com.ssdi.app.dao.ViewEditQuestionDAOImpl;
import com.ssdi.tables.QuestionDtls;
import com.ssdi.util.HibernateUtil;

public class EditQuestionsUT {

	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	ViewEditQuestions viewEditQuestions = new ViewEditQuestions();
	 
	@Test
	public void testViewExams() throws Exception{
		 
		 when(request.getParameter("actionName")).thenReturn("viewQuestions");
		 when(request.getParameter("examId")).thenReturn("101");
		 when(request.getParameter("examName")).thenReturn("HTML");
		 String pageName = viewEditQuestions.businessMethod(request, session);
		 assertEquals("viewQues",pageName);
	   }
	@Test
	public void testEditQuestions() throws Exception{
		 
		 when(request.getParameter("actionName")).thenReturn("updateQuestion");
		 when(request.getParameter("examId")).thenReturn("101");
		 when(request.getParameter("examName")).thenReturn("HTML");
		 
		 //++++++++++++
		 when(request.getParameter("question")).thenReturn("Which of the following is used to create web page?");
		 when(request.getParameter("Option1")).thenReturn("a. C Language");
		 when(request.getParameter("Option2")).thenReturn("b. DTD Language");
		 when(request.getParameter("Option3")).thenReturn("c. JVM Language");
		 when(request.getParameter("Option4")).thenReturn("d. HTML Language");
		 when(request.getParameter("answer")).thenReturn("2");
		 when(request.getParameter("quesNum")).thenReturn("1");
		 when(request.getParameter("time")).thenReturn("22");
		 
		 //++++++++++++++
		 
		 String pageName = viewEditQuestions.businessMethod(request, session);
		 assertEquals("viewQues",pageName);
	   }
	@Test
	public void testDAOViewQues() throws Exception
	{
		ViewEditQuestionDAO viewEditQuestionDAO = new ViewEditQuestionDAOImpl();
		List resList = viewEditQuestionDAO.viewQuestions(101L, session);
		assertFalse(resList.isEmpty());
	}
	
	@Test
	public void testDAOEditQuestion() throws Exception
	{
		ViewEditQuestionDAO viewEditQuestionDAO = new ViewEditQuestionDAOImpl();
		QuestionDtls questionDtls = new QuestionDtls();
		questionDtls.setQuestionNum(Long.parseLong("1"));
		questionDtls.setExamId(Long.parseLong("101"));
		questionDtls.setQuesName("Which of the following is used to create web page?");
		questionDtls.setQuesOpt1("a. C Language");
		questionDtls.setQuesOpt2("b. DTD Language");
		questionDtls.setQuesOpt3("c. JVM Language");
		questionDtls.setQuesOpt4("d. HTML Language");
		questionDtls.setQuesCorrectOpt("2");
		questionDtls.setSeqNo(null);
		questionDtls.setTime(Integer.parseInt("22"));
		questionDtls = viewEditQuestionDAO.editQuestion(questionDtls, session);
		assertNotNull(questionDtls);
		
	}
	
	@Test
	public void testDelQuestions() throws Exception{
		 
		 when(request.getParameter("actionName")).thenReturn("deleteQuestion");
		 when(request.getParameter("examId")).thenReturn("101");
		 when(request.getParameter("examName")).thenReturn("HTML");
		 when(request.getParameter("quesNum")).thenReturn("1");
		 
		 String pageName = viewEditQuestions.businessMethod(request, session);
		 assertEquals("viewQues",pageName);
	}
}
