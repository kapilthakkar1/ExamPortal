package com.ssdi.app.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.CreateExamDAO;
import com.ssdi.app.dao.CreateExamDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.ExamDtls;
import com.ssdi.util.RequestUtils;

public class CreateExam1 implements BusinessClassInterface{
	

	
	
	@Override
	public String businessMethod(HttpServletRequest request, Session session)
			throws Exception {
		
		
		
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		System.out.print("createexam : "+actionName);
		String pageName = "";
		if(actionName.equals("createexam"))
		{
		String exam_name =RequestUtils.getStringFromRequest(request, "examName");
		String exam_description=RequestUtils.getStringFromRequest(request, "examDescription");
		int cutoff=Integer.parseInt(RequestUtils.getStringFromRequest(request, "cutoff"));
		String certificateName=RequestUtils.getStringFromRequest(request, "certificateName");
		String noOfQues=RequestUtils.getStringFromRequest(request, "noOfQues");
				
		
		ExamDtls ExamDtls = new ExamDtls();
		ExamDtls.setExamName(exam_name);
		ExamDtls.setExamDescr(exam_description);
		ExamDtls.setcrtdate(new Date());
		ExamDtls.setcutoff(cutoff);
		ExamDtls.setcertificateName(certificateName);
		ExamDtls.setNoOfQuestion(Integer.parseInt(noOfQues));
		CreateExamDAO createExamDAO = new CreateExamDAOImpl();
		createExamDAO.createexam( ExamDtls, session);
		request.setAttribute("creationMessage", "Exam is created Successfully");
		pageName = "CreateExamPage";
		}
		else if(actionName.equals("displayExam"))
		{
			pageName = "CreateExamPage";
		}
		return pageName;
	}
 
}
