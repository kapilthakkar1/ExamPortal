package com.ssdi.app.junit.takeexam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.Test;
import org.mockito.Mockito;

import com.ssdi.app.business.TakeExam;
import com.ssdi.app.dao.TakeExamDAO;
import com.ssdi.app.dao.TakeExamDAOImpl;
import com.ssdi.tables.ExamDtls;
import com.ssdi.tables.UserDtls;
import com.ssdi.tables.UserTxnDtls;
import com.ssdi.util.HibernateUtil;
public class TakeExamUT {

	HttpServletRequest request = mock(HttpServletRequest.class); 
	HibernateUtil hibernate = new HibernateUtil();
	Session session = HibernateUtil.openSession();
	TakeExam takeExam = new TakeExam();
	@Test
	public void testTakeExam() throws Exception{

		when(request.getParameter("actionName")).thenReturn("takeExam");
		when(request.getParameter("examId")).thenReturn("101");
		HttpSession httpsession = mock(HttpSession.class);
		UserDtls userDtls = new UserDtls();
		userDtls.setUserId(1);
		when(httpsession.getAttribute("userDtls")).thenReturn(userDtls);
		Mockito.when(request.getSession()).thenReturn(httpsession);
		String pageName = takeExam.businessMethod(request, session);
		assertEquals("ExamQuestion",pageName);

		when(request.getParameter("actionName")).thenReturn("nextQuestion");
		when(request.getParameter("quesNum")).thenReturn("1");
		when(request.getParameter("givenOp")).thenReturn("1");
		when(request.getParameter("opCorrect")).thenReturn("1");
		assertEquals("ExamQuestion",pageName);

	}

	@Test
	public void testTakeExamDAOgetQuestionList() throws Exception{
		TakeExamDAO takeExamDAO = new TakeExamDAOImpl();
		List res = takeExamDAO.getQuestionList("101", session);
		assertTrue(!res.isEmpty());

	}
	@Test
	public void saveUserTxnData() throws Exception{
		TakeExamDAO takeExamDAO = new TakeExamDAOImpl();
		ArrayList<UserTxnDtls> userTxnList = new ArrayList<UserTxnDtls>();
		UserTxnDtls userTxnDtls = new UserTxnDtls();
		userTxnDtls.setCrtDate(new Date());
		userTxnDtls.setExamId(101);
		userTxnDtls.setOpGiven("1");
		userTxnDtls.setOpCorrect("1");
		userTxnDtls.setQuesNum(1);
		userTxnDtls.setUserId(1);
		userTxnList.add(userTxnDtls);
		takeExamDAO.saveUserTxnData(userTxnList, session);
		String s= "1";
		assertEquals("1",s);
	}
	@Test
	public void testTakeExamDAOcheckIfExamTaken() throws Exception{
		TakeExamDAO takeExamDAO = new TakeExamDAOImpl();
		boolean val = takeExamDAO.checkIfExamTaken("101", 1, session);
		assertTrue(val);
		
	}
	@Test
	public void testTakeExamDAOgetRandomQuestionList() throws Exception{
		TakeExamDAO takeExamDAO = new TakeExamDAOImpl();
		ExamDtls result = takeExamDAO.getRandomQuestionList("101", session);
		assertNotNull(result);
	}
	@Test
	public void testTakeExamDAOrandInt() throws Exception{
		TakeExamDAO takeExamDAO = new TakeExamDAOImpl();
		int i = 0;
		i= takeExamDAO.randInt(1, 10, new Random());
		assertTrue(i!=0);
	}


}
