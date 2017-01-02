package com.ssdi.app.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.AddQuestionDAO;
import com.ssdi.app.dao.AddQuestionDAOImpl;
import com.ssdi.app.dao.ViewEditQuestionDAO;
import com.ssdi.app.dao.ViewEditQuestionDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.QuestionDtls;
import com.ssdi.util.RequestUtils;


public class ViewEditQuestions implements BusinessClassInterface {
	
	
	public String businessMethod(HttpServletRequest request,Session session) throws Exception
	{
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		String pageName = "";
		
		
		if(actionName.equals("viewQuestions"))
		{
			String examId=RequestUtils.getStringFromRequest(request, "examId");
			request.setAttribute("examId", examId);
			String examName=RequestUtils.getStringFromRequest(request, "examName");
			request.setAttribute("examName", examName);
			ViewEditQuestionDAO questionDAO = new ViewEditQuestionDAOImpl();
			List questionList  = questionDAO.viewQuestions(Long.parseLong(examId), session);
			request.setAttribute("questionList", questionList);
			pageName = "viewQues";
		}
		else if(actionName.equals("updateQuestion"))
		{
			String question=RequestUtils.getStringFromRequest(request, "question");
			String option1=RequestUtils.getStringFromRequest(request, "Option1");
			String option2=RequestUtils.getStringFromRequest(request, "Option2");
			String option3=RequestUtils.getStringFromRequest(request, "Option3");
			String option4=RequestUtils.getStringFromRequest(request, "Option4");
			String answer=RequestUtils.getStringFromRequest(request, "answer");
			String examId=RequestUtils.getStringFromRequest(request, "examId");
			String examName=RequestUtils.getStringFromRequest(request, "examName");
			String quesNum=RequestUtils.getStringFromRequest(request, "quesNum");
			
			String time=RequestUtils.getStringFromRequest(request, "time");
			QuestionDtls questionDtls = new QuestionDtls();
			ViewEditQuestionDAO questionDAO = new ViewEditQuestionDAOImpl();
			questionDtls.setQuestionNum(Long.parseLong(quesNum));
			questionDtls.setExamId(Long.parseLong(examId));
			questionDtls.setQuesName(question);
			questionDtls.setQuesOpt1(option1);
			questionDtls.setQuesOpt2(option2);
			questionDtls.setQuesOpt3(option3);
			questionDtls.setQuesOpt4(option4);
			questionDtls.setQuesCorrectOpt(answer);
			questionDtls.setSeqNo(null);
			questionDtls.setTime(Integer.parseInt(time));
			questionDAO.editQuestion(questionDtls, session);
			List questionList  = questionDAO.viewQuestions(Long.parseLong(examId), session);
			request.setAttribute("questionList", questionList);
			request.setAttribute("SuccessMsg","Question Successfully Updated.");
			request.setAttribute("examId", examId);
			request.setAttribute("examName", examName);
			pageName = "viewQues";
		}
		else if(actionName.equals("deleteQuestion"))
		{
			String quesNum=RequestUtils.getStringFromRequest(request, "quesNum");
			String examId=RequestUtils.getStringFromRequest(request, "examId");
			String examName=RequestUtils.getStringFromRequest(request, "examName");
			
			ViewEditQuestionDAO questionDAO = new ViewEditQuestionDAOImpl();
			questionDAO.deleteQuestions(Long.parseLong(quesNum), session);
			List questionList  = questionDAO.viewQuestions(Long.parseLong(examId), session);
			request.setAttribute("questionList", questionList);
			request.setAttribute("SuccessMsg","Question Successfully Updated.");
			request.setAttribute("examId", examId);
			request.setAttribute("examName", examName);
			pageName = "viewQues";
		}
		
		
		return pageName;
	}

}
