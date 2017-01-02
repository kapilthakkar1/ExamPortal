package com.ssdi.app.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.TakeExamDAO;
import com.ssdi.app.dao.TakeExamDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.ExamDtls;
import com.ssdi.tables.UserDtls;
import com.ssdi.tables.UserTxnDtls;
import com.ssdi.util.RequestUtils;


public class TakeExam implements BusinessClassInterface {


	public String businessMethod(HttpServletRequest request,Session session) throws Exception
	{
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		String pageName = "";
		String examId = "";

		if(actionName.equals("takeExam"))
		{
			examId=RequestUtils.getStringFromRequest(request, "examId");
			String examName=RequestUtils.getStringFromRequest(request, "examName");
			TakeExamDAO takeExamDAO = new TakeExamDAOImpl();
			UserDtls userDtls  = (UserDtls)request.getSession().getAttribute("userDtls");
			boolean examTaken = takeExamDAO.checkIfExamTaken(examId, userDtls.getUserId(), session);
			if(examTaken)
			{
				request.setAttribute("examComplete", "examCompleted");
				request.setAttribute("alreadyGiven", "alreadyGiven");
				request.getSession().setAttribute("questionList", new ArrayList());
			}
			else
			{
			//List questionList = takeExamDAO.getQuestionList(examId, session);
			ExamDtls examDtls = takeExamDAO.getRandomQuestionList(examId, session);
			request.getSession().setAttribute("questionList", examDtls.getQuestionList());
			}
			request.getSession().setAttribute("seqNo","0");
			request.getSession().setAttribute("examName",examName);
			pageName = "ExamQuestion";
		}
		if(actionName.equals("nextQuestion"))
		{
			long seqNO = Long.parseLong(request.getSession().getAttribute("seqNo").toString());
			request.getSession().setAttribute("seqNo",(seqNO+1));
			List questionList = (ArrayList)request.getSession().getAttribute("questionList");
			UserDtls userDtls=(UserDtls)request.getSession().getAttribute("userDtls");
			
			String quesNum=RequestUtils.getStringFromRequest(request, "quesNum");
			String opGiven=RequestUtils.getStringFromRequest(request, "givenOp");
			String opCorrect=RequestUtils.getStringFromRequest(request, "opCorrect");
			examId=RequestUtils.getStringFromRequest(request, "examId");
			
			ArrayList<UserTxnDtls> userTxnList = new ArrayList<UserTxnDtls>();; 
			UserTxnDtls userTxnDtls = new UserTxnDtls();
			if(seqNO==0)
			{
				if(request.getSession().getAttribute("userTxnList")!=null)
				{
				request.getSession().removeAttribute("userTxnList");
				}
				
				
			}
			else
			{
				userTxnList = (ArrayList<UserTxnDtls>)request.getSession().getAttribute("userTxnList");
			}
			userTxnDtls.setCrtDate(new Date());
			userTxnDtls.setExamId(Long.parseLong(examId));
			userTxnDtls.setOpGiven(opGiven);
			userTxnDtls.setOpCorrect(opCorrect);
			userTxnDtls.setQuesNum(Long.parseLong(quesNum));
			userTxnDtls.setUserId(userDtls.getUserId());
			userTxnList.add(userTxnDtls);

			request.getSession().setAttribute("userTxnList",userTxnList);
			if(seqNO==(questionList.size()-1))
			{
				TakeExamDAO takeExamDAO = new TakeExamDAOImpl();
				takeExamDAO.saveUserTxnData(userTxnList, session);
				request.setAttribute("examId", examId);
				request.setAttribute("examComplete", "examCompleted");
				request.getSession().removeAttribute("userTxnList");
			}
			pageName = "ExamQuestion";

		}
		return pageName;
	}

}
