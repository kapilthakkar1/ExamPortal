package com.ssdi.app.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.AddQuestionDAO;
import com.ssdi.app.dao.AddQuestionDAOImpl;
import com.ssdi.app.dao.ViewExamsDAO;
import com.ssdi.app.dao.ViewExamsDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.QuestionDtls;
import com.ssdi.util.RequestUtils;


public class AddQuestions implements BusinessClassInterface {
	
	
	public String businessMethod(HttpServletRequest request,Session session) throws Exception
	{
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		String pageName = "";
		
		if(actionName.equals("viewExams"))
		{
			ViewExamsDAO dao = new ViewExamsDAOImpl();
			String searchStr=RequestUtils.getStringFromRequest(request, "searchStr");
			List result = (List) dao.getExamAdmin(searchStr, session);//(session);
			request.setAttribute("examlist", result);
			request.setAttribute("searchStr", searchStr);
			pageName = "addEditQues";
		}
		else if(actionName.equals("addQuestion"))
		{
			String examId=RequestUtils.getStringFromRequest(request, "examId");
			request.setAttribute("examId", examId);
			String examName=RequestUtils.getStringFromRequest(request, "examName");
			request.setAttribute("examName", examName);
			pageName = "addQuestion";
		}
		else if(actionName.equals("saveQuestion"))
		{
			String question=RequestUtils.getStringFromRequest(request, "question");
			String option1=RequestUtils.getStringFromRequest(request, "Option1");
			String option2=RequestUtils.getStringFromRequest(request, "Option2");
			String option3=RequestUtils.getStringFromRequest(request, "Option3");
			String option4=RequestUtils.getStringFromRequest(request, "Option4");
			String answer=RequestUtils.getStringFromRequest(request, "answer");
			String examId=RequestUtils.getStringFromRequest(request, "examId");
			String examName=RequestUtils.getStringFromRequest(request, "examName");
			String time=RequestUtils.getStringFromRequest(request, "time");
			QuestionDtls questionDtls = new QuestionDtls();
			AddQuestionDAO addQuestionDAO =new AddQuestionDAOImpl();
			questionDtls.setExamId(Long.parseLong(examId));
			questionDtls.setQuesName(question);
			questionDtls.setQuesOpt1(option1);
			questionDtls.setQuesOpt2(option2);
			questionDtls.setQuesOpt3(option3);
			questionDtls.setQuesOpt4(option4);
			questionDtls.setQuesCorrectOpt(answer);
			questionDtls.setSeqNo(null);
			questionDtls.setTime(Integer.parseInt(time));
			addQuestionDAO.saveQuestion(questionDtls, session);
			request.setAttribute("SuccessMsg","Question Successfully Added to "+ examName);
			request.setAttribute("examId", examId);
			request.setAttribute("examName", examName);
			pageName = "addQuestion";
		}
		
		
		return pageName;
	}

}
