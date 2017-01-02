package com.ssdi.app.business;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.EditExamDAO;
import com.ssdi.app.dao.EditExamDAOImpl;
import com.ssdi.app.dao.ViewExamsDAO;
import com.ssdi.app.dao.ViewExamsDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.ExamDtls;
import com.ssdi.util.RequestUtils;

public class EditExam implements BusinessClassInterface {

	@Override
	public String businessMethod(HttpServletRequest request, Session session)
			throws Exception {
		String pageName = "";
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		String examId = "";
		if(actionName.equals("viewExistExam"))
		{
			examId=RequestUtils.getStringFromRequest(request, "examId");
			EditExamDAO editExamDAO = new EditExamDAOImpl();
			ExamDtls examDtls = editExamDAO.fetchExam(Long.parseLong(examId), session);
			request.setAttribute("examDtls", examDtls);
			pageName = "editExam";
		}
		if(actionName.equals("updateExam"))
		{
			String exam_name =RequestUtils.getStringFromRequest(request, "examName");
			String exam_description=RequestUtils.getStringFromRequest(request, "examDescription");
			int cutoff=Integer.parseInt(RequestUtils.getStringFromRequest(request, "cutoff"));
			String certificateName=RequestUtils.getStringFromRequest(request, "certificateName");
			String noOfQues=RequestUtils.getStringFromRequest(request, "noOfQues");
			examId = RequestUtils.getStringFromRequest(request, "examId");		

			ExamDtls ExamDtls = new ExamDtls();
			ExamDtls.setExamId(Long.parseLong(examId));
			ExamDtls.setExamName(exam_name);
			ExamDtls.setExamDescr(exam_description);
			ExamDtls.setcrtdate(new Date());
			ExamDtls.setcutoff(cutoff);
			ExamDtls.setcertificateName(certificateName);
			ExamDtls.setNoOfQuestion(Integer.parseInt(noOfQues));
			EditExamDAO editExamDAO = new EditExamDAOImpl();
			editExamDAO.editExam(ExamDtls, session);
			pageName = "editExam";
			request.setAttribute("editMessage", "yes");
			request.setAttribute("examDtls", ExamDtls);
		}
		if(actionName.equals("viewExams"))
		{
			ViewExamsDAO dao = new ViewExamsDAOImpl();
			String searchStr=RequestUtils.getStringFromRequest(request, "searchStr");
			List result = (List) dao.getExamAdmin(searchStr, session);//(session);
			request.setAttribute("examlist", result);
			request.setAttribute("searchStr", searchStr);
			pageName = "examPageAdmin";
		}
		return pageName;
	}



}
