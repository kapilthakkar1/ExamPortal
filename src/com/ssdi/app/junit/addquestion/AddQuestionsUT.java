package com.ssdi.app.junit.addquestion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.junit.Test;

import com.ssdi.app.business.AddQuestions;
import com.ssdi.app.dao.AddQuestionDAO;
import com.ssdi.app.dao.AddQuestionDAOImpl;
import com.ssdi.tables.QuestionDtls;
import com.ssdi.util.HibernateUtil;

public class AddQuestionsUT {

	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	AddQuestions addquestions = new AddQuestions();
	 

	@Test
	public void testAddQuestions() throws Exception{
		 
		 when(request.getParameter("actionName")).thenReturn("addQuestion");
		 when(request.getParameter("examId")).thenReturn("101");
		 when(request.getParameter("examName")).thenReturn("HTML");
		 String pageName = addquestions.businessMethod(request, session);
		 assertEquals("addQuestion",pageName);
	   }
	@Test
	public void testDAOSaveQues() throws Exception
	{
		//public QuestionDtls saveQuestion(QuestionDtls questionDtls,Session session);
		AddQuestionDAO addQuestionDAO =new AddQuestionDAOImpl();
		QuestionDtls questionDtls= new QuestionDtls();
		questionDtls.setExamId(101);
		questionDtls.setQuesName("Test Ques");
		questionDtls.setQuesOpt1("Test 1");
		questionDtls.setQuesOpt2("Test 2");
		questionDtls.setQuesOpt3("Test 3");
		questionDtls.setQuesOpt4("Test 4");
		questionDtls.setQuesCorrectOpt("Test 2");
		questionDtls.setSeqNo(null);
		questionDtls.setTime(21);
		questionDtls = addQuestionDAO.saveQuestion(questionDtls, session);
		assertNotNull(questionDtls);
	}
}
